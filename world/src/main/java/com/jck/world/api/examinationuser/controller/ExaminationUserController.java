package com.jck.world.api.examinationuser.controller;

import com.jck.world.api.examinationuser.service.ExaminationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExaminationUserController {

    private final ExaminationUserService examinationUserService;

    @GetMapping("/api/examination/start/{examinationId}")
    public int startExamination(@PathVariable Long examinationId) {
        return examinationUserService.startExamination(examinationId);
    }

    @GetMapping("/api/examination/end/{examinationId}")
    public int endExamination(@PathVariable Long examinationId) {
        return examinationUserService.endExamination(examinationId);
    }
}
