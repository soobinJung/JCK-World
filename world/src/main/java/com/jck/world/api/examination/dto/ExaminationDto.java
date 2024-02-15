package com.jck.world.api.examination.dto;

import com.jck.world.api.examination.code.ExaminationPartType;
import com.jck.world.api.examination.code.ExaminationType;
import com.jck.world.api.examination.domain.Examination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExaminationDto {

    private Long id;
    private LocalDate date;
    private ExaminationType type;
    private ExaminationPartType partType;

    public Examination toEntity() {
        return Examination.builder()
                .id(id)
                .date(date)
                .type(type)
                .partType(partType)
                .build();
    }
}
