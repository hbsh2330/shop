package com.hbsh.shop.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// AuthenticationEntryPoint는 인증이 실패하거나 인증이 필요한 자원에 접근 권한이 없는 경우 어떻게 처리할지 정의하는 인터페이스
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

//commence 메서드는 인증이 실패했을 때 호출되며, 해당 메서드에서는 어떻게 응답할지를 정의
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
//        만약 요청이 Ajax 요청인 경우(헤더에 x-requested-with이면 ajax인증), HTTP 상태 코드 401을 반환하고
        if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//            아니면 /members/login으로 이동
        } else {
            response.sendRedirect("/members/login");
        }
    }
}