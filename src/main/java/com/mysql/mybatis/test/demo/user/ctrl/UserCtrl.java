package com.mysql.mybatis.test.demo.user.ctrl;

import com.mysql.mybatis.test.demo.common.util.Util;
import com.mysql.mybatis.test.demo.common.vo.Rslt;
import com.mysql.mybatis.test.demo.user.svc.UserSvc;
import com.mysql.mybatis.test.demo.user.type.UserType;
import com.mysql.mybatis.test.demo.user.vo.User;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCtrl {
    UserSvc svc;
    UserType type;
    UserCtrl (UserSvc svc) {
        this.svc = svc;
    }

    @PostMapping("/user/set/regist")
    public Rslt userRegist(@RequestBody User u) throws Exception {
        type = UserType.REGIST;
        return svc.userProcess(type, u);
    }

    @GetMapping("/user/getList")
    public List<User> userGetList() throws Exception {
        return svc.userGetList();
    }

    @PostMapping("/user/set/delete")
    public Rslt userDelete(@RequestBody User u) throws Exception {
        type = UserType.DELETE;
        return svc.userProcess(type, u);
    }

    @ExceptionHandler(Exception.class)
    public Rslt userObjectRuntimeExceptionResponse(Exception e) {
        System.out.println(e);
        return new Rslt("E", e.getMessage());
    }
}
