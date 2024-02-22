package com.jck.world.api.question.domain;

import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.question.dto.ExaminationQuestionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ExaminationQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "examination_id")
    private Examination examination;

    @Comment("문제")
    private String question;

    @Comment("정답")
    private String correctAnswer;

    @Comment("답안1 - 텍스트")
    private String answer1;

    @Comment("답안1 - 이미지")
    private String answer1Image;

    @Comment("답안2 - 텍스트")
    private String answer2;

    @Comment("답안2 - 이미지")
    private String answer2Image;

    @Comment("답안3")
    private String answer3;

    @Comment("답안3 - 이미지")
    private String answer3Image;

    @Comment("답안4")
    private String answer4;

    @Comment("답안4 - 이미지")
    private String answer4Image;

    public ExaminationQuestionDto toDto() {
        return ExaminationQuestionDto.builder()
                .id(id)
                .examination(examination.toDto())
                .question(question)
                .correctAnswer(correctAnswer)
                .answer1(answer1)
                .answer1Image(answer1Image)
                .answer2(answer2)
                .answer2Image(answer2Image)
                .answer3(answer3)
                .answer3Image(answer3Image)
                .answer4(answer4)
                .answer4Image(answer4Image)
                .build();
    }
}
