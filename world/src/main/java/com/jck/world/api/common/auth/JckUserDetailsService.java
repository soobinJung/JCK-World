package com.jck.world.api.common.auth;

import org.springframework.security.core.userdetails.User;
import com.jck.world.api.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JckUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String userId) {
        return createUser(userRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 사용자입니다.")));

    }

    private User createUser(com.jck.world.api.user.domain.User user) {
        return new User(user.getUserId(),user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }
}
