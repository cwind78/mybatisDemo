package com.mysql.mybatis.test.demo.config.interceptor;

import com.mysql.mybatis.test.demo.user.ctrl.UserCtrl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class UriInterceptor implements HandlerInterceptor {
    @Autowired
    UserCtrl ctrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("In preHandle");
        if (request.getRequestURI().equals("/user/getlist/test")) {
            ctrl.userGetListo();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndVew) throws Exception {
//        log.info("In postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
//        log.info("In afterCompletion");
    }
}
