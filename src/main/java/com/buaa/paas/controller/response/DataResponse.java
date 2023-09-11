package com.buaa.paas.controller.response;

public class DataResponse extends Response {
    private Object data;

    public DataResponse(int status, String message, Object data) {
        super(status, message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static DataResponse success(Object data) {
        return new DataResponse(RESPONSE_SUCCESS, "success", data);
    }
}
