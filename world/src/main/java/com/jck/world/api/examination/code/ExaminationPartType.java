package com.jck.world.api.examination.code;

public enum ExaminationPartType {

    WRITTEN("필기"),
    PRACTICAL("실기");

    private final String description;

    ExaminationPartType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
