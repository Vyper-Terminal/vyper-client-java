package com.vyper.sdk.models;
import java.util.List;

public class TokenPairsParams {
    private Boolean atLeastOneSocial;
    private Integer buysMax;
    private Integer buysMin;
    private List<Integer> chainIds;
    private Boolean freezeAuthDisabled;
    private Double initialLiquidityMax;
    private Double initialLiquidityMin;
    private String interval;
    private Double liquidityMax;
    private Double liquidityMin;
    private Boolean lpBurned;
    private Double marketCapMax;
    private Double marketCapMin;
    private Boolean mintAuthDisabled;
    private Integer page;
    private Integer sellsMax;
    private Integer sellsMin;
    private String sorting;
    private Integer swapsMax;
    private Integer swapsMin;
    private List<String> tokenTypes;
    private Boolean top10Holders;
    private Double volumeMax;
    private Double volumeMin;

    public Boolean getAtLeastOneSocial() { return atLeastOneSocial; }
    public void setAtLeastOneSocial(Boolean atLeastOneSocial) { this.atLeastOneSocial = atLeastOneSocial; }
    public Integer getBuysMax() { return buysMax; }
    public void setBuysMax(Integer buysMax) { this.buysMax = buysMax; }
    public Integer getBuysMin() { return buysMin; }
    public void setBuysMin(Integer buysMin) { this.buysMin = buysMin; }
    public List<Integer> getChainIds() { return chainIds; }
    public void setChainIds(List<Integer> chainIds) { this.chainIds = chainIds; }
    public Boolean getFreezeAuthDisabled() { return freezeAuthDisabled; }
    public void setFreezeAuthDisabled(Boolean freezeAuthDisabled) { this.freezeAuthDisabled = freezeAuthDisabled; }
    public Double getInitialLiquidityMax() { return initialLiquidityMax; }
    public void setInitialLiquidityMax(Double initialLiquidityMax) { this.initialLiquidityMax = initialLiquidityMax; }
    public Double getInitialLiquidityMin() { return initialLiquidityMin; }
    public void setInitialLiquidityMin(Double initialLiquidityMin) { this.initialLiquidityMin = initialLiquidityMin; }
    public String getInterval() { return interval; }
    public void setInterval(String interval) { this.interval = interval; }
    public Double getLiquidityMax() { return liquidityMax; }
    public void setLiquidityMax(Double liquidityMax) { this.liquidityMax = liquidityMax; }
    public Double getLiquidityMin() { return liquidityMin; }
    public void setLiquidityMin(Double liquidityMin) { this.liquidityMin = liquidityMin; }
    public Boolean getLpBurned() { return lpBurned; }
    public void setLpBurned(Boolean lpBurned) { this.lpBurned = lpBurned; }
    public Double getMarketCapMax() { return marketCapMax; }
    public void setMarketCapMax(Double marketCapMax) { this.marketCapMax = marketCapMax; }
    public Double getMarketCapMin() { return marketCapMin; }
    public void setMarketCapMin(Double marketCapMin) { this.marketCapMin = marketCapMin; }
    public Boolean getMintAuthDisabled() { return mintAuthDisabled; }
    public void setMintAuthDisabled(Boolean mintAuthDisabled) { this.mintAuthDisabled = mintAuthDisabled; }
    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    public Integer getSellsMax() { return sellsMax; }
    public void setSellsMax(Integer sellsMax) { this.sellsMax = sellsMax; }
    public Integer getSellsMin() { return sellsMin; }
    public void setSellsMin(Integer sellsMin) { this.sellsMin = sellsMin; }
    public String getSorting() { return sorting; }
    public void setSorting(String sorting) { this.sorting = sorting; }
    public Integer getSwapsMax() { return swapsMax; }
    public void setSwapsMax(Integer swapsMax) { this.swapsMax = swapsMax; }
    public Integer getSwapsMin() { return swapsMin; }
    public void setSwapsMin(Integer swapsMin) { this.swapsMin = swapsMin; }
    public List<String> getTokenTypes() { return tokenTypes; }
    public void setTokenTypes(List<String> tokenTypes) { this.tokenTypes = tokenTypes; }
    public Boolean getTop10Holders() { return top10Holders; }
    public void setTop10Holders(Boolean top10Holders) { this.top10Holders = top10Holders; }
    public Double getVolumeMax() { return volumeMax; }
    public void setVolumeMax(Double volumeMax) { this.volumeMax = volumeMax; }
    public Double getVolumeMin() { return volumeMin; }
    public void setVolumeMin(Double volumeMin) { this.volumeMin = volumeMin; }
}