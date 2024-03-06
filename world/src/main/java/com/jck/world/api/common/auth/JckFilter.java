package com.jck.world.api.common.auth;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.ServletException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JckFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_VALUE = "Bearer ";
    private final JckTokenProvider tokenProvider;
    private final SecurityContextRepository securityContextRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException, CommonException {
        String requestURI = request.getRequestURI();
        String jwt = resolveToken(request);

        // 허용되는 URL
        if(JckWhiteUrlEnum.contains(requestURI)){
            if(!jwt.equals("")){
                saveContext(jwt, request, response);
            }
        
        // 인증이 필요한 URL
        } else {
            if(jwt.equals("")){
                throw new CommonException(CommonExceptionEnum.INVALID_TOKEN);
            }

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                saveContext(jwt, request, response);
            }
        }
        filterChain.doFilter(request, response);
    }

    public void saveContext(String jwt, HttpServletRequest request, HttpServletResponse response){

        System.out.println("11 saveContext jwt : " + jwt);

        Authentication authentication = tokenProvider.getAuthentication(jwt);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        System.out.println("11 authentication.getName() : " + authentication.getName());
        SecurityContextHolder.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        request.setAttribute("SPRING_SECURITY_CONTEXT", context);
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