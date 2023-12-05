package com.mysql.mybatis.test.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.mybatis.test.demo.config.filter.FirstFilter;
import com.mysql.mybatis.test.demo.config.filter.SecondFilter;

@Configuration
public class FilterConfig {
	@Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegister()  {
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>(new FirstFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilterRegister()  {
        FilterRegistrationBean<SecondFilter> registrationBean = new FilterRegistrationBean<>(new SecondFilter());
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
