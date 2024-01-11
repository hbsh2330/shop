package com.hbsh.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {

        //CSRF 비활성화
        http.csrf(
                (config) -> {
                    config.disable();
                }
        );

        return http.build();
    }
    @Bean // 비밀번호를 암호화 하여 저장 데이터 베이스가 해킹당했을 때 정보보호목적 필수
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
