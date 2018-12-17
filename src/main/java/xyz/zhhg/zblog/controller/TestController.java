package xyz.zhhg.zblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("hi")
	public String hi(String str){
		System.out.println(str);
		return "../index.jsp";
	}
}
