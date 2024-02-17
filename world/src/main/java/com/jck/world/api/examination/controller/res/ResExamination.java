package com.jck.world.api.examination.controller.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jck.world.api.examination.code.ExaminationPartType;
import com.jck.world.api.examination.code.ExaminationType;
import com.jck.world.api.examination.dto.ExaminationDto;
import com.jck.world.api.question.dto.ExaminationQuestionDto;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

/**
 * 시험 정보 응답 객체
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResExamination {

    private Long id;
    private LocalDate date;
    private String type;
    private String partType;

    private List<ResQuestion> questions;

    @Getter
    public class ResQuestion {
        private Long id;
        private ExaminationDto examination;
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

        public ResQuestion(ExaminationQuestionDto examinationQuestionDto){
            this.id = examinationQuestionDto.getId();
            this.examination = examinationQuestionDto.getExamination();
            this.question = examinationQuestionDto.getQuestion();
            this.correctAnswer = examinationQuestionDto.getCorrectAnswer();
            this.answer1 = examinationQuestionDto.getAnswer1();
            this.answer1Image = examinationQuestionDto.getAnswer1Image();
            this.answer2 = examinationQuestionDto.getAnswer2();
            this.answer2Image = examinationQuestionDto.getAnswer2Image();
            this.answer3 = examinationQuestionDto.getAnswer3();
            this.answer4 = examinationQuestionDto.getAnswer4();
            this.answer4Image = examinationQuestionDto.getAnswer4Image();
        }
    }

    public ResExamination(ExaminationDto examinationDto){
        this.id = examinationDto.getId();
        this.date = examinationDto.getDate();
        this.type = examinationDto.getType().getDescription();
        this.partType = examinationDto.getPartType().getDescription();

        if(!examinationDto.getExaminationQuestionDtoList().isEmpty()){
            questions = examinationDto.getExaminationQuestionDtoList()
                    .stream()
                    .map(ResExamination.ResQuestion::new)
                    .toList();
        }
    }
}
