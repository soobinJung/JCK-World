package com.jck.world.api.examinationuser.repository;

import com.jck.world.api.examinationuser.domain.ExaminationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationUserRepository extends JpaRepository<ExaminationUser, Long>{
}
