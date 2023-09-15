package com.mysql.mybatis.test.demo.test.ctrl;

import com.mysql.mybatis.test.demo.test.svc.InsuranceJoinTestSvc;
import com.mysql.mybatis.test.demo.test.svc.impl.InsuranceJoinTestSvcImpl;
import com.mysql.mybatis.test.demo.user.vo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InsuranceJoinTestTest {
    @Mock
    InsuranceJoinTestSvc svc;

    List<User> l;
    List<User> filteredL;
    User param;

    @BeforeEach
    void init() {
        param = new User();
        param.setId("t1");

        l = new ArrayList<>();
        l.add(new User("t1", "kim1", "01011111111", "19700101", "1111"));
        l.add(new User("t2", "kim2", "01011111112", "19800101", "1111"));

        filteredL = new ArrayList<>();
        filteredL.add(getFilteredListByParam(param));
    }

    public User getFilteredListByParam(User param) {
        return l.stream().filter(a -> a.getId().equals(param.getId())).findAny().orElse(null);
    }

    @Test
    public void joinGoodTest() {
        //서비스 호출
        try {
            given(svc.joinTest(param)).willReturn(filteredL);
            assertEquals(svc.joinTest(param).get(0).getId(), "t1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getInsuranceJoinList() {
        given(svc.getUserList(new User())).willReturn(l);
        assertEquals(svc.getUserList(new User()).size(), 2);
    }
}
