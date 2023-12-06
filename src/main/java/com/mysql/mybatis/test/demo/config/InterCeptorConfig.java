package com.mysql.mybatis.test.demo.config;

import com.mysql.mybatis.test.demo.config.interceptor.UriInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
//   WebMvcConfigurationSupport을 상속하면 swagger를 쓸 수 없어서 addResourceHandlers를 오버라이딩 해야 한다.
//   그런데 인텔리제이에서 디팬던시를 전부 외부 라이브러리로 잡고 있어서 클래스 패스 같은 상대적 경로를 사용할 수 없다.
//   다른 방법이 있을 수 있지만 일단은 모름
//   스웨거 되는지 보려고 Configuration 어노테이션 주석 처리 하니까 잘 된다
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:");
    }
}
