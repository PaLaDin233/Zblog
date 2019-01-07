package xyz.zhhg.zblog.web.dao;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Param;

import xyz.zhhg.zblog.web.pojo.User;

public interface UserDao {
	public User findUserByNameAndPwd(String name,String pwd);
	public User findUserByName(String name);
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public User getUserInfoById(@Param("id")BigInteger id);
	//public List<User> findUserByUser(User t);
}
