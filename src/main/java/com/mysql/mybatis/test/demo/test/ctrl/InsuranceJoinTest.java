package com.mysql.mybatis.test.demo.test.ctrl;

import com.mysql.mybatis.test.demo.common.annotation.MthdLogger;
import com.mysql.mybatis.test.demo.test.svc.InsuranceJoinTestSvc;
import com.mysql.mybatis.test.demo.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class InsuranceJoinTest {
    private InsuranceJoinTestSvc svc;

    @PostMapping("/insurance/set/join")
    public List<User> joinTest(User user) {
        List<User> result = new ArrayList<>();
        //서비스 호출
        try {
            result = svc.joinTest(user);
        } catch (Exception e) {
            log.info("exception message: {}", e.getMessage());
        }
        return result;
    }

    @MthdLogger(isArgumentLogging = true)
    @GetMapping(path = {"/insurance/get/list/{name}", "/insurance/get/list"})
    public List<User> getInsuranceJoinList(@PathVariable(required = false, value="name") String name) {
        return svc.getUserList(new User());
    }

    @MthdLogger(isArgumentLogging = false)
    @GetMapping(path = {"/insurance/get/listo/{name}", "/insurance/get/listo"})
    public List<User> getInsuranceJoinOList(@PathVariable(required = false, value="name") String name) {
        return svc.getUserList(new User());
    }
}
