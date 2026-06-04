package com.wjproject.stockproject.global.security.principal;

import com.wjproject.stockproject.auth.entity.User;
import com.wjproject.stockproject.auth.repository.UserRepository;
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
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("유저 없음: " + userId));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserId())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}