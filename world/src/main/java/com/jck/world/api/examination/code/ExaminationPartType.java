package com.jck.world.api.examination.code;

import com.jck.world.api.common.code.AbstractCodedEnumConverter;
import com.jck.world.api.common.code.CodedEnum;
import lombok.Getter;

@Getter
public enum ExaminationPartType implements CodedEnum<String> {

    필기("WRITTEN"),
    실기("PRACTICAL");

    private final String code;

    ExaminationPartType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Getter
    @jakarta.persistence.Converter(autoApply = true)
    public static class Converter extends AbstractCodedEnumConverter<ExaminationPartType, String> {
        public Converter() {
            super(ExaminationPartType.class);
        }
    }
}
