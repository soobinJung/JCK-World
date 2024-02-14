package com.jck.world.api.question.service;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import com.jck.world.api.examination.repository.ExaminationRepository;
import com.jck.world.api.examination.service.ExaminationService;
import com.jck.world.api.question.domain.ExaminationQuestion;
import com.jck.world.api.question.dto.res.ResExaminationQuestion;
import com.jck.world.api.question.repository.ExaminationQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExaminationQuestionService {

    private final ExaminationQuestionRepository examinationQuestionRepository;
    private final ExaminationService examinationService;

    public ResExaminationQuestion findAllByExaminationId(Long examinationId) {
        return new ResExaminationQuestion(
                examinationService.getExaminationById(examinationId),
                examinationQuestionRepository.findAllByExaminationId(examinationId)
        );
    }
}
