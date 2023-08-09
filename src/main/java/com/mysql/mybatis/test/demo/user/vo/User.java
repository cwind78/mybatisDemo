package com.mysql.mybatis.test.demo.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String phone;
    private String birth;
    private String pwd;
}
