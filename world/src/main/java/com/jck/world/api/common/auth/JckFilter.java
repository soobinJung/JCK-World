package com.jck.world.api.common.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.ServletException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class JckFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_VALUE = "Bearer ";
    private final JckTokenProvider tokenProvider;

    public JckFilter(JckTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException, CommonException {
        String requestURI = request.getRequestURI();
        if (!JckWhiteUrlEnum.contains(requestURI)) {
            String jwt = resolveToken(request);

            if(jwt.equals("")){
                throw new CommonException(CommonExceptionEnum.INVALID_TOKEN);
            }

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                Authentication authentication = tokenProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     *  Request Header 에서 토큰 정보 조회
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(AUTHORIZATION_HEADER_VALUE)) {
            return bearerToken.substring(7);
        }

        return "";
    }
}