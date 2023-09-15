package com.mysql.mybatis.test.demo.test.svc;

import com.mysql.mybatis.test.demo.test.dao.InsuranceJoinTestDao;
import com.mysql.mybatis.test.demo.test.svc.impl.InsuranceJoinTestSvcImpl;
import com.mysql.mybatis.test.demo.user.vo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class InsuranceJoinTestSvcTest {
    @Mock
    InsuranceJoinTestDao dao;
    InsuranceJoinTestSvc svc;

    User param = new User();
    List<User> l;
    List<User> filteredL;

    @BeforeEach
    public void init() {
        param.setId("t1");

        l = new ArrayList<>();
        l.add(new User("t1", "kim1", "01011111111", "19700101", "1111"));
        l.add(new User("t2", "kim2", "01011111112", "19800101", "1111"));

        filteredL = new ArrayList<>();
        filteredL.add(l.stream().filter(a->a.getId().equals(param.getId())).findAny().orElse(null));

        svc = new InsuranceJoinTestSvcImpl(dao);
    }

    @Test
    public void getUserListTest() {
        given(dao.getUserList(param)).willReturn(filteredL);
        assertEquals(svc.getUserList(param).get(0).getId(), param.getId());
    }

    @Test
    public void joinTest() {
        given(dao.getExistsJoinData(param)).willReturn(0);
        lenient().when(dao.insertJoin(param)).thenReturn(0);
        assertThrows(Exception.class, () -> { svc.joinTest(param); });
    }
}
