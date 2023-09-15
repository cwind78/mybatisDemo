package com.mysql.mybatis.test.demo.user.svc.impl;

import com.mysql.mybatis.test.demo.common.util.Util;
import com.mysql.mybatis.test.demo.common.vo.Rslt;
import com.mysql.mybatis.test.demo.user.dao.UserDao;
import com.mysql.mybatis.test.demo.user.svc.UserSvc;
import com.mysql.mybatis.test.demo.user.type.UserType;
import com.mysql.mybatis.test.demo.user.vo.PagableResponse;
import com.mysql.mybatis.test.demo.user.vo.User;
import com.mysql.mybatis.test.demo.user.vo.UserCondition;

//import org.apache.ibatis.annotations.Mapper;
//import org.mybatis.spring.SqlSessionTemplate;
import com.mysql.mybatis.test.demo.user.vo.UserCondition;
import org.springframework.stereotype.Service;
//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service("userSvc")
public class UserSvcImpl implements UserSvc {
    UserDao dao;
    Rslt r;

    UserSvcImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Rslt userProcess(UserType t, User u) throws Exception {
        int intValue = 0;
        if (Util.isEmpty(u.getId()) || Util.isEmpty(u.getName()) || Util.isEmpty(u.getPwd())) {
            return new Rslt("E", "사용자 정보 누락");
        } else {
            Object o;//= UserDao.class.getDeclaredMethod(t.getMthd(), User.class).invoke(u);
            for (Method m: UserDao.class.getDeclaredMethods()) {
                if (m.getName().equals(t.getMthd())) {
                    o = m.invoke(dao, u);
                    intValue = (int) o;
                }
            }
//            Object o = UserDao.class.getMethod(t.getMthd(), User.class).invoke(u);
            return Util.simpleProcessResponse(new BigDecimal(intValue));
        }
    }

    public PagableResponse<User> userGetList(UserCondition condition) {
        return dao.userGetList(condition);
    }
    
    public Rslt userBlockInsert() {
    	Rslt rslt = new Rslt("S", "성공");
    	try {
	    	IntStream.rangeClosed(0, 1000).forEach(i-> {
	    		String s = String.valueOf(i);
	    		dao.userRegist(new User("t"+s, "t"+s, "01011112222", "19990101", "t"+s));
	    	});
    	} catch (Exception e) {
    		rslt.setCode("E");
    		rslt.setMsg("오류");
    	}
    	return rslt;
    }
}
