package com.emotion.em.service;

import com.emotion.em.model.response.CommonResult;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    
    public static enum CommonResponse {
        SUCCESS(0000, "성공하였습니다."),
        FAILED(9999, "실패하였습니다.");

        int code;
        String message;

        CommonResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() { return code; }
        public String getMessage() { return message; }
    }

    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    public CommonResult getErrorResult(String message) {
        CommonResult result = new CommonResult();
        setErrorResult(result, message);
        return result;
    }

    private void setSuccessResult(CommonResult commonResult) {
        commonResult.setSuccess(true);
        commonResult.setCode(CommonResponse.SUCCESS.getCode());
        commonResult.setMessage(CommonResponse.SUCCESS.getMessage());
    }

    private void setErrorResult(CommonResult commonResult, String message) {
        commonResult.setSuccess(false);
        commonResult.setCode(CommonResponse.FAILED.getCode());
        commonResult.setMessage(message);
    }

    



    
}
