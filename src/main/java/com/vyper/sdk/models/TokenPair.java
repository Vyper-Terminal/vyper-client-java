package com.vyper.sdk.models;

public class TokenPair {
    private Boolean abused;
    private Double bondingCurvePercentage;
    private int buyTxnCount;
    private int chainId;
    private String contractCreator;
    private long createdTimestamp;
    private String description;
    private Boolean freezeAuthority;
    private String image;
    private double initialAssetLiquidity;
    private double initialUsdLiquidity;
    private Boolean isMigrated;
    private boolean lpBurned;
    private String lpCreator;
    private String marketId;
    private String metadataUri;
    private String migratedMarketId;
    private MigrationState migrationState;
    private Boolean mintAuthority;
    private String name;
    private double pooledAsset;
    private double pooledToken;
    private double priceChangePercent;
    private int sellTxnCount;
    private String symbol;
    private String telegram;
    private double tokenLiquidityAsset;
    private double tokenLiquidityUsd;
    private double tokenMarketCapAsset;
    private double tokenMarketCapUsd;
    private String tokenMint;
    private double tokenPriceAsset;
    private double tokenPriceUsd;
    private String tokenType;
    private double top10HoldingPercent;
    private double totalSupply;
    private int transactionCount;
    private String twitter;
    private double volumeAsset;
    private double volumeUsd;
    private String website;

    public Boolean getAbused() { return abused; }
    public void setAbused(Boolean abused) { this.abused = abused; }
    public Double getBondingCurvePercentage() { return bondingCurvePercentage; }
    public void setBondingCurvePercentage(Double bondingCurvePercentage) { this.bondingCurvePercentage = bondingCurvePercentage; }
    public int getBuyTxnCount() { return buyTxnCount; }
    public void setBuyTxnCount(int buyTxnCount) { this.buyTxnCount = buyTxnCount; }
    public int getChainId() { return chainId; }
    public void setChainId(int chainId) { this.chainId = chainId; }
    public String getContractCreator() { return contractCreator; }
    public void setContractCreator(String contractCreator) { this.contractCreator = contractCreator; }
    public long getCreatedTimestamp() { return createdTimestamp; }
    public void setCreatedTimestamp(long createdTimestamp) { this.createdTimestamp = createdTimestamp; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getFreezeAuthority() { return freezeAuthority; }
    public void setFreezeAuthority(Boolean freezeAuthority) { this.freezeAuthority = freezeAuthority; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public double getInitialAssetLiquidity() { return initialAssetLiquidity; }
    public void setInitialAssetLiquidity(double initialAssetLiquidity) { this.initialAssetLiquidity = initialAssetLiquidity; }
    public double getInitialUsdLiquidity() { return initialUsdLiquidity; }
    public void setInitialUsdLiquidity(double initialUsdLiquidity) { this.initialUsdLiquidity = initialUsdLiquidity; }
    public Boolean getIsMigrated() { return isMigrated; }
    public void setIsMigrated(Boolean isMigrated) { this.isMigrated = isMigrated; }
    public boolean isLpBurned() { return lpBurned; }
    public void setLpBurned(boolean lpBurned) { this.lpBurned = lpBurned; }
    public String getLpCreator() { return lpCreator; }
    public void setLpCreator(String lpCreator) { this.lpCreator = lpCreator; }
    public String getMarketId() { return marketId; }
    public void setMarketId(String marketId) { this.marketId = marketId; }
    public String getMetadataUri() { return metadataUri; }
    public void setMetadataUri(String metadataUri) { this.metadataUri = metadataUri; }
    public String getMigratedMarketId() { return migratedMarketId; }
    public void setMigratedMarketId(String migratedMarketId) { this.migratedMarketId = migratedMarketId; }
    public MigrationState getMigrationState() { return migrationState; }
    public void setMigrationState(MigrationState migrationState) { this.migrationState = migrationState; }
    public Boolean getMintAuthority() { return mintAuthority; }
    public void setMintAuthority(Boolean mintAuthority) { this.mintAuthority = mintAuthority; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPooledAsset() { return pooledAsset; }
    public void setPooledAsset(double pooledAsset) { this.pooledAsset = pooledAsset; }
    public double getPooledToken() { return pooledToken; }
    public void setPooledToken(double pooledToken) { this.pooledToken = pooledToken; }
    public double getPriceChangePercent() { return priceChangePercent; }
    public void setPriceChangePercent(double priceChangePercent) { this.priceChangePercent = priceChangePercent; }
    public int getSellTxnCount() { return sellTxnCount; }
    public void setSellTxnCount(int sellTxnCount) { this.sellTxnCount = sellTxnCount; }
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getTelegram() { return telegram; }
    public void setTelegram(String telegram) { this.telegram = telegram; }
    public double getTokenLiquidityAsset() { return tokenLiquidityAsset; }
    public void setTokenLiquidityAsset(double tokenLiquidityAsset) { this.tokenLiquidityAsset = tokenLiquidityAsset; }
    public double getTokenLiquidityUsd() { return tokenLiquidityUsd; }
    public void setTokenLiquidityUsd(double tokenLiquidityUsd) { this.tokenLiquidityUsd = tokenLiquidityUsd; }
    public double getTokenMarketCapAsset() { return tokenMarketCapAsset; }
    public void setTokenMarketCapAsset(double tokenMarketCapAsset) { this.tokenMarketCapAsset = tokenMarketCapAsset; }
    public double getTokenMarketCapUsd() { return tokenMarketCapUsd; }
    public void setTokenMarketCapUsd(double tokenMarketCapUsd) { this.tokenMarketCapUsd = tokenMarketCapUsd; }
    public String getTokenMint() { return tokenMint; }
    public void setTokenMint(String tokenMint) { this.tokenMint = tokenMint; }
    public double getTokenPriceAsset() { return tokenPriceAsset; }
    public void setTokenPriceAsset(double tokenPriceAsset) { this.tokenPriceAsset = tokenPriceAsset; }
    public double getTokenPriceUsd() { return tokenPriceUsd; }
    public void setTokenPriceUsd(double tokenPriceUsd) { this.tokenPriceUsd = tokenPriceUsd; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public double getTop10HoldingPercent() { return top10HoldingPercent; }
    public void setTop10HoldingPercent(double top10HoldingPercent) { this.top10HoldingPercent = top10HoldingPercent; }
    public double getTotalSupply() { return totalSupply; }
    public void setTotalSupply(double totalSupply) { this.totalSupply = totalSupply; }
    public int getTransactionCount() { return transactionCount; }
    public void setTransactionCount(int transactionCount) { this.transactionCount = transactionCount; }
    public String getTwitter() { return twitter; }
    public void setTwitter(String twitter) { this.twitter = twitter; }
    public double getVolumeAsset() { return volumeAsset; }
    public void setVolumeAsset(double volumeAsset) { this.volumeAsset = volumeAsset; }
    public double getVolumeUsd() { return volumeUsd; }
    public void setVolumeUsd(double volumeUsd) { this.volumeUsd = volumeUsd; }
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
}