package com.mysql.mybatis.test.demo.user.dao;

import com.mysql.mybatis.test.demo.user.vo.PagableResponse;
import com.mysql.mybatis.test.demo.user.vo.User;
import com.mysql.mybatis.test.demo.user.vo.UserCondition;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

//import java.util.List;


@Mapper
//@CacheNamespace
public interface UserDao {
//    @CacheEvict(value = "userCache")//allEntries = true, beforeInvocation=false)
    public int userRegist(User u);
//    @CacheEvict(value = "userCache")//allEntries = true, beforeInvocation=false)
    public int userUpdate(User u);
//    @CacheEvict(value = "userCache")//allEntries = true, beforeInvocation=false)
    public int userDelete(User u);
//    @Cacheable(value = "userCache")
    @Select("""
          <script>
            SELECT * FROM USER_master
            WHERE 1 = 1
            <if test='id != null and !id.equals("")'>
              AND ID LIKE '%${id}%'
            </if>
          </script>
      """)
    public PagableResponse<User> userGetList(UserCondition condition);
}
