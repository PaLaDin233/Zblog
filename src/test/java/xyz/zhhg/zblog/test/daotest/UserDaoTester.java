package xyz.zhhg.zblog.test.daotest;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import xyz.zhhg.zblog.test.BaseSpingTester;
import xyz.zhhg.zblog.utils.md5.MD5Util;
import xyz.zhhg.zblog.web.dao.UserDao;
import xyz.zhhg.zblog.web.pojo.User;

public class UserDaoTester extends BaseSpingTester{
	
	UserDao userDao;
	
	@Before
	public void init(){
		userDao=(UserDao) context.getBean("userDao");
	}
	
	@Test
	public void updateTester(){
		User user=new User();
		user.setId(new BigInteger("3"));
		user.setName("清居");
		user.setPwd(MD5Util.md5("123456"));
		
		userDao.updateUser(user);
		
		user=userDao.findUserByName("清居");
		System.out.println(user);
	}
	@Test
	public void getUserInfoById(){
		User user=userDao.getUserInfoById(new BigInteger("3"));
		System.out.println(user);
	}
}
