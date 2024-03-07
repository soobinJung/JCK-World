package com.jck.world.api.examinationuser.repository;

import com.jck.world.api.examination.domain.Examination;
import com.jck.world.api.examinationuser.domain.ExaminationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExaminationUserRepository extends JpaRepository<ExaminationUser, Long>{

    @Modifying
    @Query("UPDATE ExaminationUser eu SET eu.endDate = CURRENT_TIMESTAMP WHERE eu.id = :id")
    int updateEndDateById(@Param("id") Long id);

    @Query("SELECT eu FROM ExaminationUser eu WHERE eu.endDate IS NULL AND eu.examination = :examination ORDER BY eu.startDate DESC")
    Optional<ExaminationUser> findTopByEndDateIsNullAndExaminationIdOrderByStartDateDesc(Examination examination);
}
