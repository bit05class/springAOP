package com.bit.myapp.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class JavaDaoImpl implements JavaDao {
	Logger log = LoggerFactory.getLogger(JavaDaoImpl.class);

	@Override
	public void func01() {
		log.debug("process1 run...");
	}

	@Override
	public String func02() {
		log.debug("process2 run...");
		return "test ok";
	}
}
