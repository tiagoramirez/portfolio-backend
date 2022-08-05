package com.tiagoramirez_portfolio.portfolio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.tiagoramirez_portfolio.portfolio.security.jwt.JwtEntryPoint;
import com.tiagoramirez_portfolio.portfolio.security.jwt.JwtTokenFilter;

@Configuration
public class MainSecurity {
    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests().antMatchers("/auth/**").permitAll();
        // http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().anyRequest().permitAll();
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.addFilterBefore(jwtTokenFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }
}
