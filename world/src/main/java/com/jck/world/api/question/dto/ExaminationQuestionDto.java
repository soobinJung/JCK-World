package com.jck.world.api.question.dto;

import com.jck.world.api.examination.dto.ExaminationDto;
import com.jck.world.api.question.domain.ExaminationQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationQuestionDto {

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

    public ExaminationQuestionDto toDto(ExaminationQuestion examinationQuestion) {
        this.id = examinationQuestion.getId();
        this.examination = examinationQuestion.getExamination().toDto();
        this.question = examinationQuestion.getQuestion();
        this.correctAnswer = examinationQuestion.getCorrectAnswer();
        this.answer1 = examinationQuestion.getAnswer1();
        this.answer1Image = examinationQuestion.getAnswer1Image();
        this.answer2 = examinationQuestion.getAnswer2();
        this.answer2Image = examinationQuestion.getAnswer2Image();
        this.answer3 = examinationQuestion.getAnswer3();
        this.answer3Image = examinationQuestion.getAnswer3Image();
        this.answer4 = examinationQuestion.getAnswer4();
        this.answer4Image = examinationQuestion.getAnswer4Image();
        return this;
    }
}
