package com.jck.world.api.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonException extends RuntimeException {

    private CommonExceptionEnum code;

    private Map<String, String> errors;

    public CommonException(CommonExceptionEnum code) {
        this.code = code;
    }

    public CommonException(CommonExceptionEnum code, Map<String, String> errors) {
        this.code = code;
        this.errors = errors;
    }
}