package com.vyper.sdk.exceptions;

public class AuthenticationException extends VyperApiException {
    public AuthenticationException(String message, Integer statusCode, String response) {
        super(message, statusCode, response);
    }

    public AuthenticationException(String message) {
        super(message);
    }
}