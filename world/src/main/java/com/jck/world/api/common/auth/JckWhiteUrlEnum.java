package com.jck.world.api.common.auth;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * 인증 예외 URL 목록
 */
@Getter
public enum JckWhiteUrlEnum {

    LOGIN("/jck/login"),
    SIGN_UP("/jck/sign-up"),
    SWAGGER_UI1("/swagger-ui/**"),
    SWAGGER_UI("/v3/api-docs/**"),
    SWAGGER_FAVICON("/favicon.ico"),
    EXAMINATION("/api/examination"),
    XXX("/swagger-ui/index.html"),
    EXAMINATION_ONE("/api/examination/**");

    private final String url;

    JckWhiteUrlEnum(String url) {
        this.url = url;
    }

    /**
     * 인증 예외 URL 목록에 포함되어 있는지 확인
     */
    public static boolean contains(String url) {
        for (JckWhiteUrlEnum whiteListUrl : JckWhiteUrlEnum.values()) {
            String enumUrl = whiteListUrl.getUrl();
            if (enumUrl.endsWith("/**")) {
                String basePart = enumUrl.substring(0, enumUrl.length() - "/**".length());
                if (url.startsWith(basePart)) {
                    return true;
                }
            } else if (enumUrl.equals(url)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 인증 예외 URL 목록 스트림 반환
     */
    public static Stream<String> stream() {
        return Stream.of(JckWhiteUrlEnum.values()).map(JckWhiteUrlEnum::getUrl);
    }

}
