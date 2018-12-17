package xyz.zhhg.zblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.dao.UserDao;
import xyz.zhhg.zblog.pojo.User;
import xyz.zhhg.zblog.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		System.out.println(name+pwd);
		return userDao.findUserByNameAndPwd(name, pwd);
	}

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public List<User> search(User t) {
		// TODO Auto-generated method stub
		return userDao.findUserByUser(t);
	}
	public List<User> searchByName(String name){
		return userDao.selectUserByUserName(name);
	}


}
