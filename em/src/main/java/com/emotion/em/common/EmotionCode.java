package com.emotion.em.common;

import java.util.stream.Stream;

public enum EmotionCode {
    EM01("EM01", "보통(약간우울)"),
    EM02("EM02", "보통(약간낙관)"),
    EM03("EM03", "다혈질"),
    EM04("EM04", "우울");

    private String code;
    private String name;

    EmotionCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String findByEmotionCode(String code) {
        return Stream.of(EmotionCode.values())
        .filter(EmotionCode -> code.equals(EmotionCode.code))
        .map(EmotionCode -> EmotionCode.name())
        .findFirst()
        .orElse("ERROR");

        
    }
    
}

