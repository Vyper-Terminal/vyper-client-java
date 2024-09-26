package com.vyper.sdk;

import com.vyper.sdk.exceptions.VyperApiException;
import com.vyper.sdk.models.TokenATH;
import com.vyper.sdk.models.TokenHolder;
import com.vyper.sdk.models.TokenMarket;
import com.vyper.sdk.models.TokenMetadata;
import com.vyper.sdk.models.TokenPair;
import com.vyper.sdk.models.TokenPairs;
import com.vyper.sdk.models.TokenPairsParams;
import com.vyper.sdk.models.TokenSearchResult;
import com.vyper.sdk.models.TokenSymbol;
import com.vyper.sdk.models.TopTrader;
import com.vyper.sdk.models.WalletAggregatedPnL;
import com.vyper.sdk.models.WalletHolding;
import com.vyper.sdk.models.WalletPnL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class VyperClientTest {
    @Mock
    private VyperClient vyperClient;

    private AutoCloseable closeable;

    @Before
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testGetChainIds() throws VyperApiException {
        VyperClient client = new VyperClient("my-api-key");
        Map<String, Integer> expectedChainIds = new HashMap<>();
        expectedChainIds.put("solana", 900);
        expectedChainIds.put("tron", 1000);
        expectedChainIds.put("ethereum", 1);
        expectedChainIds.put("base", 8453);
        expectedChainIds.put("arbitrum", 42161);
        expectedChainIds.put("bsc", 56);
        expectedChainIds.put("blast", 81457);

        Map<String, Integer> actualChainIds = client.getChainIds();

        assertEquals(expectedChainIds, actualChainIds);
    }

    @Test
    public void testGetTokenAth() throws VyperApiException {
        int chainId = 1;
        String marketId = "test-market";
        TokenATH expectedTokenAth = new TokenATH();
        expectedTokenAth.setMarketCapUsd(1000000.0);
        expectedTokenAth.setTimestamp(1632150400000L);
        expectedTokenAth.setTokenLiquidityUsd(500000.0);

        when(vyperClient.getTokenAth(chainId, marketId)).thenReturn(expectedTokenAth);

        TokenATH actualTokenAth = vyperClient.getTokenAth(chainId, marketId);

        assertNotNull(actualTokenAth);
        assertEquals(expectedTokenAth.getMarketCapUsd(), actualTokenAth.getMarketCapUsd(), 0.001);
        assertEquals(expectedTokenAth.getTimestamp(), actualTokenAth.getTimestamp());
        assertEquals(expectedTokenAth.getTokenLiquidityUsd(), actualTokenAth.getTokenLiquidityUsd(), 0.001);

        verify(vyperClient).getTokenAth(chainId, marketId);
    }

    @Test(expected = VyperApiException.class)
    public void testGetTokenAth_InvalidMarketId() throws VyperApiException {
        VyperClient client = new VyperClient("my-api-key");
        int chainId = 1;
        String marketId = null;

        client.getTokenAth(chainId, marketId);
    }

    @Test
    public void testGetTokenMarket() throws VyperApiException {
        String marketId = "test-market";
        int chainId = 1;
        String interval = "1h";

        TokenPair expectedTokenPair = new TokenPair();
        expectedTokenPair.setMarketId(marketId);
        expectedTokenPair.setChainId(chainId);
        expectedTokenPair.setTokenPriceUsd(10.5);
        expectedTokenPair.setTokenMarketCapUsd(1000000.0);

        when(vyperClient.getTokenMarket(marketId, chainId, interval)).thenReturn(expectedTokenPair);

        TokenPair actualTokenPair = vyperClient.getTokenMarket(marketId, chainId, interval);

        assertNotNull(actualTokenPair);
        assertEquals(expectedTokenPair.getMarketId(), actualTokenPair.getMarketId());
        assertEquals(expectedTokenPair.getChainId(), actualTokenPair.getChainId());
        assertEquals(expectedTokenPair.getTokenPriceUsd(), actualTokenPair.getTokenPriceUsd(), 0.001);
        assertEquals(expectedTokenPair.getTokenMarketCapUsd(), actualTokenPair.getTokenMarketCapUsd(), 0.001);

        verify(vyperClient).getTokenMarket(marketId, chainId, interval);
    }

    @Test
    public void testGetTokenHolders() throws VyperApiException {
        int chainId = 1;
        String marketId = "test-market";
        List<TokenHolder> expectedHolders = new ArrayList<>();
        TokenHolder holder = new TokenHolder();
        holder.setPercentOwned(10.5);
        holder.setTokenHoldings(1000.0);
        holder.setUsdHoldings(5000.0);
        holder.setWalletAddress("0x1234567890abcdef");
        holder.setWalletTag("Whale");
        expectedHolders.add(holder);

        when(vyperClient.getTokenHolders(marketId, chainId)).thenReturn(expectedHolders);

        List<TokenHolder> actualHolders = vyperClient.getTokenHolders(marketId, chainId);

        assertNotNull(actualHolders);
        assertEquals(1, actualHolders.size());
        TokenHolder actualHolder = actualHolders.get(0);
        assertEquals(holder.getPercentOwned(), actualHolder.getPercentOwned(), 0.001);
        assertEquals(holder.getTokenHoldings(), actualHolder.getTokenHoldings(), 0.001);
        assertEquals(holder.getUsdHoldings(), actualHolder.getUsdHoldings(), 0.001);
        assertEquals(holder.getWalletAddress(), actualHolder.getWalletAddress());
        assertEquals(holder.getWalletTag(), actualHolder.getWalletTag());

        verify(vyperClient).getTokenHolders(marketId, chainId);
    }

    @Test(expected = VyperApiException.class)
    public void testGetTokenHolders_InvalidMarketId() throws VyperApiException {
        VyperClient client = new VyperClient("my-api-key");
        int chainId = 1;
        String marketId = null;

        client.getTokenHolders(marketId, chainId);
    }

    @Test
    public void testGetTokenMarkets() throws VyperApiException {
        int chainId = 1;
        String tokenMint = "test-token-mint";
        List<TokenMarket> expectedMarkets = new ArrayList<>();
        TokenMarket market = new TokenMarket();
        market.setMarketCapUsd(1000000.0);
        market.setMarketID("test-market");
        market.setTokenLiquidityUsd(500000.0);
        market.setTokenType("fungible");
        expectedMarkets.add(market);

        when(vyperClient.getTokenMarkets(tokenMint, chainId)).thenReturn(expectedMarkets);

        List<TokenMarket> actualMarkets = vyperClient.getTokenMarkets(tokenMint, chainId);

        assertNotNull(actualMarkets);
        assertEquals(1, actualMarkets.size());
        TokenMarket actualMarket = actualMarkets.get(0);
        assertEquals(market.getMarketCapUsd(), actualMarket.getMarketCapUsd(), 0.001);
        assertEquals(market.getMarketID(), actualMarket.getMarketID());
        assertEquals(market.getTokenLiquidityUsd(), actualMarket.getTokenLiquidityUsd(), 0.001);
        assertEquals(market.getTokenType(), actualMarket.getTokenType());

        verify(vyperClient).getTokenMarkets(tokenMint, chainId);
    }

    @Test
    public void testGetTokenMetadata() throws VyperApiException {
        int chainId = 1;
        String tokenMint = "test-token-mint";
        TokenMetadata expectedMetadata = new TokenMetadata();
        expectedMetadata.setName("Test Token");
        expectedMetadata.setSymbol("TST");
        expectedMetadata.setImage("https://example.com/image.png");
        expectedMetadata.setTelegram("https://t.me/testtoken");
        expectedMetadata.setTwitter("https://twitter.com/testtoken");
        expectedMetadata.setWebsite("https://testtoken.com");

        when(vyperClient.getTokenMetadata(chainId, tokenMint)).thenReturn(expectedMetadata);

        TokenMetadata actualMetadata = vyperClient.getTokenMetadata(chainId, tokenMint);

        assertNotNull(actualMetadata);
        assertEquals(expectedMetadata.getName(), actualMetadata.getName());
        assertEquals(expectedMetadata.getSymbol(), actualMetadata.getSymbol());
        assertEquals(expectedMetadata.getImage(), actualMetadata.getImage());
        assertEquals(expectedMetadata.getTelegram(), actualMetadata.getTelegram());
        assertEquals(expectedMetadata.getTwitter(), actualMetadata.getTwitter());
        assertEquals(expectedMetadata.getWebsite(), actualMetadata.getWebsite());

        verify(vyperClient).getTokenMetadata(chainId, tokenMint);
    }

    @Test
    public void testGetTokenSymbol() throws VyperApiException {
        int chainId = 1;
        String tokenMint = "test-token-mint";
        TokenSymbol expectedSymbol = new TokenSymbol();
        expectedSymbol.setSymbol("TST");

        when(vyperClient.getTokenSymbol(chainId, tokenMint)).thenReturn(expectedSymbol);

        TokenSymbol actualSymbol = vyperClient.getTokenSymbol(chainId, tokenMint);

        assertNotNull(actualSymbol);
        assertEquals(expectedSymbol.getSymbol(), actualSymbol.getSymbol());

        verify(vyperClient).getTokenSymbol(chainId, tokenMint);
    }

    @Test
    public void testGetTopTraders() throws VyperApiException {
        String marketId = "test-market";
        int chainId = 1;
        List<TopTrader> expectedTraders = new ArrayList<>();
        TopTrader trader = new TopTrader();
        trader.setWalletAddress("0x1234567890abcdef");
        trader.setWalletTag("Whale");
        trader.setInvestedAmountTokens(1000.0);
        trader.setInvestedAmountUsd(10000.0);
        trader.setInvestedTxns(5);
        trader.setPnlUsd(2000.0);
        trader.setRemainingTokens(800.0);
        trader.setRemainingUsd(9000.0);
        trader.setSoldAmountTokens(200.0);
        trader.setSoldAmountUsd(3000.0);
        trader.setSoldTxns(2);
        expectedTraders.add(trader);

        when(vyperClient.getTopTraders(marketId, chainId)).thenReturn(expectedTraders);

        List<TopTrader> actualTraders = vyperClient.getTopTraders(marketId, chainId);

        assertNotNull(actualTraders);
        assertEquals(1, actualTraders.size());
        TopTrader actualTrader = actualTraders.get(0);
        assertEquals(trader.getWalletAddress(), actualTrader.getWalletAddress());
        assertEquals(trader.getWalletTag(), actualTrader.getWalletTag());
        assertEquals(trader.getInvestedAmountTokens(), actualTrader.getInvestedAmountTokens(), 0.001);
        assertEquals(trader.getInvestedAmountUsd(), actualTrader.getInvestedAmountUsd(), 0.001);
        assertEquals(trader.getInvestedTxns(), actualTrader.getInvestedTxns());
        assertEquals(trader.getPnlUsd(), actualTrader.getPnlUsd(), 0.001);
        assertEquals(trader.getRemainingTokens(), actualTrader.getRemainingTokens(), 0.001);
        assertEquals(trader.getRemainingUsd(), actualTrader.getRemainingUsd(), 0.001);
        assertEquals(trader.getSoldAmountTokens(), actualTrader.getSoldAmountTokens(), 0.001);
        assertEquals(trader.getSoldAmountUsd(), actualTrader.getSoldAmountUsd(), 0.001);
        assertEquals(trader.getSoldTxns(), actualTrader.getSoldTxns());

        verify(vyperClient).getTopTraders(marketId, chainId);
    }

    @Test
    public void testSearchTokens() throws VyperApiException {
        String criteria = "test";
        Integer chainId = 1;
        List<TokenSearchResult> expectedResults = new ArrayList<>();
        TokenSearchResult result = new TokenSearchResult();
        result.setChainId(1);
        result.setMarketId("test-market");
        result.setCreatedTimestamp(1634567890000L);
        result.setName("Test Token");
        result.setSymbol("TST");
        result.setTokenMint("test-token-mint");
        result.setTokenType("fungible");
        result.setPercentChange24h(5.5);
        result.setPooledAsset(1000000.0);
        result.setTokenLiquidityUsd(500000.0);
        result.setTokenMarketCapUsd(10000000.0);
        result.setTokenPriceUsd(1.5);
        result.setVolumeUsd(750000.0);
        result.setImage("https://example.com/image.png");
        result.setTelegram("https://t.me/testtoken");
        result.setTwitter("https://twitter.com/testtoken");
        result.setWebsite("https://testtoken.com");
        expectedResults.add(result);

        when(vyperClient.searchTokens(criteria, chainId)).thenReturn(expectedResults);

        List<TokenSearchResult> actualResults = vyperClient.searchTokens(criteria, chainId);

        assertNotNull(actualResults);
        assertEquals(1, actualResults.size());
        TokenSearchResult actualResult = actualResults.get(0);
        assertEquals(result.getChainId(), actualResult.getChainId());
        assertEquals(result.getMarketId(), actualResult.getMarketId());
        assertEquals(result.getCreatedTimestamp(), actualResult.getCreatedTimestamp());
        assertEquals(result.getName(), actualResult.getName());
        assertEquals(result.getSymbol(), actualResult.getSymbol());
        assertEquals(result.getTokenMint(), actualResult.getTokenMint());
        assertEquals(result.getTokenType(), actualResult.getTokenType());
        assertEquals(result.getPercentChange24h(), actualResult.getPercentChange24h(), 0.001);
        assertEquals(result.getPooledAsset(), actualResult.getPooledAsset(), 0.001);
        assertEquals(result.getTokenLiquidityUsd(), actualResult.getTokenLiquidityUsd(), 0.001);
        assertEquals(result.getTokenMarketCapUsd(), actualResult.getTokenMarketCapUsd(), 0.001);
        assertEquals(result.getTokenPriceUsd(), actualResult.getTokenPriceUsd(), 0.001);
        assertEquals(result.getVolumeUsd(), actualResult.getVolumeUsd(), 0.001);
        assertEquals(result.getImage(), actualResult.getImage());
        assertEquals(result.getTelegram(), actualResult.getTelegram());
        assertEquals(result.getTwitter(), actualResult.getTwitter());
        assertEquals(result.getWebsite(), actualResult.getWebsite());

        verify(vyperClient).searchTokens(criteria, chainId);
    }

    @Test
    public void testGetWalletHoldings() throws VyperApiException {
        String walletAddress = "0x1234567890abcdef";
        int chainId = 1;
        List<WalletHolding> expectedHoldings = new ArrayList<>();
        WalletHolding holding = new WalletHolding();
        holding.setMarketId("test-market");
        holding.setTokenHoldings(1000.0);
        holding.setTokenSymbol("TST");
        holding.setUsdValue(5000.0);
        expectedHoldings.add(holding);

        when(vyperClient.getWalletHoldings(walletAddress, chainId)).thenReturn(expectedHoldings);

        List<WalletHolding> actualHoldings = vyperClient.getWalletHoldings(walletAddress, chainId);

        assertNotNull(actualHoldings);
        assertEquals(1, actualHoldings.size());
        WalletHolding actualHolding = actualHoldings.get(0);
        assertEquals(holding.getMarketId(), actualHolding.getMarketId());
        assertEquals(holding.getTokenHoldings(), actualHolding.getTokenHoldings(), 0.001);
        assertEquals(holding.getTokenSymbol(), actualHolding.getTokenSymbol());
        assertEquals(holding.getUsdValue(), actualHolding.getUsdValue(), 0.001);

        verify(vyperClient).getWalletHoldings(walletAddress, chainId);
    }

    @Test
    public void testGetWalletAggregatedPnl() throws VyperApiException {
        String walletAddress = "0x1234567890abcdef";
        int chainId = 1;
        WalletAggregatedPnL expectedPnL = new WalletAggregatedPnL();
        expectedPnL.setInvestedAmount(10000.0);
        expectedPnL.setPnlPercent(20.0);
        expectedPnL.setPnlUsd(2000.0);
        expectedPnL.setSoldAmount(5000.0);
        expectedPnL.setTokensTraded(5);
        expectedPnL.setTotalPnlPercent(25.0);
        expectedPnL.setTotalPnlUsd(2500.0);
        expectedPnL.setUnrealizedPnlPercent(5.0);
        expectedPnL.setUnrealizedPnlUsd(500.0);

        when(vyperClient.getWalletAggregatedPnl(walletAddress, chainId)).thenReturn(expectedPnL);

        WalletAggregatedPnL actualPnL = vyperClient.getWalletAggregatedPnl(walletAddress, chainId);

        assertNotNull(actualPnL);
        assertEquals(expectedPnL.getInvestedAmount(), actualPnL.getInvestedAmount(), 0.001);
        assertEquals(expectedPnL.getPnlPercent(), actualPnL.getPnlPercent(), 0.001);
        assertEquals(expectedPnL.getPnlUsd(), actualPnL.getPnlUsd(), 0.001);
        assertEquals(expectedPnL.getSoldAmount(), actualPnL.getSoldAmount(), 0.001);
        assertEquals(expectedPnL.getTokensTraded(), actualPnL.getTokensTraded());
        assertEquals(expectedPnL.getTotalPnlPercent(), actualPnL.getTotalPnlPercent(), 0.001);
        assertEquals(expectedPnL.getTotalPnlUsd(), actualPnL.getTotalPnlUsd(), 0.001);
        assertEquals(expectedPnL.getUnrealizedPnlPercent(), actualPnL.getUnrealizedPnlPercent(), 0.001);
        assertEquals(expectedPnL.getUnrealizedPnlUsd(), actualPnL.getUnrealizedPnlUsd(), 0.001);

        verify(vyperClient).getWalletAggregatedPnl(walletAddress, chainId);
    }

    @Test
    public void testGetWalletPnl() throws VyperApiException {
        String walletAddress = "0x1234567890abcdef";
        String marketId = "test-market";
        int chainId = 1;
        WalletPnL expectedPnL = new WalletPnL();
        expectedPnL.setHolderSince(1634567890000L);
        expectedPnL.setInvestedAmount(10000.0);
        expectedPnL.setInvestedTxns(10);
        expectedPnL.setPnlPercent(20.0);
        expectedPnL.setPnlUsd(2000.0);
        expectedPnL.setRemainingTokens(500.0);
        expectedPnL.setRemainingUsd(7000.0);
        expectedPnL.setSoldAmount(5000.0);
        expectedPnL.setSoldTxns(5);

        when(vyperClient.getWalletPnl(walletAddress, marketId, chainId)).thenReturn(expectedPnL);

        WalletPnL actualPnL = vyperClient.getWalletPnl(walletAddress, marketId, chainId);

        assertNotNull(actualPnL);
        assertEquals(expectedPnL.getHolderSince(), actualPnL.getHolderSince());
        assertEquals(expectedPnL.getInvestedAmount(), actualPnL.getInvestedAmount(), 0.001);
        assertEquals(expectedPnL.getInvestedTxns(), actualPnL.getInvestedTxns());
        assertEquals(expectedPnL.getPnlPercent(), actualPnL.getPnlPercent(), 0.001);
        assertEquals(expectedPnL.getPnlUsd(), actualPnL.getPnlUsd(), 0.001);
        assertEquals(expectedPnL.getRemainingTokens(), actualPnL.getRemainingTokens(), 0.001);
        assertEquals(expectedPnL.getRemainingUsd(), actualPnL.getRemainingUsd(), 0.001);
        assertEquals(expectedPnL.getSoldAmount(), actualPnL.getSoldAmount(), 0.001);
        assertEquals(expectedPnL.getSoldTxns(), actualPnL.getSoldTxns());

        verify(vyperClient).getWalletPnl(walletAddress, marketId, chainId);
    }

    @Test
    public void testGetTokenPairs() throws VyperApiException {
        TokenPairsParams params = new TokenPairsParams();
        params.setAtLeastOneSocial(true);
        params.setBuysMin(100);
        params.setBuysMax(1000);
        params.setChainIds(Arrays.asList(1, 56));
        params.setInterval("1h");
        params.setLiquidityMin(10000.0);
        params.setMarketCapMin(1000000.0);
        params.setPage(1);
        params.setSorting("volume_desc");
        params.setTokenTypes(Arrays.asList("fungible", "non-fungible"));

        TokenPairs expectedTokenPairs = new TokenPairs();
        expectedTokenPairs.setHasNext(true);
        List<TokenPair> pairs = new ArrayList<>();
        TokenPair pair = new TokenPair();
        pair.setMarketId("test-market");
        pair.setChainId(1);
        pair.setTokenPriceUsd(1.5);
        pair.setTokenMarketCapUsd(1500000.0);
        pairs.add(pair);
        expectedTokenPairs.setPairs(pairs);

        when(vyperClient.getTokenPairs(any(TokenPairsParams.class))).thenReturn(expectedTokenPairs);

        TokenPairs actualTokenPairs = vyperClient.getTokenPairs(params);

        assertNotNull(actualTokenPairs);
        assertEquals(expectedTokenPairs.isHasNext(), actualTokenPairs.isHasNext());
        assertNotNull(actualTokenPairs.getPairs());
        assertEquals(1, actualTokenPairs.getPairs().size());
        
        TokenPair actualPair = actualTokenPairs.getPairs().get(0);
        assertEquals(pair.getMarketId(), actualPair.getMarketId());
        assertEquals(pair.getChainId(), actualPair.getChainId());
        assertEquals(pair.getTokenPriceUsd(), actualPair.getTokenPriceUsd(), 0.001);
        assertEquals(pair.getTokenMarketCapUsd(), actualPair.getTokenMarketCapUsd(), 0.001);

        verify(vyperClient).getTokenPairs(argThat(new ArgumentMatcher<TokenPairsParams>() {
            @Override
            public boolean matches(TokenPairsParams argument) {
                return argument.getAtLeastOneSocial().equals(params.getAtLeastOneSocial()) &&
                    argument.getBuysMin().equals(params.getBuysMin()) &&
                    argument.getBuysMax().equals(params.getBuysMax()) &&
                    argument.getChainIds().equals(params.getChainIds()) &&
                    argument.getInterval().equals(params.getInterval()) &&
                    argument.getLiquidityMin().equals(params.getLiquidityMin()) &&
                    argument.getMarketCapMin().equals(params.getMarketCapMin()) &&
                    argument.getPage().equals(params.getPage()) &&
                    argument.getSorting().equals(params.getSorting()) &&
                    argument.getTokenTypes().equals(params.getTokenTypes());
            }
        }));
    }
}

