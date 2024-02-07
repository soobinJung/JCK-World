package com.jck.world.api.common.exception;

public enum CommonExceptionEnum {

    DUPLICATE_USER_ID("이미 사용중인 아이디입니다.")
    , INVALID_USER_ID("아이디가 존재하지 않습니다.")
    , INVALID_PASSWORD("비밀번호가 일치하지 않습니다.")
    , INVALID_TOKEN("유효하지 않은 토큰입니다.")
    , AUTHENTICATION_ERROR("인증에러입니다.")
    , EXPIRED_TOKEN("만료된 토큰입니다.")
    , UNAUTHORIZED("권한이 없습니다.")
    , INVALID_PARAMETER("잘못된 요청입니다.")
    , INTERNAL_SERVER_ERROR("서버 오류입니다.")
    , NOT_FOUND("요청한 정보를 찾을 수 없습니다.")
    , BAD_REQUEST("잘못된 요청입니다.")
    , FORBIDDEN("접근이 금지되었습니다.");

    private String message;

    CommonExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
