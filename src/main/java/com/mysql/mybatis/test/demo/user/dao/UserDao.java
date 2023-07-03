package com.mysql.mybatis.test.demo.user.dao;

import com.mysql.mybatis.test.demo.user.vo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
@CacheNamespace
public interface UserDao {
//    @CacheEvict(value = "userCache")//allEntries = true, beforeInvocation=false)
    public int userRegist(User u);
//    @CacheEvict(value = "userCache")//allEntries = true, beforeInvocation=false)
    public int userUpdate(User u);
//    @CacheEvict(value = "userCache")//allEntries = true, beforeInvocation=false)
    public int userDelete(User u);
//    @Cacheable(value = "userCache")
    @Select("select id, name, phone, birth, pwd from user_master where 1 = 1")
    public List<User> userGetList();
}
