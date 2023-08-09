package com.mysql.mybatis.test.demo.user.ctrl;

//import com.mysql.mybatis.test.demo.common.util.Util;
import com.mysql.mybatis.test.demo.common.vo.Rslt;
import com.mysql.mybatis.test.demo.user.svc.UserSvc;
import com.mysql.mybatis.test.demo.user.type.UserType;
import com.mysql.mybatis.test.demo.user.vo.PagableResponse;
import com.mysql.mybatis.test.demo.user.vo.User;
import com.mysql.mybatis.test.demo.user.vo.UserCondition;

import jakarta.validation.Valid;

import org.springframework.cache.annotation.Cacheable;
//import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public PagableResponse<User> userGetListo(@ModelAttribute @Valid UserCondition condition) throws Exception {
        return svc.userGetList(condition);
    }

    @PostMapping("/user/set/delete")
    public Rslt userDelete(@RequestBody User u) throws Exception {
        type = UserType.DELETE;
        return svc.userProcess(type, u);
    }
    
    @PostMapping("/user/set/update")
    public Rslt userUpdate(@RequestBody User u) throws Exception {
        type = UserType.UPDATE;
        return svc.userProcess(type, u);
    }
    
    @GetMapping("/user/set/block")
    public Rslt userBlockInsert() throws Exception {
        return svc.userBlockInsert();
    }
    
//    Rslt chkParameterVo(User u) {
//    	
//    }
    
    @GetMapping("/user/cache/test")
    @Cacheable(value = "user")
    public List<String> getTodayCacheDate(String day) {
    	System.out.println("No cache");
    	//return LocalDate.now().toString();
    	return Arrays.asList("1", "2", "3", "4");
    }

    @ExceptionHandler(Exception.class)
    public Rslt userObjectRuntimeExceptionResponse(Exception e) {
        System.out.println(e);
        return new Rslt("E", e.getMessage());
    }
}
