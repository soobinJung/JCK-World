package com.jck.world.api.common.auth;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import org.springframework.security.core.userdetails.User;
import com.jck.world.api.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JckUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String userId) {
        com.jck.world.api.user.domain.User user = userRepository.findByUserId(userId).orElseThrow(() -> new CommonException(CommonExceptionEnum.INVALID_USER_ID));
        return createUser(user);

    }

    private User createUser(com.jck.world.api.user.domain.User user) {
        return new User(user.getUserId(),user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }
}
