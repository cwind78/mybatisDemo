package com.mysql.mybatis.test.demo.test.svc.impl;

import com.mysql.mybatis.test.demo.test.dao.InsuranceJoinTestDao;
import com.mysql.mybatis.test.demo.test.svc.InsuranceJoinTestSvc;
import com.mysql.mybatis.test.demo.user.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service("insuranceJoinTestSvc")
public class InsuranceJoinTestSvcImpl implements InsuranceJoinTestSvc {
    private InsuranceJoinTestDao dao;

    public List<User> getUserList(User user) {
        return dao.getUserList(user);
    }

    public List<User> joinTest(User user) throws Exception {
        int result = 0;
        result = getExistsJoinData(user) > 0 ? insertJoin(user) : updateJoin(user);
        if (result < 1) {
            throw new Exception("등록(수정)에 실패 하였습니다.");
        }
        return getUserList(user);
    }


    public int getExistsJoinData(User user) {
        return dao.getExistsJoinData(user);
    }

    public int getSerialNumber() {
        return dao.getSerialNumber();
    }

    public int insertJoin(User user) {
        int serialNum = getSerialNumber();
        return dao.insertJoin(user);
    }

    public int updateJoin(User user) {
        return dao.updateJoin(user);
    }
}
