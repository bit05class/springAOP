package com.bit.myapp.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("filter init...");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.debug("first before ...");
		chain.doFilter(request, response);
		logger.debug("first after ...");
	}

	@Override
	public void destroy() {
		logger.debug("filter destroy...");
		
	}

}
