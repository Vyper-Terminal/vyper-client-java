package com.vyper.sdk.models;

public class TokenATH {
    private double marketCapUsd;
    private long timestamp;
    private double tokenLiquidityUsd;

    public double getMarketCapUsd() { return marketCapUsd; }
    public void setMarketCapUsd(double marketCapUsd) { this.marketCapUsd = marketCapUsd; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public double getTokenLiquidityUsd() { return tokenLiquidityUsd; }
    public void setTokenLiquidityUsd(double tokenLiquidityUsd) { this.tokenLiquidityUsd = tokenLiquidityUsd; }
}