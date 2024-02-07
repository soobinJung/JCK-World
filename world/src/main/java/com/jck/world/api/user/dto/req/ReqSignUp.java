package com.jck.world.api.user.dto.req;

import com.jck.world.api.user.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReqSignUp {

    @NotBlank(message = "User ID is required.")
    @Size(min = 4, max = 12, message = "User ID must be between 4 and 12 characters.")
    private String userId;

    @NotBlank(message = "Password is required.")
    @Size(min = 4, message = "Password must be at least 4 characters.")
    private String password;

    @NotBlank(message = "Name is required.")
    private String name;

    public UserDto toDto(){
        return UserDto
            .builder()
            .userId(this.userId)
            .password(this.password)
            .name(this.name)
            .build();
    }
}