package xyz.zhhg.zblog.test.controller;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.utils.md5.MD5Util;
import xyz.zhhg.zblog.web.controller.BaseController;
import xyz.zhhg.zblog.web.controller.user.UserController;
import xyz.zhhg.zblog.web.pojo.User;

public class UserTest extends BaseController{
	AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("/spring-context.xml");
	UserController controller=
			(UserController) abstractApplicationContext.getBean
			("userController");
	
	
	@Test
	public void login(){
		User user=new User();	
		user.setName("qju");
		user.setPwd("123456");
		ModelAndView view=controller.login(user.getName(), user.getPwd(),null);
		System.out.println(view.getModel().get("msg"));
		System.out.println(view.getViewName());
		System.out.println(user);
	}
	
	@Test
	public void register(){
		User user=new User();	
		user.setName("admin");
		user.setPwd(MD5Util.md5("123456"));
		ModelAndView modelAndView=controller.register(user,null);
		System.out.println(modelAndView.getModel().get("msg"));
	}
}