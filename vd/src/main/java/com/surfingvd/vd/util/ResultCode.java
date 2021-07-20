package com.surfingvd.vd.util;

import lombok.Getter;

public enum ResultCode {
    
    SUCCESS("0000"          , "Success"                 );

    @Getter
    private String code;

    @Getter
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

