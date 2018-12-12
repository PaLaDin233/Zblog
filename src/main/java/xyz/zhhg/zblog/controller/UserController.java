package xyz.zhhg.zblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.pojo.User;
import xyz.zhhg.zblog.service.UserService;
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(String name,String password){
		ModelAndView loginedView=new ModelAndView("404.html");
		try{
			User user=userService.login(name, password);
			if(user==null){
				System.out.println("登陆失败");
			}else{
				loginedView.setViewName("homepage.jsp");
				loginedView.addObject("user", user);
				System.out.println("登陆成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("登陆失败");
		}
		return loginedView;
	}
	
	public ModelAndView register(User user){
		ModelAndView modelAndView =new ModelAndView("404.html");
		boolean success=userService.regist(user);
		if(success){
			//TODO 注册成功
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
		
	}

}
