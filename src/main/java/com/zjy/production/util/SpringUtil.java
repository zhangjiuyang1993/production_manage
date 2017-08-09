package com.zjy.production.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 加载spring容器
 * @author Administrator
 *
 */
public class SpringUtil {

	public static ApplicationContext context;
	
	static{
		context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
	}
}
