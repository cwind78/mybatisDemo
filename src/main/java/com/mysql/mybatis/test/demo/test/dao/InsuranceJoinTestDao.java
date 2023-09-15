package com.mysql.mybatis.test.demo.test.dao;

import com.mysql.mybatis.test.demo.user.vo.User;

import java.util.List;

public interface InsuranceJoinTestDao {
    public List<User> getUserList(User user);

    public int getExistsJoinData(User user);

    public int getSerialNumber();

    public int insertJoin(User user);

    public int updateJoin(User user);
}
