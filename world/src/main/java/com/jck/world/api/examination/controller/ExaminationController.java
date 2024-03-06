package com.jck.world.api.examination.controller;

import com.jck.world.api.examination.controller.res.ResExamination;
import com.jck.world.api.examination.dto.ExaminationDto;
import com.jck.world.api.examination.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ExaminationController {

    private final ExaminationService examinationService;

    @GetMapping("/api/examination")
    public List<ResExamination> getExamination() {
        List<ExaminationDto> examinationDtoList = examinationService.getExamination();

        if(SecurityContextHolder.getContext() != null) {

            if(SecurityContextHolder.getContext().getAuthentication() != null){

                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                Object authDetail = auth.getDetails();
                System.out.println("authDetail : " + authDetail.getClass());
                Authentication z = (Authentication)auth.getDetails();
                System.out.println("z1 : " + ((Authentication) auth.getDetails()).getName());
                System.out.println("z2 : " + z.getDetails());

            }

        }


        // 인증된 사용자 정보 가져오기


        return examinationDtoList.stream()
                .map(ResExamination::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/examination/{id}")
    public ResExamination getExaminationById(@PathVariable Long id) {
        ExaminationDto examinationDto = examinationService.getExaminationById(id);
        return new ResExamination(examinationDto);
    }
}

