package com.vyper.sdk.exceptions;

public class VyperApiException extends Exception {
    private final Integer statusCode;
    private final String response;

    public VyperApiException(String message, Integer statusCode, String response) {
        super(message);
        this.statusCode = statusCode;
        this.response = response;
    }

    public VyperApiException(String message) {
        this(message, null, null);
    }

    public Integer getStatusCode() { return statusCode; }
    public String getResponse() { return response; }
}
