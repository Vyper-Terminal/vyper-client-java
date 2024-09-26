package com.vyper.sdk.models;

public class WalletHolding {
    private String marketId;
    private double tokenHoldings;
    private String tokenSymbol;
    private double usdValue;

    public String getMarketId() { return marketId; }
    public void setMarketId(String marketId) { this.marketId = marketId; }
    public double getTokenHoldings() { return tokenHoldings; }
    public void setTokenHoldings(double tokenHoldings) { this.tokenHoldings = tokenHoldings; }
    public String getTokenSymbol() { return tokenSymbol; }
    public void setTokenSymbol(String tokenSymbol) { this.tokenSymbol = tokenSymbol; }
    public double getUsdValue() { return usdValue; }
    public void setUsdValue(double usdValue) { this.usdValue = usdValue; }
}