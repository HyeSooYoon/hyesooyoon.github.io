package com.surfingvd.vd.util;

import lombok.Getter;

public class ResponseBase {

    @Getter
    private String code;

    @Getter
    private String message;

    public ResponseBase() {
        setResultCode(ResultCode.SUCCESS);
    }

    public ResponseBase(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    public ResponseBase(Exception e) {
        this.code = "known";
        this.message = e.getClass().getCanonicalName() + " / " + e.getMessage();
    }

    protected void setResultCode(final ResultCode resultCode) {
        code = resultCode.getCode();
        message = resultCode.getMessage();
    }
}