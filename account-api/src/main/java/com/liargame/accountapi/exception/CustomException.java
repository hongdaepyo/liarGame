package com.liargame.accountapi.exception;

public class CustomException extends RuntimeException{
    private ErrorInfo errorInfo;

    public CustomException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getErrorInfo() {return errorInfo;}
}
