package com.jck.world.api.examinationuser.service;

import com.jck.world.api.common.auth.JckSecurityUtils;
import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.examination.repository.ExaminationRepository;
import com.jck.world.api.examinationuser.domain.ExaminationUser;
import com.jck.world.api.examinationuser.repository.ExaminationUserRepository;
import com.jck.world.api.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExaminationUserService {

    private final ExaminationUserRepository examinationUserRepository;
    private final ExaminationRepository examinationRepository;
    private final JckSecurityUtils jckSecurityUtils;

    /*
     * 시험 시작
     */
    public int startExamination(Long examinationId) {
        Optional<User> user = jckSecurityUtils.getCurrentUser();
        // 시험 시작 처리
        user.ifPresent(u -> examinationUserRepository.save(
            ExaminationUser.builder()
                .user(u)
                .startDate(LocalDateTime.now())
                .examination(examinationRepository.findById(examinationId).orElseThrow(() -> new RuntimeException("시험 정보가 없습니다.")))
                .score(0)
                .endDate(null)
                .build()
        ));
        return 1;
    }


    /*
     * 시험 종료
     */
    public int endExamination(Long examinationId) {
        Optional<User> user = jckSecurityUtils.getCurrentUser();

        // 시험 정보 조회
        Examination examination = examinationRepository.findById(examinationId).orElseThrow(() -> new RuntimeException("시험 정보가 없습니다."));
        
        // 시험 종료 처리
        user.flatMap(u -> examinationUserRepository.findTopByEndDateIsNullAndExaminationIdOrderByStartDateDesc(examination))
            .ifPresent(examinationUser -> examinationUserRepository.updateEndDateById(examinationUser.getId()));

        return 1;
    }
}
