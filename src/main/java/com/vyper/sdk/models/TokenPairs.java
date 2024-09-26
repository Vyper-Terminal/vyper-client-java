package com.vyper.sdk.models;
import java.util.List;

public class TokenPairs {
    private boolean hasNext;
    private List<TokenPair> pairs;

    public boolean isHasNext() { return hasNext; }
    public void setHasNext(boolean hasNext) { this.hasNext = hasNext; }
    public List<TokenPair> getPairs() { return pairs; }
    public void setPairs(List<TokenPair> pairs) { this.pairs = pairs; }
}
