package com.sprayou.spray.model;
import lombok.Getter;

public enum ResultCode {
    SUCCESS("0000", "Success"),
    JDBC_CONNECTION("5000", "JDBC connection error"),
    DB_FAIL("5001", "Database operation fail");

    @Getter
    private String code;

    @Getter
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

