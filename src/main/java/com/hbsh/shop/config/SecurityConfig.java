package com.hbsh.shop.config;

import com.hbsh.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    MemberService memberService;
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {

//        //CSRF 비활성화
//        http.csrf(
//                (config) -> {
//                    config.disable();
//                }
//        );
        http.formLogin((login) -> login
                        .loginPage("/members/login") // 로그인 페이지 설정
                        .defaultSuccessUrl("/") //로그인 성공시 이동할 페이지
                        .usernameParameter("email") // 로그인 시 사용할 파라미터로 email 사용
                        .failureUrl("/members/login/error")) // 로그인 실패시 이동할 페이지
                .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) //로그아웃 URL 설정
                .logoutSuccessUrl("/")) //로그아웃 성공시 이동할 url;
        ;
//        로그인 인가 인증처리
        http.authorizeHttpRequests(
                authorize-> {
                    authorize.requestMatchers("/", "/members/**", "/item/**", "/images/**").permitAll();
                    authorize.requestMatchers("/admin/**").hasRole("ADMIN"); //admin/** 주소는 Role에 ADMIN이 있어야함
                    authorize.anyRequest().authenticated(); //위에서 설정한 경로를 제외한 나머지 경로는 모두 인증을 요구함
                }
        );
//          http.exceptionHandling() 메서드를 사용하여 인증 예외 처리를 커스터마이징
        http.exceptionHandling(authenticationManager -> authenticationManager
//                authenticationEntryPoint는 인증 예외가 발생했을 때 어떻게 처리할지를 설정
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));

        return http.build();
    }
    @Bean // 비밀번호를 암호화 하여 저장 데이터 베이스가 해킹당했을 때 정보보호목적 필수
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
