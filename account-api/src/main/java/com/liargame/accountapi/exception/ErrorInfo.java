package com.liargame.accountapi.exception;

import java.sql.SQLException;

public enum ErrorInfo {
    SUCCESS(200, "success")
    , NOT_DEFINE_SERVER_ERROR(-99, "server error")
    ;

    int code;
    String message;

    ErrorInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getErrorCode() {
        return this.code;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
