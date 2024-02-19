package com.jck.world.api.examinationuser.domain;

import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.examinationuser.dto.ExaminationUserDto;
import com.jck.world.api.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ExaminationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Examination examination;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Comment("점수")
    private int score;

    @Comment("시험 시작일")
    private LocalDateTime startDate;

    @Comment("시험 마지막일")
    private LocalDateTime endDate;

    public ExaminationUserDto toDto() {
        return ExaminationUserDto.builder()
                .id(id)
                .examination(examination.toDto())
                .user(user.toDto())
                .score(score)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
