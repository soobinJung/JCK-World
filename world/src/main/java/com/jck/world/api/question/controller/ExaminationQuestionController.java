package com.jck.world.api.question.controller;

import com.jck.world.api.question.dto.ExaminationQuestionDto;
import com.jck.world.api.question.controller.res.ResExaminationQuestion;
import com.jck.world.api.question.service.ExaminationQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExaminationQuestionController {

    private final ExaminationQuestionService examinationQuestionService;

//    @GetMapping("/examination-question/{examinationId}")
//    public ResExaminationQuestion findAllByExaminationId(@PathVariable Long examinationId) {
//        List<ExaminationQuestionDto> examinationQuestionDtoList = examinationQuestionService.findAllByExaminationId(examinationId);
//        return new ResExaminationQuestion(examinationQuestionDtoList);
//    }
}
