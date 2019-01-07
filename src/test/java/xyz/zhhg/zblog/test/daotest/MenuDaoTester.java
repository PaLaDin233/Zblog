package xyz.zhhg.zblog.test.daotest;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import xyz.zhhg.zblog.test.BaseSpingTester;
import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.web.dao.MenuDao;
import xyz.zhhg.zblog.web.pojo.Menu;

public class MenuDaoTester extends BaseSpingTester{
	MenuDao menuDao=(MenuDao) context.getBean("menuDao");
	
	@Before
	public void p(){
		System.out.println("————————————————————————");
	}
	
	@Test
	public void getMenuList(){
		Menu javaBean=new Menu();
		
		javaBean.setId(new BigInteger("0"));
		javaBean.setUsertype(1);
		
		Map<String,Object> map=BeanUtils.java2Map(javaBean);
		
		
		List<Menu> menus=menuDao.getMenuList(map);
		System.out.println("map"+map);
		System.out.println(menus);
		for (Menu menu : menus) {
			System.out.println(menu);
			System.out.println(menu.getChildList());
		}
		
	}
	
	
	
}
