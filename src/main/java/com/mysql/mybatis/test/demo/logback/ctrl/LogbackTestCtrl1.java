package com.mysql.mybatis.test.demo.logback.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.mybatis.test.demo.common.vo.Rslt;
import com.mysql.mybatis.test.demo.user.vo.User;

@RestController
public class LogbackTestCtrl1 {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/logback/test/ctrl1")
	public Rslt getUserConditionCheck(@ModelAttribute User v) {
		logger.debug(v.toString());
		
		return new Rslt("S", "성공");
	}
}
