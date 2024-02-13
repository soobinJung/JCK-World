package com.jck.world.api.question.repository;

import com.jck.world.api.question.domain.ExaminationQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationQuestionRepository extends JpaRepository<ExaminationQuestion, Long> {

    List<ExaminationQuestion> findAllByExaminationId(Long examinationId);
}
