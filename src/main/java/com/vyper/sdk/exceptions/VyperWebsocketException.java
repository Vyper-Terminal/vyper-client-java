package com.vyper.sdk.exceptions;

public class VyperWebsocketException extends Exception {
    private final Integer statusCode;
    private final String connectionInfo;

    public VyperWebsocketException(String message, Integer statusCode, String connectionInfo) {
        super(message);
        this.statusCode = statusCode;
        this.connectionInfo = connectionInfo;
    }

    public VyperWebsocketException(String message) {
        this(message, null, null);
    }

    public Integer getStatusCode() { return statusCode; }
    public String getConnectionInfo() { return connectionInfo; }
}