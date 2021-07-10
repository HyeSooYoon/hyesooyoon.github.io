package com.sprayou.spray.util;

import com.sprayou.spray.model.ResponseBase;
import com.sprayou.spray.model.ResponseData;
import com.sprayou.spray.model.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
    static public ResponseEntity<ResponseBase> success() {
        return getEntity(new ResponseBase());
    }

    static public ResponseEntity<ResponseBase> success(Object data) {
        return getEntity(new ResponseData(data));
    }

    static public ResponseEntity<ResponseBase> fail(ResultCode resultCode) {
        return getEntity(new ResponseBase(resultCode));
    }

    static public ResponseEntity<ResponseBase> fail(Exception e) {
        return getEntity(new ResponseBase(e));
    }

    static public ResponseEntity<ResponseBase> getEntity(ResponseBase responseBase) {
        HttpStatus httpStatus;

        // 성공
        if (ResultCode.SUCCESS.getCode().equals(responseBase.getCode())) {
            httpStatus = HttpStatus.OK;
        
        // 기등록
        } else if (ResultCode.DB_DUP.getCode().equals(responseBase.getCode())) {
            httpStatus = HttpStatus.OK;
        
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(responseBase, httpStatus);
    }
}
