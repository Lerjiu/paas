package com.buaa.paas.exception;

public class SystemException extends RuntimeException {
    private int exceptionCode;

    public SystemException(int exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public SystemException(int exceptionCode, String message, Throwable throwable) {
        super(message, throwable);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public static SystemException exception(int exceptionCode, String message, Throwable throwable) {
        return new SystemException(exceptionCode, message, throwable);
    }

    public static SystemException exception(int exceptionCode, String message) {
        return new SystemException(exceptionCode, message);
    }
}
