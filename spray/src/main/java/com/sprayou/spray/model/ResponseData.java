package com.sprayou.spray.model;
import lombok.Getter;

/* 정상 응답 데이터, 정상 응답 코드 리턴 클래스 */
public class
ResponseData extends ResponseBase {

    @Getter
    private Object data = null;

    public ResponseData(Object data) {
        setResultCode(ResultCode.SUCCESS);
        this.data = data;
    }
}
