package com.jck.world.api.user.domain;

import com.jck.world.api.user.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String userId;
    private String password;
    private String name;
    @CreatedDate
    private LocalDate regDate;

    public UserDto toDto() {
        return UserDto.builder()
            .seq(this.seq)
            .userId(this.userId)
            .password(this.password)
            .name(this.name)
            .regDate(this.regDate)
            .build();
    }
}