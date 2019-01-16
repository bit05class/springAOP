package com.bit.myapp.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaDaoImpl implements JavaDao {
	Logger log = LoggerFactory.getLogger(JavaDaoImpl.class);

	@Override
	public void func01() {
		log.debug("process run...");
	}
}
