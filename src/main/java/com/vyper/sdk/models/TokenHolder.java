package com.vyper.sdk.models;

public class TokenHolder {
    private double percentOwned;
    private double tokenHoldings;
    private double usdHoldings;
    private String walletAddress;
    private String walletTag;

    public double getPercentOwned() { return percentOwned; }
    public void setPercentOwned(double percentOwned) { this.percentOwned = percentOwned; }
    public double getTokenHoldings() { return tokenHoldings; }
    public void setTokenHoldings(double tokenHoldings) { this.tokenHoldings = tokenHoldings; }
    public double getUsdHoldings() { return usdHoldings; }
    public void setUsdHoldings(double usdHoldings) { this.usdHoldings = usdHoldings; }
    public String getWalletAddress() { return walletAddress; }
    public void setWalletAddress(String walletAddress) { this.walletAddress = walletAddress; }
    public String getWalletTag() { return walletTag; }
    public void setWalletTag(String walletTag) { this.walletTag = walletTag; }
}