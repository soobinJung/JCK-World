package com.jck.world.api.examination.controller;

import com.jck.world.api.examination.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ExaminationController {

    private final ExaminationService examinationService;

    @GetMapping("/examination")
    public void getExamination() {
        examinationService.getExamination();
    }

    @GetMapping("/examination/{id}")
    public void getExaminationById(@PathVariable Long id) {
        examinationService.getExaminationById(id);
    }

}
