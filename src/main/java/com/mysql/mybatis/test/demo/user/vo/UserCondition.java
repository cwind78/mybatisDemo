package com.mysql.mybatis.test.demo.user.vo;

import com.mysql.mybatis.test.demo.common.vo.PageInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCondition extends PageInfo {
	  private String id;
	  private String name;

}
