package com.tiagoramirez_portfolio.portfolio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tiagoramirez_portfolio.portfolio.security.jwt.JwtEntryPoint;
import com.tiagoramirez_portfolio.portfolio.security.jwt.JwtTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
        http.authorizeRequests().antMatchers("/about-me/get/**").permitAll();
        http.authorizeRequests().antMatchers("/banner/get/**").permitAll();
        http.authorizeRequests().antMatchers("/configuration/get/**").permitAll();
        http.authorizeRequests().antMatchers("/description/get/**/**/**").permitAll();
        http.authorizeRequests().antMatchers("/education/get/**").permitAll();
        http.authorizeRequests().antMatchers("/experience/get/**").permitAll();
        http.authorizeRequests().antMatchers("/photo/get/**").permitAll();
        http.authorizeRequests().antMatchers("/profile/get/**").permitAll();
        http.authorizeRequests().antMatchers("/project/get/**").permitAll();
        http.authorizeRequests().antMatchers("/skill/all").permitAll();
        http.authorizeRequests().antMatchers("/skill/get/**").permitAll();
        http.authorizeRequests().antMatchers("/social-media/all").permitAll();
        http.authorizeRequests().antMatchers("/social-media/get/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
