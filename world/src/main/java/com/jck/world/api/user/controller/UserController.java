package com.jck.world.api.user.controller;


import com.jck.world.api.user.dto.req.ReqSignUp;
import com.jck.world.api.user.dto.res.ResUser;
import com.jck.world.api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/jck/sign-up")
    public ResponseEntity<ResUser> signUp(@RequestBody @Valid ReqSignUp reqSignUp ){
        ResUser resUser = new ResUser(userService.signUp(reqSignUp.toDto()));
        return new ResponseEntity<>(resUser, HttpStatus.OK);
    }
}