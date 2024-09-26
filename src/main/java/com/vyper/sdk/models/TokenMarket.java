package com.vyper.sdk.models;

public class TokenMarket {
    private double marketCapUsd;
    private String marketID;
    private double tokenLiquidityUsd;
    private String tokenType;

    public double getMarketCapUsd() { return marketCapUsd; }
    public void setMarketCapUsd(double marketCapUsd) { this.marketCapUsd = marketCapUsd; }
    public String getMarketID() { return marketID; }
    public void setMarketID(String marketID) { this.marketID = marketID; }
    public double getTokenLiquidityUsd() { return tokenLiquidityUsd; }
    public void setTokenLiquidityUsd(double tokenLiquidityUsd) { this.tokenLiquidityUsd = tokenLiquidityUsd; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
}