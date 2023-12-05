package com.mysql.mybatis.test.demo.test.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
//, BeanPostProcessor
public class InitializationTest implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("[InitializationTest.afterPropertiesSet] ===================================");
    }

    @Override
    public void destroy() throws Exception {
        log.info("[InitializationTest.destroy] ===================================");
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}", beanName);
        log.info("InitializationTest.postProcessorAfterInitialization");

        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("{}", beanName);
        log.info("InitializationTest.postProcessorBeforeInitialization");

        return bean;
    }
}
