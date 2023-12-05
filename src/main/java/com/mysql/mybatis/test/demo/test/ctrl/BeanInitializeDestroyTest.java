package com.mysql.mybatis.test.demo.test.ctrl;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class BeanInitializeDestroyTest {
    public void initMethod() throws Exception {
        log.info("BeanInitializeDestroyTest.init log===================================");
    }

    public void destroyMethod() throws Exception {
        log.info("BeanInitializeDestroyTest.destroy log===================================");
    }
}
