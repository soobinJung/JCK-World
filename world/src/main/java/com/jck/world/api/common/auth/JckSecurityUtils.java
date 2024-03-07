package com.jck.world.api.common.auth;

import com.jck.world.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JckSecurityUtils {

    private final UserRepository userRepository;

    @Autowired
    public JckSecurityUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * 현재 로그인 중인 사용자 정보 가져오기
     *
     * @return Optional<com.jck.world.api.user.domain.User>
     */
    public Optional<com.jck.world.api.user.domain.User> getCurrentUser() {

        if(SecurityContextHolder.getContext() != null) {
            if(SecurityContextHolder.getContext().getAuthentication() != null){
                org.springframework.security.core.userdetails.User user =(org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String userId = user.getUsername();
                Optional<com.jck.world.api.user.domain.User> userOptional = userRepository.findByUserId(userId);
                return userOptional;
            }
        }

        return Optional.empty();
    }
}
