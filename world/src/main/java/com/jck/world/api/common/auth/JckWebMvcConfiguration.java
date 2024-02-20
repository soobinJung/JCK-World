package com.jck.world.api.common.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class JckWebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost",
                        "http://localhost:80",
                        "http://localhost:8080",
                        "http://localhost:3000"
                )
                .allowedMethods(HttpMethod.GET.name()
                        ,HttpMethod.HEAD.name()
                        ,HttpMethod.POST.name()
                        ,HttpMethod.PATCH.name()
                        ,HttpMethod.PUT.name()
                        ,HttpMethod.DELETE.name()
                        ,HttpMethod.OPTIONS.name());
    }
}
