package com.jck.world.api.examination.service;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.examination.dto.ExaminationDto;
import com.jck.world.api.examination.repository.ExaminationRepository;
import com.jck.world.api.question.domain.ExaminationQuestion;
import com.jck.world.api.question.dto.ExaminationQuestionDto;
import com.jck.world.api.question.repository.ExaminationQuestionRepository;
import com.jck.world.api.question.service.ExaminationQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 시험 목록 관리
 */
@RequiredArgsConstructor
@Service
public class ExaminationService {

    private final ExaminationRepository examinationRepository;
    private final ExaminationQuestionService examinationQuestionService;

    public List<ExaminationDto> getExamination() {
        List<Examination> examinations = examinationRepository.findAll();
        return examinations.stream()
                .map(Examination::toDto)
                .toList();
    }

    public ExaminationDto getExaminationById(Long id) {

        /** 시험 정보 조회 */
        ExaminationDto examinationDto = examinationRepository.findById(id).orElseThrow( () -> new CommonException(CommonExceptionEnum.NO_DATA) ).toDto();

        /** 시험 문제 조회 */
        List<ExaminationQuestionDto> list = examinationQuestionService.findAllByExaminationId(id);
        examinationDto.setExaminationQuestionDtoList(list);

        return examinationDto;
    }
}
