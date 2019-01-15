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

public class MyFilter2 implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(MyFilter2.class);
	String value;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("filter2 init...");
		value=filterConfig.getInitParameter("myparam");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.debug("second before ... "+value);
		chain.doFilter(request, response);
		logger.debug("second after ... "+value);
	}

	@Override
	public void destroy() {
		logger.debug("filter2 destroy...");
		
	}

}
