package com.vyper.sdk.models;

public class ChainAction {
    private String signer;
    private String tokenAccount;
    private String transactionId;
    private String tokenMint;
    private String marketId;
    private String actionType;
    private double tokenAmount;
    private double assetAmount;
    private double tokenPriceUsd;
    private double tokenPriceAsset;
    private Double swapTotalUsd;
    private Double swapTotalAsset;
    private double tokenMarketCapAsset;
    private double tokenMarketCapUsd;
    private double tokenLiquidityAsset;
    private double tokenLiquidityUsd;
    private double pooledToken;
    private double pooledAsset;
    private long actionTimestamp;
    private Double bondingCurvePercentage;
    private String botUsed;

    public String getSigner() { return signer; }
    public void setSigner(String signer) { this.signer = signer; }
    public String getTokenAccount() { return tokenAccount; }
    public void setTokenAccount(String tokenAccount) { this.tokenAccount = tokenAccount; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getTokenMint() { return tokenMint; }
    public void setTokenMint(String tokenMint) { this.tokenMint = tokenMint; }
    public String getMarketId() { return marketId; }
    public void setMarketId(String marketId) { this.marketId = marketId; }
    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    public double getTokenAmount() { return tokenAmount; }
    public void setTokenAmount(double tokenAmount) { this.tokenAmount = tokenAmount; }
    public double getAssetAmount() { return assetAmount; }
    public void setAssetAmount(double assetAmount) { this.assetAmount = assetAmount; }
    public double getTokenPriceUsd() { return tokenPriceUsd; }
    public void setTokenPriceUsd(double tokenPriceUsd) { this.tokenPriceUsd = tokenPriceUsd; }
    public double getTokenPriceAsset() { return tokenPriceAsset; }
    public void setTokenPriceAsset(double tokenPriceAsset) { this.tokenPriceAsset = tokenPriceAsset; }
    public Double getSwapTotalUsd() { return swapTotalUsd; }
    public void setSwapTotalUsd(Double swapTotalUsd) { this.swapTotalUsd = swapTotalUsd; }
    public Double getSwapTotalAsset() { return swapTotalAsset; }
    public void setSwapTotalAsset(Double swapTotalAsset) { this.swapTotalAsset = swapTotalAsset; }
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
    public long getActionTimestamp() { return actionTimestamp; }
    public void setActionTimestamp(long actionTimestamp) { this.actionTimestamp = actionTimestamp; }
    public Double getBondingCurvePercentage() { return bondingCurvePercentage; }
    public void setBondingCurvePercentage(Double bondingCurvePercentage) { this.bondingCurvePercentage = bondingCurvePercentage; }
    public String getBotUsed() { return botUsed; }
    public void setBotUsed(String botUsed) { this.botUsed = botUsed; }
}