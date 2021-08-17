package com.emotion.em.exception;

import lombok.Getter;
import lombok.Setter;

public class AppError {

    @Setter
    @Getter
    private String message;

    @Setter
    @Getter
    private String reason;
    
}
