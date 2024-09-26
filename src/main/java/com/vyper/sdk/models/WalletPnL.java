package com.vyper.sdk.models;

public class WalletPnL {
    private long holderSince;
    private double investedAmount;
    private int investedTxns;
    private double pnlPercent;
    private double pnlUsd;
    private double remainingTokens;
    private double remainingUsd;
    private double soldAmount;
    private int soldTxns;

    public long getHolderSince() { return holderSince; }
    public void setHolderSince(long holderSince) { this.holderSince = holderSince; }
    public double getInvestedAmount() { return investedAmount; }
    public void setInvestedAmount(double investedAmount) { this.investedAmount = investedAmount; }
    public int getInvestedTxns() { return investedTxns; }
    public void setInvestedTxns(int investedTxns) { this.investedTxns = investedTxns; }
    public double getPnlPercent() { return pnlPercent; }
    public void setPnlPercent(double pnlPercent) { this.pnlPercent = pnlPercent; }
    public double getPnlUsd() { return pnlUsd; }
    public void setPnlUsd(double pnlUsd) { this.pnlUsd = pnlUsd; }
    public double getRemainingTokens() { return remainingTokens; }
    public void setRemainingTokens(double remainingTokens) { this.remainingTokens = remainingTokens; }
    public double getRemainingUsd() { return remainingUsd; }
    public void setRemainingUsd(double remainingUsd) { this.remainingUsd = remainingUsd; }
    public double getSoldAmount() { return soldAmount; }
    public void setSoldAmount(double soldAmount) { this.soldAmount = soldAmount; }
    public int getSoldTxns() { return soldTxns; }
    public void setSoldTxns(int soldTxns) { this.soldTxns = soldTxns; }
}