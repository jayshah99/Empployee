package com.example.Employee2.model;

public class Response {

    private boolean isError;
    private String message;

    public Response(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public String getMessage() {
            return message;
        }
}

