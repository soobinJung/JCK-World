package com.jck.world.api.common.auth;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * 인증 관리 실패 처리
 */
@Component
@Slf4j
public class JckAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        System.out.println("인증 실패");
        log.error("인증 실패", authException);
        log.error("인증 실패. 요청 정보: [{} {}], IP: {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr(), authException);

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

//        authException.printStackTrace();
        CommonException exceptionDto = new CommonException(CommonExceptionEnum.AUTHENTICATION_ERROR);
        String errorMsg = objectMapper.writeValueAsString(exceptionDto);
        response.getWriter().print(errorMsg);
    }
}