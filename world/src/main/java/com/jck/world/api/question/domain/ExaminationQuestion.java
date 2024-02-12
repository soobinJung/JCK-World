package com.jck.world.api.question.domain;

import com.jck.world.api.examination.domain.Examination;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExaminationQuestion {

    @Id
    @GeneratedValue(strategy = GeanerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "examination_id")
    private Examination examination;

    private String question;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
}
