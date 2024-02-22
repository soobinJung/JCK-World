package com.jck.world.api.question.controller.res;

import com.jck.world.api.question.dto.ExaminationQuestionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 시험 문제 응답 객체
 */
@Getter
public class ResExaminationQuestion {

    private List<Question> questions;
    private int totalCnt;

    @Getter
    @AllArgsConstructor
    public class Question {
        private Long id;
        private String question;
        private String correctAnswer;
        private String answer1;
        private String answer1Image;
        private String answer2;
        private String answer2Image;
        private String answer3;
        private String answer3Image;
        private String answer4;
        private String answer4Image;
    }

    public ResExaminationQuestion (List<ExaminationQuestionDto> examinationQuestions){
        this.totalCnt = examinationQuestions.size();
        this.questions = examinationQuestions.stream()
            .map(examinationQuestion -> new ResExaminationQuestion.Question(
                    examinationQuestion.getId(),
                    examinationQuestion.getQuestion(),
                    examinationQuestion.getCorrectAnswer(),
                    examinationQuestion.getAnswer1(),
                    examinationQuestion.getAnswer1Image(),
                    examinationQuestion.getAnswer2(),
                    examinationQuestion.getAnswer2Image(),
                    examinationQuestion.getAnswer3(),
                    examinationQuestion.getAnswer3Image(),
                    examinationQuestion.getAnswer4(),
                    examinationQuestion.getAnswer4Image()
            ))
            .collect(Collectors.toList());
    }
}
