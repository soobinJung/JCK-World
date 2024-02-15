package com.jck.world.api.examination.controller;

import com.jck.world.api.examination.controller.res.ResExamination;
import com.jck.world.api.examination.dto.ExaminationDto;
import com.jck.world.api.examination.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ExaminationController {

    private final ExaminationService examinationService;

    @GetMapping("/examination")
    public List<ResExamination> getExamination() {
        System.out.println("hi 1");
        List<ExaminationDto> examinationDtoList = examinationService.getExamination();
        return examinationDtoList.stream()
                .map(ResExamination::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/examination/{id}")
    public ResExamination getExaminationById(@PathVariable Long id) {
        ExaminationDto examinationDto = examinationService.getExaminationById(id);
        return new ResExamination(examinationDto);
    }
}
