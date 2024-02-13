package com.jck.world.api.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonException extends RuntimeException {

    private CommonExceptionEnum code;

    public CommonException(CommonExceptionEnum code) {
        super(code.getMessage()); // 열거형의 실제 메시지를 사용
        this.code = code;
    }
}