package com.jck.world.api.examination.controller.res;

import com.jck.world.api.examination.code.ExaminationPartType;
import com.jck.world.api.examination.code.ExaminationType;
import com.jck.world.api.examination.dto.ExaminationDto;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 시험 정보 응답 객체
 */
@Getter
public class ResExamination {

    private Long id;
    private LocalDate date;
    private ExaminationType type;
    private ExaminationPartType partType;

    public ResExamination(ExaminationDto examinationDto){
        this.id = examinationDto.getId();
        this.date = examinationDto.getDate();
        this.type = examinationDto.getType();
        this.partType = examinationDto.getPartType();
    }
}
