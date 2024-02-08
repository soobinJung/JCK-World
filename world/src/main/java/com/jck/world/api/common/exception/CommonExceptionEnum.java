package com.jck.world.api.common.exception;

import lombok.Getter;

public enum CommonExceptionEnum {

    DUPLICATE_USER_ID(1000, "이미 사용중인 아이디입니다.")
    , INVALID_USER_ID(1001,  "아이디가 존재하지 않습니다.")
    , INVALID_PASSWORD(1002, "비밀번호가 일치하지 않습니다.")
    , INVALID_TOKEN(1003, "유효하지 않은 토큰입니다.")
    , AUTHENTICATION_ERROR(1004, "인증에러입니다.")
    , EXPIRED_TOKEN(1005, "만료된 토큰입니다.")
    , UNAUTHORIZED(1006, "권한이 없습니다.")
    , INVALID_PARAMETER(1007, "잘못된 요청입니다.")
    , INTERNAL_SERVER_ERROR(1008, "서버 오류입니다.")
    , NOT_FOUND(1009, "요청한 정보를 찾을 수 없습니다.")
    , BAD_REQUEST(1010, "잘못된 요청입니다.")
    , FORBIDDEN(1011, "접근이 금지되었습니다.");

    private int code;
    private String message;

    CommonExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
