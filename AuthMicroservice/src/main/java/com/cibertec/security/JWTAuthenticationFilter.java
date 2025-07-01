package com.cibertec.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cibertec.model.Auth;
import com.cibertec.serviceImpl.UserDetailImplement;
import com.cibertec.util.Token;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        Auth authCredenciales = new Auth();

        try {
            authCredenciales = new ObjectMapper().readValue(request.getReader(), Auth.class);
            logger.info("Attempting authentication for email: {}", authCredenciales.getEmail());
        } catch (Exception e) {
            logger.error("Failed to parse login request", e);
        }

        UsernamePasswordAuthenticationToken userPAT = new UsernamePasswordAuthenticationToken(
                authCredenciales.getEmail(),
                authCredenciales.getPassword(),
                Collections.emptyList()
        );

        return getAuthenticationManager().authenticate(userPAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailImplement userDetails = (UserDetailImplement) authResult.getPrincipal();
        String token = Token.crearToken(userDetails.getId(), userDetails.getUser(), userDetails.getUsername(), userDetails.getRole());

        logger.info("Authentication successful for: {}", userDetails.getUsername());

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        logger.warn("Authentication failed: {}", failed.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Credenciales inválidas");
        response.getWriter().flush();
    }
}
