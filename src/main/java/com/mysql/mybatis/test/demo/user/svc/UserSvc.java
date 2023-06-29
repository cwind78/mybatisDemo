package com.mysql.mybatis.test.demo.user.svc;

import com.mysql.mybatis.test.demo.common.vo.Rslt;
import com.mysql.mybatis.test.demo.user.type.UserType;
import com.mysql.mybatis.test.demo.user.vo.User;

import java.util.List;

public interface UserSvc {
    public Rslt userProcess(UserType t, User u) throws Exception;
    public List<User> userGetList();
}
