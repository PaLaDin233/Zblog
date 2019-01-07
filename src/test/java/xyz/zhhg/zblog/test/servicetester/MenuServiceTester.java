package xyz.zhhg.zblog.test.servicetester;

import java.util.List;

import org.junit.Test;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.test.BaseSpingTester;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.MenuService;

public class MenuServiceTester extends BaseSpingTester{
	MenuService service=(MenuService) context.getBean("menuServiceImpl");
	
	@Test
	public void getMenuList() throws SearchException{
		User user=new User();
		user.setType(0);
		List list=service.getUserMenuList(user);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
}
