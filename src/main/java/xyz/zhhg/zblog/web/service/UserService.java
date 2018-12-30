package xyz.zhhg.zblog.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.userexception.loginexception.LoginException;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.baseinterface.Deleteable;
import xyz.zhhg.zblog.web.service.baseinterface.Loginable;
import xyz.zhhg.zblog.web.service.baseinterface.Insertable;
import xyz.zhhg.zblog.web.service.baseinterface.Searchable;
import xyz.zhhg.zblog.web.service.baseinterface.Updateable;

@Service
public interface UserService extends Loginable<User>,Insertable<User>,Deleteable<User>,Updateable<User>,Searchable<User>{
	/**
	 * 
	 * @param name 
	 * @param pwd
	 * @param isRem 是否记住密码
	 * @throws Exception 登陆异常
	 */
	public abstract void login(String name, String pwd, boolean isRem) throws Exception;

	public abstract List<String> getPermissionByUserName(String username);

	public abstract String getPasswordByUserName(String username);

	/**
	 * 
	 * @param username
	 * @param password
	 * @param session 登陆成功之后将用户信息放入的session
	 * @throws Exception 登陆异常
	 */
	public abstract void login(String username, String password, HttpSession session) throws Exception;

	void login(User user, HttpSession session) throws LoginException;

	void login(String name, String pwd) throws Exception;
	
}
