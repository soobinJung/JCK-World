package com.jck.world.api.login.controller;

import com.jck.world.api.common.auth.JckFilter;
import com.jck.world.api.login.dto.req.ReqLogin;
import com.jck.world.api.login.dto.res.ResToken;
import com.jck.world.api.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/jck/login")
    public ResponseEntity<ResToken> login(@Valid @RequestBody ReqLogin loginDto) {

        String jwt = loginService.login(loginDto.toDto());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JckFilter.AUTHORIZATION_HEADER, JckFilter.AUTHORIZATION_HEADER_VALUE + jwt);

        return new ResponseEntity<>(new ResToken(jwt), httpHeaders, HttpStatus.OK);
    }
}