package com.vyper.sdk.models;

public class TopTrader {
    private double investedAmountTokens;
    private double investedAmountUsd;
    private int investedTxns;
    private double pnlUsd;
    private double remainingTokens;
    private double remainingUsd;
    private double soldAmountTokens;
    private double soldAmountUsd;
    private int soldTxns;
    private String walletAddress;
    private String walletTag;

    public double getInvestedAmountTokens() { return investedAmountTokens; }
    public void setInvestedAmountTokens(double investedAmountTokens) { this.investedAmountTokens = investedAmountTokens; }
    public double getInvestedAmountUsd() { return investedAmountUsd; }
    public void setInvestedAmountUsd(double investedAmountUsd) { this.investedAmountUsd = investedAmountUsd; }
    public int getInvestedTxns() { return investedTxns; }
    public void setInvestedTxns(int investedTxns) { this.investedTxns = investedTxns; }
    public double getPnlUsd() { return pnlUsd; }
    public void setPnlUsd(double pnlUsd) { this.pnlUsd = pnlUsd; }
    public double getRemainingTokens() { return remainingTokens; }
    public void setRemainingTokens(double remainingTokens) { this.remainingTokens = remainingTokens; }
    public double getRemainingUsd() { return remainingUsd; }
    public void setRemainingUsd(double remainingUsd) { this.remainingUsd = remainingUsd; }
    public double getSoldAmountTokens() { return soldAmountTokens; }
    public void setSoldAmountTokens(double soldAmountTokens) { this.soldAmountTokens = soldAmountTokens; }
    public double getSoldAmountUsd() { return soldAmountUsd; }
    public void setSoldAmountUsd(double soldAmountUsd) { this.soldAmountUsd = soldAmountUsd; }
    public int getSoldTxns() { return soldTxns; }
    public void setSoldTxns(int soldTxns) { this.soldTxns = soldTxns; }
    public String getWalletAddress() { return walletAddress; }
    public void setWalletAddress(String walletAddress) { this.walletAddress = walletAddress; }
    public String getWalletTag() { return walletTag; }
    public void setWalletTag(String walletTag) { this.walletTag = walletTag; }
}
