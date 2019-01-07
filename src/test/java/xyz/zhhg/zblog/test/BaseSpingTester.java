package xyz.zhhg.zblog.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseSpingTester {
	protected ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
}
