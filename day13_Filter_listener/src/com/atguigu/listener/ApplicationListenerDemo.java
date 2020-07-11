package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListenerDemo implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application创建啦！");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application销毁啦！");
	}

}
