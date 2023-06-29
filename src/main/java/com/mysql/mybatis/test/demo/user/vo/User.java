package com.mysql.mybatis.test.demo.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String phone;
    private String birth;
    private String pwd;
}
