package xyz.zhhg.zblog.dao;

import java.util.List;

import xyz.zhhg.zblog.pojo.User;

public interface UserDao {
	public User findUserByNameAndPwd(String name,String pwd);
	public User findUserByName(String name);
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public List<User> selectUserByUserName(String name);
	public List<User> findUserByUser(User t);
}
