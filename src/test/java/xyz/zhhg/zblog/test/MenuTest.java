package xyz.zhhg.zblog.test;

import java.math.BigInteger;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.web.controller.admin.MenuController;
import xyz.zhhg.zblog.web.pojo.Menu;

public class MenuTest {
	public static void main(String[] args) {
		AbstractApplicationContext abstractApplicationContext=new ClassPathXmlApplicationContext("/spring-context.xml");

		MenuController controller=(MenuController) abstractApplicationContext.getBean("menuController");
		
		BigInteger id=new BigInteger("0");
		
		ModelAndView view=controller.getMenuList(new BigInteger("0"));
		
		List<Menu> list=(List<Menu>) view.getModel().get("menuList"+id);
		
		for (Menu menu : list) {
			System.out.println(menu);
		}
	}
}
