package com.jck.world.api.examination.dto;

import com.jck.world.api.examination.code.ExaminationPartType;
import com.jck.world.api.examination.code.ExaminationType;
import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.question.domain.ExaminationQuestion;
import com.jck.world.api.question.dto.ExaminationQuestionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExaminationDto {

    private Long id;
    private LocalDate date;
    private ExaminationType type;
    private ExaminationPartType partType;

    private List<ExaminationQuestionDto> examinationQuestionDtoList;

    public Examination toEntity() {
        return Examination.builder()
                .id(id)
                .date(date)
                .type(type)
                .partType(partType)
                .build();
    }
}
