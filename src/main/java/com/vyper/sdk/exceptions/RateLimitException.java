package com.vyper.sdk.exceptions;

public class RateLimitException extends VyperApiException {
    private final int retryAfter;

    public RateLimitException(String message, int retryAfter) {
        super(message);
        this.retryAfter = retryAfter;
    }

    public int getRetryAfter() { return retryAfter; }
}
