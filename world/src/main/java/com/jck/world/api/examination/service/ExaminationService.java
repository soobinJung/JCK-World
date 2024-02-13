package com.jck.world.api.examination.service;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.examination.repository.ExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 시험 목록 관리
 */
@RequiredArgsConstructor
@Service
public class ExaminationService {

    private final ExaminationRepository examinationRepository;

    public List<Examination> getExamination() {
        return examinationRepository.findAll();
    }

    public Examination getExaminationById(Long id) {
        return examinationRepository.findById(id).orElseThrow( () -> new CommonException(CommonExceptionEnum.NO_DATA) );
    }
}
