package com.mysql.mybatis.test.demo.test.config;

import com.mysql.mybatis.test.demo.test.ctrl.BeanInitializeDestroyTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializeDestroyConfig {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanInitializeDestroyTest getBeanInitializeDestroyTest() {
        return new BeanInitializeDestroyTest();
    }
}
