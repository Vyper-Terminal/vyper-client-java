package com.vyper.sdk;

import com.vyper.sdk.exceptions.*;
import com.vyper.sdk.models.*;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class VyperClient {
    private final String baseUrl;
    private final String apiKey;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public VyperClient(String apiKey) {
        this.baseUrl = "https://api.vyper.trade";
        this.apiKey = apiKey;
        this.httpClient = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    private <T> APIResponse<T> request(String method, String endpoint, Map<String, String> params) throws VyperApiException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl + endpoint).newBuilder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }

        Request.Builder requestBuilder = new Request.Builder()
                .url(urlBuilder.build())
                .method(method, method.equals("GET") ? null : RequestBody.create(new byte[0], null));

        if (apiKey != null) {
            requestBuilder.addHeader("X-API-Key", apiKey);
        }

        try {
            Response response = httpClient.newCall(requestBuilder.build()).execute();
            if (!response.isSuccessful()) {
                handleErrorResponse(response);
            }
            return objectMapper.readValue(response.body().string(), new TypeReference<APIResponse<T>>() {});
        } catch (IOException e) {
            throw new ServerException("An error occurred: " + e.getMessage());
        }
    }

    private void handleErrorResponse(Response response) throws VyperApiException {
        int status = response.code();
        String responseBody = "";
        try {
            responseBody = response.body().string();
        } catch (IOException e) {
            // Ignore
        }

        if (status == 401) {
            throw new AuthenticationException("Invalid or expired API key", status, responseBody);
        } else if (status == 429) {
            String retryAfter = response.header("Retry-After", "3.00");
            throw new RateLimitException("Rate limit exceeded. Please wait " + retryAfter + " seconds before making another request.", Integer.parseInt(retryAfter));
        } else if (status >= 500 && status < 600) {
            throw new ServerException("Server error: " + status, status, responseBody);
        } else {
            throw new VyperApiException("HTTP error occurred: " + status, status, responseBody);
        }
    }

    public Map<String, Integer> getChainIds() throws VyperApiException {
        APIResponse<Map<String, Integer>> response = request("GET", "/api/v1/chain/ids", null);
        return response.getData();
    }

    public TokenATH getTokenAth(int chainId, String marketId) throws VyperApiException {
        if (marketId == null) {
            throw new VyperApiException("Invalid market ID");
        }
        
        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("chainID", String.valueOf(chainId), "marketID", marketId);
        APIResponse<TokenATH> response = request("GET", "/api/v1/token/ath", params);
        return response.getData();
    }

    public TokenPair getTokenMarket(String marketId, int chainId, String interval) throws VyperApiException {
        if (marketId == null) {
            throw new VyperApiException("Invalid market ID");
        }

        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("chainID", String.valueOf(chainId), "interval", interval);
        APIResponse<TokenPair> response = request("GET", "/api/v1/token/market/" + marketId, params);
        return response.getData();
    }

    public List<TokenHolder> getTokenHolders(String marketId, int chainId) throws VyperApiException {
        if (marketId == null) {
            throw new VyperApiException("Invalid market ID");
        }

        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("marketID", marketId, "chainID", String.valueOf(chainId));
        APIResponse<List<TokenHolder>> response = request("GET", "/api/v1/token/holders", params);
        return response.getData();
    }

    public List<TokenMarket> getTokenMarkets(String tokenMint, int chainId) throws VyperApiException {
        if (tokenMint == null) {
            throw new VyperApiException("Invalid token mint");
        }

        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("tokenMint", tokenMint, "chainID", String.valueOf(chainId));
        APIResponse<List<TokenMarket>> response = request("GET", "/api/v1/token/markets", params);
        return response.getData();
    }

    public TokenMetadata getTokenMetadata(int chainId, String tokenMint) throws VyperApiException {
        if (tokenMint == null) {
            throw new VyperApiException("Invalid token mint");
        }

        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("chainID", String.valueOf(chainId), "tokenMint", tokenMint);
        APIResponse<TokenMetadata> response = request("GET", "/api/v1/token/metadata", params);
        return response.getData();
    }

    public TokenSymbol getTokenSymbol(int chainId, String tokenMint) throws VyperApiException {
        if (tokenMint == null) {
            throw new VyperApiException("Invalid token mint");
        }

        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("chainID", String.valueOf(chainId), "tokenMint", tokenMint);
        APIResponse<TokenSymbol> response = request("GET", "/api/v1/token/symbol", params);
        return response.getData();
    }

    public List<TopTrader> getTopTraders(String marketId, int chainId) throws VyperApiException {
        if (marketId == null) {
            throw new VyperApiException("Invalid market ID");
        }

        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = Map.of("marketID", marketId, "chainID", String.valueOf(chainId));
        APIResponse<List<TopTrader>> response = request("GET", "/api/v1/token/top-traders", params);
        return response.getData();
    }

    public List<TokenSearchResult> searchTokens(String criteria, Integer chainId) throws VyperApiException {
        if (apiKey == null) {
            throw new AuthenticationException("API key is required for this endpoint");
        }
        Map<String, String> params = new HashMap<>();
        params.put("criteria", criteria);
        if (chainId != null) {
            params.put("chainID", String.valueOf(chainId));
        }
        APIResponse<List<TokenSearchResult>> response = request("GET", "/api/v1/token/search", params);
        return response.getData();
    }

    public List<WalletHolding> getWalletHoldings(String walletAddress, int chainId) throws VyperApiException {
        if (walletAddress == null) {
            throw new VyperApiException("Invalid wallet address");
        }

        Map<String, String> params = Map.of("walletAddress", walletAddress, "chainID", String.valueOf(chainId));
        APIResponse<List<WalletHolding>> response = request("GET", "/api/v1/wallet/holdings", params);
        return response.getData();
    }

    public WalletAggregatedPnL getWalletAggregatedPnl(String walletAddress, int chainId) throws VyperApiException {
        if (walletAddress == null) {
            throw new VyperApiException("Invalid wallet address");
        }

        Map<String, String> params = Map.of("walletAddress", walletAddress, "chainID", String.valueOf(chainId));
        APIResponse<WalletAggregatedPnL> response = request("GET", "/api/v1/wallet/aggregated-pnl", params);
        return response.getData();
    }

    public WalletPnL getWalletPnl(String walletAddress, String marketId, int chainId) throws VyperApiException {
        if (walletAddress == null) {
            throw new VyperApiException("Invalid wallet address");
        }

        Map<String, String> params = Map.of(
            "walletAddress", walletAddress,
            "marketID", marketId,
            "chainID", String.valueOf(chainId)
        );
        APIResponse<WalletPnL> response = request("GET", "/api/v1/wallet/pnl", params);
        return response.getData();
    }

    public TokenPairs getTokenPairs(TokenPairsParams params) throws VyperApiException {
        Map<String, String> queryParams = new HashMap<>();
        if (params.getAtLeastOneSocial() != null) queryParams.put("atLeastOneSocial", params.getAtLeastOneSocial().toString());
        if (params.getBuysMax() != null) queryParams.put("buysMax", params.getBuysMax().toString());
        if (params.getBuysMin() != null) queryParams.put("buysMin", params.getBuysMin().toString());
        if (params.getChainIds() != null) queryParams.put("chainIds", params.getChainIds().stream().map(Object::toString).collect(Collectors.joining(",")));
        if (params.getFreezeAuthDisabled() != null) queryParams.put("freezeAuthDisabled", params.getFreezeAuthDisabled().toString());
        if (params.getInitialLiquidityMax() != null) queryParams.put("initialLiquidityMax", params.getInitialLiquidityMax().toString());
        if (params.getInitialLiquidityMin() != null) queryParams.put("initialLiquidityMin", params.getInitialLiquidityMin().toString());
        if (params.getInterval() != null) queryParams.put("interval", params.getInterval());
        if (params.getLiquidityMax() != null) queryParams.put("liquidityMax", params.getLiquidityMax().toString());
        if (params.getLiquidityMin() != null) queryParams.put("liquidityMin", params.getLiquidityMin().toString());
        if (params.getLpBurned() != null) queryParams.put("lpBurned", params.getLpBurned().toString());
        if (params.getMarketCapMax() != null) queryParams.put("marketCapMax", params.getMarketCapMax().toString());
        if (params.getMarketCapMin() != null) queryParams.put("marketCapMin", params.getMarketCapMin().toString());
        if (params.getMintAuthDisabled() != null) queryParams.put("mintAuthDisabled", params.getMintAuthDisabled().toString());
        if (params.getPage() != null) queryParams.put("page", params.getPage().toString());
        if (params.getSellsMax() != null) queryParams.put("sellsMax", params.getSellsMax().toString());
        if (params.getSellsMin() != null) queryParams.put("sellsMin", params.getSellsMin().toString());
        if (params.getSorting() != null) queryParams.put("sorting", params.getSorting());
        if (params.getSwapsMax() != null) queryParams.put("swapsMax", params.getSwapsMax().toString());
        if (params.getSwapsMin() != null) queryParams.put("swapsMin", params.getSwapsMin().toString());
        if (params.getTokenTypes() != null) queryParams.put("tokenTypes", String.join(",", params.getTokenTypes()));
        if (params.getTop10Holders() != null) queryParams.put("top10Holders", params.getTop10Holders().toString());
        if (params.getVolumeMax() != null) queryParams.put("volumeMax", params.getVolumeMax().toString());
        if (params.getVolumeMin() != null) queryParams.put("volumeMin", params.getVolumeMin().toString());

        APIResponse<TokenPairs> response = request("GET", "/api/v1/token/pairs", queryParams);
        return response.getData();
    }
}