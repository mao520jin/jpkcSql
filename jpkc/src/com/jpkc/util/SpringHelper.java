package com.jpkc.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * Spring 工具类
 * 
 * @author chenfan
 * @version 1.0, 2015/09/17
 * 
 */
public final class SpringHelper {

	private volatile static ApplicationContext applicationContext;

	private SpringHelper() {
	}

	/**
	 * 
	 * 获取 Spring 上下文
	 * 
	 * @return
	 * 
	 */
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			synchronized (SpringHelper.class) {
				if (applicationContext == null) {

					// spring.xml
					// spring-redis.xml
					// spring-quartz.xml
					// spring-web.xml

					// 本地测试环境
					String[] configLocations = { "WebRoot/WEB-INF/spring.xml" };
					applicationContext = new FileSystemXmlApplicationContext(configLocations);

					// 正试环境
					// String[] locations = { "WEB-INF/spring.xml",
					// "WEB-INF/spring-redis.xml" };
					// XmlWebApplicationContext xmlWebApplicationContext = new
					// XmlWebApplicationContext();
					// xmlWebApplicationContext.setConfigLocations(locations);
					// applicationContext = xmlWebApplicationContext;
				}
			}
		}
		return applicationContext;
	}

	/**
	 * 
	 * 获取 Bean 对象
	 * 
	 * @param name
	 * @return
	 * 
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

}
