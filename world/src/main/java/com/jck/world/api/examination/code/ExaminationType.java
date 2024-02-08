package com.jck.world.api.examination.code;

public enum ExaminationType {

    INFORMATION_PROCESSING_ENGINEER("정보처리기사"),
    INFORMATION_PROCESSING_TECHNICIAN("정보처리산업기사");

    private final String description;

    ExaminationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
