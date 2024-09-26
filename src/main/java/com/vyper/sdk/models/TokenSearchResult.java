package com.vyper.sdk.models;

public class TokenSearchResult {
    private int chainId;
    private String marketId;
    private long createdTimestamp;
    private String name;
    private String symbol;
    private String tokenMint;
    private String tokenType;
    private double percentChange24h;
    private double pooledAsset;
    private double tokenLiquidityUsd;
    private double tokenMarketCapUsd;
    private double tokenPriceUsd;
    private double volumeUsd;
    private String image;
    private String telegram;
    private String twitter;
    private String website;

    public int getChainId() { return chainId; }
    public void setChainId(int chainId) { this.chainId = chainId; }
    public String getMarketId() { return marketId; }
    public void setMarketId(String marketId) { this.marketId = marketId; }
    public long getCreatedTimestamp() { return createdTimestamp; }
    public void setCreatedTimestamp(long createdTimestamp) { this.createdTimestamp = createdTimestamp; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getTokenMint() { return tokenMint; }
    public void setTokenMint(String tokenMint) { this.tokenMint = tokenMint; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public double getPercentChange24h() { return percentChange24h; }
    public void setPercentChange24h(double percentChange24h) { this.percentChange24h = percentChange24h; }
    public double getPooledAsset() { return pooledAsset; }
    public void setPooledAsset(double pooledAsset) { this.pooledAsset = pooledAsset; }
    public double getTokenLiquidityUsd() { return tokenLiquidityUsd; }
    public void setTokenLiquidityUsd(double tokenLiquidityUsd) { this.tokenLiquidityUsd = tokenLiquidityUsd; }
    public double getTokenMarketCapUsd() { return tokenMarketCapUsd; }
    public void setTokenMarketCapUsd(double tokenMarketCapUsd) { this.tokenMarketCapUsd = tokenMarketCapUsd; }
    public double getTokenPriceUsd() { return tokenPriceUsd; }
    public void setTokenPriceUsd(double tokenPriceUsd) { this.tokenPriceUsd = tokenPriceUsd; }
    public double getVolumeUsd() { return volumeUsd; }
    public void setVolumeUsd(double volumeUsd) { this.volumeUsd = volumeUsd; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getTelegram() { return telegram; }
    public void setTelegram(String telegram) { this.telegram = telegram; }
    public String getTwitter() { return twitter; }
    public void setTwitter(String twitter) { this.twitter = twitter; }
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
}