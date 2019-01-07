package xyz.zhhg.zblog.test.servicetester;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import xyz.zhhg.zblog.lang.exception.UpdateException;
import xyz.zhhg.zblog.test.BaseSpingTester;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.UserService;

public class UserServiceTester extends BaseSpingTester {
	
	
	UserService sevice;
	
	@Before
	public void init(){
		sevice=(UserService) context.getBean("userServiceImpl");
	}
	
	@Test
	public void updateUserTester() throws Exception{
		User user=new User();
		user.setId(new BigInteger("3"));
		user.setName("清居");
		user.setPwd("123456");
		sevice.update(user, "000000");
		sevice.login("清居", "000000");
	}
}
