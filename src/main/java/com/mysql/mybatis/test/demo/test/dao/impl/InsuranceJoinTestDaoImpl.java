package com.mysql.mybatis.test.demo.test.dao.impl;

import com.mysql.mybatis.test.demo.test.dao.InsuranceJoinTestDao;
import com.mysql.mybatis.test.demo.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class InsuranceJoinTestDaoImpl implements InsuranceJoinTestDao {
    public List<User> getUserList(User user) {
        List<User> list = new ArrayList<>();
        list.add(new User("t1", "kim1", "01011111111", "19700101", "1111"));
        list.add(new User("t2", "kim2", "01011111112", "19800101", "1111"));
        list.add(new User("t3", "lee1", "01011111113", "19900101", "1111"));
        list.add(new User("t4", "lee2", "01011111114", "20000101", "1111"));
        list.add(new User("t5", "choi", "01011111115", "20100101", "1111"));
        if (user != null && user.getId() != null) {
            User filterUser = list.stream().filter(a -> a.getId().equals(user.getId())).findAny().orElse(null);
            if (filterUser != null) {
                list.clear();
                list.add(filterUser);
            }
        }

        return list;
    }

    public int getExistsJoinData(User user) {
        return 1;
    }

    public int getSerialNumber() {
        return 999;
    }

    public int insertJoin(User user) {
        return 1;
    }

    public int updateJoin(User user) {
        return 1;
    }
}
