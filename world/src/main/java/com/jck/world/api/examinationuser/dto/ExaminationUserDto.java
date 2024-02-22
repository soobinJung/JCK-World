package com.jck.world.api.examinationuser.dto;

import com.jck.world.api.examination.dto.ExaminationDto;
import com.jck.world.api.examinationuser.domain.ExaminationUser;
import com.jck.world.api.user.dto.UserDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ExaminationUserDto {

    /** 사용자 시험 일련번호 **/
    private Long id;

    /** 시험 **/
    private ExaminationDto examination;

    /** 사용자 **/
    private UserDto user;

    /** 점수 **/
    private int score;

    /** 시험 시작일 **/
    private LocalDateTime startDate;

    /** 시험 마지막일 **/
    private LocalDateTime endDate;

    public ExaminationUser toEntity() {
        return ExaminationUser.builder()
                .id(id)
                .examination(examination.toEntity())
                .user(user.toEntity())
                .score(score)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
