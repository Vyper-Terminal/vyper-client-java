package com.vyper.sdk.exceptions;

public class ServerException extends VyperApiException {
    public ServerException(String message, Integer statusCode, String response) {
        super(message, statusCode, response);
    }

    public ServerException(String message) {
        super(message);
    }
}