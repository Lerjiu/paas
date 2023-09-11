package com.buaa.paas.controller.response;

public class Response {
    public static final int RESPONSE_SUCCESS = 0;
    public static final int RESPONSE_FAIL = 1;
    private int status;
    private String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Response success() {
        return new Response(RESPONSE_SUCCESS, "success");
    }

    public static Response success(String message) {
        return new Response(RESPONSE_SUCCESS, message);
    }

    public static Response fail() {
        return new Response(RESPONSE_FAIL, "fail");
    }

    public static Response fail(String message) {
        return new Response(RESPONSE_FAIL, message);
    }
}
