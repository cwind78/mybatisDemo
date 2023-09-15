package com.mysql.mybatis.test.demo.test.svc;

import com.mysql.mybatis.test.demo.user.vo.User;

import java.util.List;

public interface InsuranceJoinTestSvc {
    public List<User> getUserList(User user);
    public List<User> joinTest(User user) throws Exception;

    public int getExistsJoinData(User user);

    public int getSerialNumber();

    public int insertJoin(User user);

    public int updateJoin(User user);
}
