package com.jck.world.api.examination.code;

import com.jck.world.api.common.code.AbstractCodedEnumConverter;
import com.jck.world.api.common.code.CodedEnum;
import lombok.Getter;

@Getter
public enum ExaminationType implements CodedEnum<String> {

    정보처리기사("INFORMATION_PROCESSING_ENGINEER"),
    정보처리산업기사("INFORMATION_PROCESSING_TECHNICIAN");

    private final String code;

    ExaminationType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Getter
    @jakarta.persistence.Converter(autoApply = true)
    public static class Converter extends AbstractCodedEnumConverter<ExaminationType, String> {
        public Converter() {
            super(ExaminationType.class);
        }
    }
}
