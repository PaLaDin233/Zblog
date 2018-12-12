package xyz.zhhg.zblog.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.controller.UserController;
import xyz.zhhg.zblog.pojo.User;

public class UserTest {
	public static void main(String[] args) {
		AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("/spring-context.xml");
		
		UserController controller=(UserController) abstractApplicationContext.getBean("userController");
		
		User user=new User();
		
		user.setName("qju");
		user.setPwd("321");
		
		ModelAndView loginedView=controller.login(user.getName(), user.getPwd());
		
		user=(User) loginedView.getModel().get("user");
		
		System.out.println(user);
		
		
		
	}
}
