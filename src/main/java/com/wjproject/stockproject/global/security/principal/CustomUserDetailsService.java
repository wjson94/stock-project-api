package com.wjproject.stockproject.global.security.principal;

import com.wjproject.stockproject.auth.entity.User;
import com.wjproject.stockproject.auth.repository.UserRepository;
import com.wjproject.stockproject.global.common.exception.CustomException;
import com.wjproject.stockproject.global.common.response.ErrorCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new CustomException(ErrorCode.STOCK_UNAUTHORIZED));

        return new CustomUserDetails(
                user.getUserSeq(),
                user.getLoginId(),
                user.getPassword()
        );
    }
}