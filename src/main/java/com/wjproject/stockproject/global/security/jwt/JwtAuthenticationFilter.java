package com.wjproject.stockproject.global.security.jwt;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter
        extends GenericFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(
            JwtTokenProvider jwtTokenProvider
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        String bearerToken =
                httpRequest.getHeader("Authorization");

        if (bearerToken != null
                && bearerToken.startsWith("Bearer ")) {

            String token =
                    bearerToken.substring(7);

            boolean valid =
                    jwtTokenProvider.validate(token);

            if (!valid) {
                throw new RuntimeException("JWT 오류");
            }
        }

        chain.doFilter(request, response);
    }
}