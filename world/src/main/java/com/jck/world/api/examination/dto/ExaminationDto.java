package com.jck.world.api.examination.dto;

import com.jck.world.api.examination.code.ExaminationPartType;
import com.jck.world.api.examination.code.ExaminationType;
import com.jck.world.api.examination.domain.Examination;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class ExaminationDto {

    private Long id;
    LocalDate date;
    ExaminationType type;
    ExaminationPartType partType;

    public Examination toEntity() {
        return Examination.builder()
                .id(id)
                .date(date)
                .type(type)
                .partType(partType)
                .build();
    }
}
