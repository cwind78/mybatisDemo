package com.mysql.mybatis.test.demo.test.ctrl;

import com.mysql.mybatis.test.demo.user.vo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class JdbcTemplateTest {
    private JdbcTemplate jdbctemplate;
    public JdbcTemplateTest(DataSource dataSource) {
        this.jdbctemplate = new JdbcTemplate(dataSource);
    }

    @GetMapping("/test/user/get/t1")
    public List<User> getUserMasterList() {
        return this.jdbctemplate.query("select user_id as id, name, phone, birth, pwd from user_master where user_id like concat('t1','%')", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getString("id")
                    , rs.getString("name")
                        , rs.getString("phone")
                        , rs.getString("birth")
                        , rs.getString("pwd")
                );
            }
        });
    }
}
