package com.emotion.em.common;

import java.util.stream.Stream;

public enum EmotionCode {
    EM01("EM01", "우울감"),
    EM02("EM02", "낙천적"),
    EM03("EM03", "다혈질"),
    EM04("EM04", "지독한우울");

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

