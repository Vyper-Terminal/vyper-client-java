package com.vyper.sdk.models;

public class TokenPair {
    private String tokenType;
    private int chainId;
    private String name;
    private String description;
    private String symbol;
    private String image;
    private String metadataUri;
    private String contractCreator;
    private String lpCreator;
    private long createdTimestamp;
    private double totalSupply;
    private String tokenMint;
    private String marketId;
    private String migratedMarketId;
    private double initialAssetLiquidity;
    private double initialUsdLiquidity;
    private Boolean mintAuthority;
    private Boolean freezeAuthority;
    private Boolean abused;
    private String website;
    private String twitter;
    private String telegram;
    private Boolean isMigrated;
    private Double bondingCurvePercentage;
    private MigrationState migrationState;
    private double top10HoldingPercent;
    private boolean lpBurned;
    private double tokenPriceAsset;
    private double tokenPriceUsd;
    private double tokenMarketCapAsset;
    private double tokenMarketCapUsd;
    private double tokenLiquidityAsset;
    private double tokenLiquidityUsd;
    private double pooledToken;
    private double pooledAsset;
    private long holderCount;
    private long botHolderCount;
    private double percentChange5m;
    private long totalTxnCount5m;
    private long buyTxnCount5m;
    private long sellTxnCount5m;
    private double totalVolume5m;
    private double buyVolume5m;
    private double sellVolume5m;
    private long totalMakers5m;
    private long buyMakers5m;
    private long sellMakers5m;
    private double percentChange1h;
    private long totalTxnCount1h;
    private long buyTxnCount1h;
    private long sellTxnCount1h;
    private double totalVolume1h;
    private double buyVolume1h;
    private double sellVolume1h;
    private long totalMakers1h;
    private long buyMakers1h;
    private long sellMakers1h;
    private double percentChange6h;
    private long totalTxnCount6h;
    private long buyTxnCount6h;
    private long sellTxnCount6h;
    private double totalVolume6h;
    private double buyVolume6h;
    private double sellVolume6h;
    private long totalMakers6h;
    private long buyMakers6h;
    private long sellMakers6h;
    private double percentChange24h;
    private long totalTxnCount24h;
    private long buyTxnCount24h;
    private long sellTxnCount24h;
    private double totalVolume24h;
    private double buyVolume24h;
    private double sellVolume24h;
    private long totalMakers24h;
    private long buyMakers24h;
    private long sellMakers24h;

    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    
    public int getChainId() { return chainId; }
    public void setChainId(int chainId) { this.chainId = chainId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    
    public String getMetadataUri() { return metadataUri; }
    public void setMetadataUri(String metadataUri) { this.metadataUri = metadataUri; }
    
    public String getContractCreator() { return contractCreator; }
    public void setContractCreator(String contractCreator) { this.contractCreator = contractCreator; }
    
    public String getLpCreator() { return lpCreator; }
    public void setLpCreator(String lpCreator) { this.lpCreator = lpCreator; }
    
    public long getCreatedTimestamp() { return createdTimestamp; }
    public void setCreatedTimestamp(long createdTimestamp) { this.createdTimestamp = createdTimestamp; }
    
    public double getTotalSupply() { return totalSupply; }
    public void setTotalSupply(double totalSupply) { this.totalSupply = totalSupply; }
    
    public String getTokenMint() { return tokenMint; }
    public void setTokenMint(String tokenMint) { this.tokenMint = tokenMint; }
    
    public String getMarketId() { return marketId; }
    public void setMarketId(String marketId) { this.marketId = marketId; }
    
    public String getMigratedMarketId() { return migratedMarketId; }
    public void setMigratedMarketId(String migratedMarketId) { this.migratedMarketId = migratedMarketId; }
    
    public double getInitialAssetLiquidity() { return initialAssetLiquidity; }
    public void setInitialAssetLiquidity(double initialAssetLiquidity) { this.initialAssetLiquidity = initialAssetLiquidity; }
    
    public double getInitialUsdLiquidity() { return initialUsdLiquidity; }
    public void setInitialUsdLiquidity(double initialUsdLiquidity) { this.initialUsdLiquidity = initialUsdLiquidity; }
    
    public Boolean getMintAuthority() { return mintAuthority; }
    public void setMintAuthority(Boolean mintAuthority) { this.mintAuthority = mintAuthority; }
    
    public Boolean getFreezeAuthority() { return freezeAuthority; }
    public void setFreezeAuthority(Boolean freezeAuthority) { this.freezeAuthority = freezeAuthority; }
    
    public Boolean getAbused() { return abused; }
    public void setAbused(Boolean abused) { this.abused = abused; }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    
    public String getTwitter() { return twitter; }
    public void setTwitter(String twitter) { this.twitter = twitter; }
    
    public String getTelegram() { return telegram; }
    public void setTelegram(String telegram) { this.telegram = telegram; }
    
    public Boolean getIsMigrated() { return isMigrated; }
    public void setIsMigrated(Boolean isMigrated) { this.isMigrated = isMigrated; }
    
    public Double getBondingCurvePercentage() { return bondingCurvePercentage; }
    public void setBondingCurvePercentage(Double bondingCurvePercentage) { this.bondingCurvePercentage = bondingCurvePercentage; }
    
    public MigrationState getMigrationState() { return migrationState; }
    public void setMigrationState(MigrationState migrationState) { this.migrationState = migrationState; }
    
    public double getTop10HoldingPercent() { return top10HoldingPercent; }
    public void setTop10HoldingPercent(double top10HoldingPercent) { this.top10HoldingPercent = top10HoldingPercent; }
    
    public boolean isLpBurned() { return lpBurned; }
    public void setLpBurned(boolean lpBurned) { this.lpBurned = lpBurned; }
    
    public double getTokenPriceAsset() { return tokenPriceAsset; }
    public void setTokenPriceAsset(double tokenPriceAsset) { this.tokenPriceAsset = tokenPriceAsset; }
    
    public double getTokenPriceUsd() { return tokenPriceUsd; }
    public void setTokenPriceUsd(double tokenPriceUsd) { this.tokenPriceUsd = tokenPriceUsd; }
    
    public double getTokenMarketCapAsset() { return tokenMarketCapAsset; }
    public void setTokenMarketCapAsset(double tokenMarketCapAsset) { this.tokenMarketCapAsset = tokenMarketCapAsset; }
    
    public double getTokenMarketCapUsd() { return tokenMarketCapUsd; }
    public void setTokenMarketCapUsd(double tokenMarketCapUsd) { this.tokenMarketCapUsd = tokenMarketCapUsd; }
    
    public double getTokenLiquidityAsset() { return tokenLiquidityAsset; }
    public void setTokenLiquidityAsset(double tokenLiquidityAsset) { this.tokenLiquidityAsset = tokenLiquidityAsset; }
    
    public double getTokenLiquidityUsd() { return tokenLiquidityUsd; }
    public void setTokenLiquidityUsd(double tokenLiquidityUsd) { this.tokenLiquidityUsd = tokenLiquidityUsd; }
    
    public double getPooledToken() { return pooledToken; }
    public void setPooledToken(double pooledToken) { this.pooledToken = pooledToken; }
    
    public double getPooledAsset() { return pooledAsset; }
    public void setPooledAsset(double pooledAsset) { this.pooledAsset = pooledAsset; }
    
    public long getHolderCount() { return holderCount; }
    public void setHolderCount(long holderCount) { this.holderCount = holderCount; }
    
    public long getBotHolderCount() { return botHolderCount; }
    public void setBotHolderCount(long botHolderCount) { this.botHolderCount = botHolderCount; }

    public double getPercentChange5m() { return percentChange5m; }
    public void setPercentChange5m(double percentChange5m) { this.percentChange5m = percentChange5m; }
    
    public long getTotalTxnCount5m() { return totalTxnCount5m; }
    public void setTotalTxnCount5m(long totalTxnCount5m) { this.totalTxnCount5m = totalTxnCount5m; }
    
    public long getBuyTxnCount5m() { return buyTxnCount5m; }
    public void setBuyTxnCount5m(long buyTxnCount5m) { this.buyTxnCount5m = buyTxnCount5m; }
    
    public long getSellTxnCount5m() { return sellTxnCount5m; }
    public void setSellTxnCount5m(long sellTxnCount5m) { this.sellTxnCount5m = sellTxnCount5m; }
    
    public double getTotalVolume5m() { return totalVolume5m; }
    public void setTotalVolume5m(double totalVolume5m) { this.totalVolume5m = totalVolume5m; }
    
    public double getBuyVolume5m() { return buyVolume5m; }
    public void setBuyVolume5m(double buyVolume5m) { this.buyVolume5m = buyVolume5m; }
    
    public double getSellVolume5m() { return sellVolume5m; }
    public void setSellVolume5m(double sellVolume5m) { this.sellVolume5m = sellVolume5m; }
    
    public long getTotalMakers5m() { return totalMakers5m; }
    public void setTotalMakers5m(long totalMakers5m) { this.totalMakers5m = totalMakers5m; }
    
    public long getBuyMakers5m() { return buyMakers5m; }
    public void setBuyMakers5m(long buyMakers5m) { this.buyMakers5m = buyMakers5m; }
    
    public long getSellMakers5m() { return sellMakers5m; }
    public void setSellMakers5m(long sellMakers5m) { this.sellMakers5m = sellMakers5m; }

    public double getPercentChange1h() { return percentChange1h; }
    public void setPercentChange1h(double percentChange1h) { this.percentChange1h = percentChange1h; }
    
    public long getTotalTxnCount1h() { return totalTxnCount1h; }
    public void setTotalTxnCount1h(long totalTxnCount1h) { this.totalTxnCount1h = totalTxnCount1h; }
    
    public long getBuyTxnCount1h() { return buyTxnCount1h; }
    public void setBuyTxnCount1h(long buyTxnCount1h) { this.buyTxnCount1h = buyTxnCount1h; }
    
    public long getSellTxnCount1h() { return sellTxnCount1h; }
    public void setSellTxnCount1h(long sellTxnCount1h) { this.sellTxnCount1h = sellTxnCount1h; }
    
    public double getTotalVolume1h() { return totalVolume1h; }
    public void setTotalVolume1h(double totalVolume1h) { this.totalVolume1h = totalVolume1h; }
    
    public double getBuyVolume1h() { return buyVolume1h; }
    public void setBuyVolume1h(double buyVolume1h) { this.buyVolume1h = buyVolume1h; }
    
    public double getSellVolume1h() { return sellVolume1h; }
    public void setSellVolume1h(double sellVolume1h) { this.sellVolume1h = sellVolume1h; }
    
    public long getTotalMakers1h() { return totalMakers1h; }
    public void setTotalMakers1h(long totalMakers1h) { this.totalMakers1h = totalMakers1h; }
    
    public long getBuyMakers1h() { return buyMakers1h; }
    public void setBuyMakers1h(long buyMakers1h) { this.buyMakers1h = buyMakers1h; }
    
    public long getSellMakers1h() { return sellMakers1h; }
    public void setSellMakers1h(long sellMakers1h) { this.sellMakers1h = sellMakers1h; }

    public double getPercentChange6h() { return percentChange6h; }
    public void setPercentChange6h(double percentChange6h) { this.percentChange6h = percentChange6h; }
    
    public long getTotalTxnCount6h() { return totalTxnCount6h; }
    public void setTotalTxnCount6h(long totalTxnCount6h) { this.totalTxnCount6h = totalTxnCount6h; }
    
    public long getBuyTxnCount6h() { return buyTxnCount6h; }
    public void setBuyTxnCount6h(long buyTxnCount6h) { this.buyTxnCount6h = buyTxnCount6h; }
    
    public long getSellTxnCount6h() { return sellTxnCount6h; }
    public void setSellTxnCount6h(long sellTxnCount6h) { this.sellTxnCount6h = sellTxnCount6h; }
    
    public double getTotalVolume6h() { return totalVolume6h; }
    public void setTotalVolume6h(double totalVolume6h) { this.totalVolume6h = totalVolume6h; }
    
    public double getBuyVolume6h() { return buyVolume6h; }
    public void setBuyVolume6h(double buyVolume6h) { this.buyVolume6h = buyVolume6h; }
    
    public double getSellVolume6h() { return sellVolume6h; }
    public void setSellVolume6h(double sellVolume6h) { this.sellVolume6h = sellVolume6h; }
    
    public long getTotalMakers6h() { return totalMakers6h; }
    public void setTotalMakers6h(long totalMakers6h) { this.totalMakers6h = totalMakers6h; }
    
    public long getBuyMakers6h() { return buyMakers6h; }
    public void setBuyMakers6h(long buyMakers6h) { this.buyMakers6h = buyMakers6h; }
    
    public long getSellMakers6h() { return sellMakers6h; }
    public void setSellMakers6h(long sellMakers6h) { this.sellMakers6h = sellMakers6h; }

    public double getPercentChange24h() { return percentChange24h; }
    public void setPercentChange24h(double percentChange24h) { this.percentChange24h = percentChange24h; }
    
    public long getTotalTxnCount24h() { return totalTxnCount24h; }
    public void setTotalTxnCount24h(long totalTxnCount24h) { this.totalTxnCount24h = totalTxnCount24h; }
    
    public long getBuyTxnCount24h() { return buyTxnCount24h; }
    public void setBuyTxnCount24h(long buyTxnCount24h) { this.buyTxnCount24h = buyTxnCount24h; }
    
    public long getSellTxnCount24h() { return sellTxnCount24h; }
    public void setSellTxnCount24h(long sellTxnCount24h) { this.sellTxnCount24h = sellTxnCount24h; }
    
    public double getTotalVolume24h() { return totalVolume24h; }
    public void setTotalVolume24h(double totalVolume24h) { this.totalVolume24h = totalVolume24h; }
    
    public double getBuyVolume24h() { return buyVolume24h; }
    public void setBuyVolume24h(double buyVolume24h) { this.buyVolume24h = buyVolume24h; }
    
    public double getSellVolume24h() { return sellVolume24h; }
    public void setSellVolume24h(double sellVolume24h) { this.sellVolume24h = sellVolume24h; }
    
    public long getTotalMakers24h() { return totalMakers24h; }
    public void setTotalMakers24h(long totalMakers24h) { this.totalMakers24h = totalMakers24h; }
    
    public long getBuyMakers24h() { return buyMakers24h; }
    public void setBuyMakers24h(long buyMakers24h) { this.buyMakers24h = buyMakers24h; }
    
    public long getSellMakers24h() { return sellMakers24h; }
    public void setSellMakers24h(long sellMakers24h) { this.sellMakers24h = sellMakers24h; }
}