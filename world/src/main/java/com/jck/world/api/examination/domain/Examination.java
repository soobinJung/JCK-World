package com.jck.world.api.examination.domain;

import com.jck.world.api.examination.code.ExaminationPartType;
import com.jck.world.api.examination.code.ExaminationType;
import com.jck.world.api.examination.dto.ExaminationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Examination {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("시험일자")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Comment("정보처리기사 / 정보처리산업기사 구분")
    private ExaminationType type;

    @Enumerated(EnumType.STRING)
    @Comment("필기 / 실기 구분")
    private ExaminationPartType partType;

    public ExaminationDto toDto() {
        return ExaminationDto.builder()
                .id(id)
                .date(date)
                .type(type)
                .partType(partType)
                .build();
    }
}
