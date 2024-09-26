package com.vyper.sdk.models;

public class WalletAggregatedPnL {
    private double investedAmount;
    private double pnlPercent;
    private double pnlUsd;
    private double soldAmount;
    private int tokensTraded;
    private double totalPnlPercent;
    private double totalPnlUsd;
    private double unrealizedPnlPercent;
    private double unrealizedPnlUsd;

    public double getInvestedAmount() { return investedAmount; }
    public void setInvestedAmount(double investedAmount) { this.investedAmount = investedAmount; }
    public double getPnlPercent() { return pnlPercent; }
    public void setPnlPercent(double pnlPercent) { this.pnlPercent = pnlPercent; }
    public double getPnlUsd() { return pnlUsd; }
    public void setPnlUsd(double pnlUsd) { this.pnlUsd = pnlUsd; }
    public double getSoldAmount() { return soldAmount; }
    public void setSoldAmount(double soldAmount) { this.soldAmount = soldAmount; }
    public int getTokensTraded() { return tokensTraded; }
    public void setTokensTraded(int tokensTraded) { this.tokensTraded = tokensTraded; }
    public double getTotalPnlPercent() { return totalPnlPercent; }
    public void setTotalPnlPercent(double totalPnlPercent) { this.totalPnlPercent = totalPnlPercent; }
    public double getTotalPnlUsd() { return totalPnlUsd; }
    public void setTotalPnlUsd(double totalPnlUsd) { this.totalPnlUsd = totalPnlUsd; }
    public double getUnrealizedPnlPercent() { return unrealizedPnlPercent; }
    public void setUnrealizedPnlPercent(double unrealizedPnlPercent) { this.unrealizedPnlPercent = unrealizedPnlPercent; }
    public double getUnrealizedPnlUsd() { return unrealizedPnlUsd; }
    public void setUnrealizedPnlUsd(double unrealizedPnlUsd) { this.unrealizedPnlUsd = unrealizedPnlUsd; }
}