package com.mysql.mybatis.test.demo.test.ctrl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@NoArgsConstructor
public class AnnotationInitializeDestroyTest {
    @PostConstruct
    public void annotationInitMethod() {
        log.info("AnnotationInitializeDestroyTest.init log===================================");
    }

    @PreDestroy
    public void annotationDestroyMethod() throws Exception {
        log.info("AnnotationInitializeDestroyTest.destroy log===================================");
    }
}
