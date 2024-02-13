package com.jck.world.api.question.dto.res;

import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.question.domain.ExaminationQuestion;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * 시험 문제 응답 객체
 */
public class ResExaminationQuestion {

    private Long id;
    private Long examinationId;
    private LocalDate examinationDate;
    private String examinationPartType;
    private String examinationType;

    private List<Question> questions;

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

    public ResExaminationQuestion (Examination examination, List<ExaminationQuestion> examinationQuestions){

        if(questions.isEmpty()){
            return;
        }

        /** 시험정보 **/
        this.examinationId = examination.getId();
        this.examinationDate = examination.getDate();
        this.examinationPartType = examination.getPartType().getDescription();
        this.examinationType = examination.getType().getDescription();

        /** 문제정보 **/
        for(ExaminationQuestion examinationQuestion : examinationQuestions){
                ResExaminationQuestion.Question question = new ResExaminationQuestion.Question(
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
                );
                questions.add(question);
        }
    }
}
