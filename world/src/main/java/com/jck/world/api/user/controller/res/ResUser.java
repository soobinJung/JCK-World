package com.jck.world.api.user.controller.res;

import com.jck.world.api.user.dto.UserDto;
import lombok.Getter;

@Getter
public class ResUser {

    private Long seq;

    private String userId;

    private String name;

    public ResUser(UserDto dto){
        this.seq = dto.getSeq();
        this.userId = dto.getUserId();
        this.name = dto.getName();
    }
}