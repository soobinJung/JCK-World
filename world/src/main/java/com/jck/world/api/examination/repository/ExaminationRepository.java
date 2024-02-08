package com.jck.world.api.examination.repository;

import com.jck.world.api.examination.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
