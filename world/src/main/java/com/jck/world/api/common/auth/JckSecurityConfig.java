package com.jck.world.api.common.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class JckSecurityConfig {

    private final JckTokenProvider tokenProvider;
    private final JckAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                /** CSRF 설정 비활성화 **/
                .csrf(AbstractHttpConfigurer::disable)

                /** 예외 처리 **/
                .exceptionHandling(customizer -> {customizer.authenticationEntryPoint(authenticationEntryPoint);})

                /** 세션 관리 STATELESS 설정 **/
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                /** 인증 예외 URL **/
                .authorizeHttpRequests(auth -> {
                    JckWhiteUrlEnum.stream().forEach(url -> auth.requestMatchers(url).permitAll());
                    auth.anyRequest().authenticated();
                })

                /** JWT 인증 필터 **/
                .addFilterBefore(new JckFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
