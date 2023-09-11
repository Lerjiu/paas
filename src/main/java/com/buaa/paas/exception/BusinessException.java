package com.buaa.paas.exception;

public class BusinessException extends RuntimeException {
    private int exceptionCode;

    public BusinessException(int exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(int exceptionCode, String message, Throwable cause) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public static BusinessException exception(int exceptionCode, String message, Throwable cause) {
        return new BusinessException(exceptionCode, message, cause);
    }

    public static BusinessException exception(int exceptionCode, String message) {
        return new BusinessException(exceptionCode, message);
    }

}
