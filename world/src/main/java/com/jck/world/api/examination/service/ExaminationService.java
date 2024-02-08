package com.jck.world.api.examination.service;

import com.jck.world.api.examination.repository.ExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExaminationService {

    private final ExaminationRepository examinationRepository;

    public void getExamination() {
        examinationRepository.findAll();
    }

    public void getExaminationById(Long id) {
        examinationRepository.findById(id);
    }
}
