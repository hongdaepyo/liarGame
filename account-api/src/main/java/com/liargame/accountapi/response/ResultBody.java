package com.liargame.accountapi.response;

import com.liargame.accountapi.exception.ErrorInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResultBody {
    private final int serverCode;
    private final String serverMsg;
    private Object results;


    @Builder
    public ResultBody(int serverCode, String serverMsg) {
        this.serverCode = serverCode;
        this.serverMsg = serverMsg;
    }

    public ResultBody() {
        this.serverCode = ErrorInfo.SUCCESS.getErrorCode();
        this.serverMsg = ErrorInfo.SUCCESS.getErrorMessage();
    }

    public ResultBody(Object results) {
        this.serverCode = ErrorInfo.SUCCESS.getErrorCode();
        this.serverMsg = ErrorInfo.SUCCESS.getErrorMessage();
        this.results = results;
    }
}
