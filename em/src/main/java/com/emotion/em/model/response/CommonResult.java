package com.emotion.em.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CommonResult {

    private boolean success;

    private int code;

    private String message;
    
}
