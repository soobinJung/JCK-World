package com.jck.world.api.question.service;

import com.jck.world.api.question.domain.ExaminationQuestion;
import com.jck.world.api.question.repository.ExaminationQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExaminationQuestionService {

    private final ExaminationQuestionRepository examinationQuestionRepository;

    public List<ExaminationQuestion> findAllByExaminationId(Long examinationId) {
        return examinationQuestionRepository.findAllByExaminationId(examinationId);
    }
}
