package com.jck.world.api.user.controller;


import com.jck.world.api.user.controller.req.ReqSignUp;
import com.jck.world.api.user.controller.res.ResUser;
import com.jck.world.api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/jck/sign-up")
    public ResUser signUp(@RequestBody @Valid ReqSignUp reqSignUp ){
        return new ResUser(userService.signUp(reqSignUp.toDto()));
    }
}