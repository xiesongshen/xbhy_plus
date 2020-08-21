package com.xss.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author XSS
 * @date 2020/8/14
 * @desc
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("loginUser");
        ObjectMapper om = new ObjectMapper();

        String uri = request.getRequestURI();
        System.out.println(uri);

        if (uri.endsWith("/toHome")) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (!"LoginUserCookie".equals(cookie.getName())) {
                        response.sendRedirect("/index.html");
                        return false;
                    }
                }
            }

        }
        if (o == null) {
            response.sendRedirect("/index.html");
            return false;
        }


        return true;
    }
}
