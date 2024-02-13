package com.jck.world.api.user.service;

import com.jck.world.api.common.exception.CommonException;
import com.jck.world.api.common.exception.CommonExceptionEnum;
import com.jck.world.api.user.domain.User;
import com.jck.world.api.user.dto.UserDto;
import com.jck.world.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    @Transactional
    public UserDto signUp(UserDto szsUserDto){

        /** 아이디 중복 체크 **/
        checkDuplicateUserId(szsUserDto.getUserId());

        User szsUser = szsUserDto.toEntity();

        /** 개인 정보 암호화 **/
        encrypt(szsUser);
        userRepository.save(szsUser);

        return szsUser.toDto();
    }

    /**
     * 개인정보 암호화
     */
    private void encrypt(User szsUser){

        /** 비밀번호 **/
        szsUser.setPassword(passwordEncoder.encode(szsUser.getPassword()));
    }

    /**
     * 아이디 중복 체크
     */
    private void checkDuplicateUserId(String userId){
        userRepository.findByUserId(userId).ifPresent(user -> {
            throw new CommonException(CommonExceptionEnum.DUPLICATE_USER_ID);
        });
    }
}