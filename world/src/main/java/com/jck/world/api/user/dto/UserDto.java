package com.jck.world.api.user.dto;

import com.jck.world.api.user.domain.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserDto {

    private Long seq;
    private String userId;
    private String password;
    private String name;
    private LocalDate regDate;

    public User toEntity() {
        return User.builder()
                .seq(this.seq)
                .userId(this.userId)
                .password(this.password)
                .name(this.name)
                .regDate(this.regDate)
                .build();
    }
}