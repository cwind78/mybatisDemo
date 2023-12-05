package com.mysql.mybatis.test.demo.config.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SecondFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
		Filter.super.init(filterConfig);
//		System.out.println("second filter init");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		//System.out.println("second filter start");
		filterChain.doFilter(request, response);
		//System.out.println("second filter stop");
	}

	@Override
	public void destroy() {
		//
//		System.out.println("second filter destroy");
		Filter.super.destroy();
	}

}
