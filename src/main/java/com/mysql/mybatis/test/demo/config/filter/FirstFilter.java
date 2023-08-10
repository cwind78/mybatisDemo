package com.mysql.mybatis.test.demo.config.filter;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
		Filter.super.init(filterConfig);
		System.out.println("first filter init");		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//		System.out.println("first filter start");
		Instant stime = Instant.now();
		filterChain.doFilter(request, response);

//		System.out.println("first filter stop");
		Instant etime = Instant.now();
		System.out.println(String.format("Duration time: %s ms", Duration.between(stime, etime).toMillis()));
	}

	@Override
	public void destroy() {
		//
		System.out.println("first filter destroy");
		Filter.super.destroy();
	}
}
