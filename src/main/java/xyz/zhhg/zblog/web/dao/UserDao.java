package xyz.zhhg.zblog.web.dao;

import xyz.zhhg.zblog.web.pojo.User;

public interface UserDao {
	public User findUserByNameAndPwd(String name,String pwd);
	public User findUserByName(String name);
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	//public List<User> findUserByUser(User t);
}
