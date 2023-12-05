package com.mysql.mybatis.test.demo.config;

import com.mysql.mybatis.test.demo.config.interceptor.UriInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterCeptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    UriInterceptor interceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**/**")
//                .excludePathPatterns("/admin/myPage")
                ;

//        registry.addInterceptor(new UserInterceptor())
//                .addPathPatterns("/user/**");
    }
}
