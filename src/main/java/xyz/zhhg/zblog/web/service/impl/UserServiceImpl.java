package xyz.zhhg.zblog.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.DeleteException;
import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.UpdateException;
import xyz.zhhg.zblog.lang.exception.userexception.loginexception.LoginException;
import xyz.zhhg.zblog.lang.exception.userexception.loginexception.UserNoExistException;
import xyz.zhhg.zblog.lang.exception.userexception.registexception.UserExistException;
import xyz.zhhg.zblog.utils.md5.MD5Util;
import xyz.zhhg.zblog.web.dao.PermissionDao;
import xyz.zhhg.zblog.web.dao.UserDao;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PermissionDao permDao;
	
	
	/**
	 * 注册用户
	 * @throws UserExistException 用户已存在
	 */
	@Override
	public void insert(User user) throws InsertException {
		//判断用户是否重复
		if(user==null){
			throw new InsertException("表达提交错误");
		}
		if(StringUtils.isEmpty(user.getName())){
			throw new InsertException("用户名为空！");
		}
		
		if(StringUtils.isEmpty(user.getPwd())){//||MD5Util.md5("").equals(MD5Util.md5(user.getPwd()))
			throw new InsertException("密码为空！");
		}
		if(searchByName(user.getName())!=null){
			throw new UserExistException("用户已存在");
		}
		userDao.insertUser(user);
	}
	

	@Override
	public void delete(List<User> users) throws DeleteException {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void update(User t) throws UpdateException {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<User> search(Map<String,Object> p) {
		return null;
	}
	public User searchByName(String name){
		return userDao.findUserByName(name);
	}
	
	
	@Override
	public void login(String name, String pwd) throws LoginException {
		login(new User(name, pwd),null);
	}
	
	@Deprecated
	@Override
	
	
	public void login(String name, String pwd,boolean isRem) throws Exception {
		/*Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token =
					new UsernamePasswordToken(name, pwd);
			token.setRememberMe(isRem);//是否记住用户
			try {
				currentUser.login(token);//执行登录
			} catch (UnknownAccountException uae) {
				throw new Exception("账户不存在");
			} catch (IncorrectCredentialsException ice) {
				throw new Exception("密码不正确");
			} catch (LockedAccountException lae) {
				throw new Exception("用户被锁定了 ");
			} catch (AuthenticationException ae) {
				ae.printStackTrace();
				throw new Exception("未知错误");
			}
		}*/
	}
	
	@Override
	public void login(User userCheck, HttpSession session) throws LoginException{
		User user=null;
		try {
			user=userDao.findUserByNameAndPwd(userCheck.getName(), userCheck.getPwd());
			if(session!=null){
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			throw new LoginException(e);
		}
		
		if(user==null)throw new LoginException("用户名或密码错误");
		if(user.getStatus()==1)throw new LoginException("用户被锁定了");
		
	}
	
	
	


	/**
	 * 查询用户所有权限
	 */
	@Deprecated
	public List<String> getPermissionByUserName(String username) {
		return permDao.getPermissionByUserName(username);
	}

	@Override
	@Deprecated
	public String getPasswordByUserName(String username) {
		return null;
	}

	@Override
	public void login(User user) throws LoginException {
		login(user.getName(), user.getPwd());
		
	}

	@Override
	public void login(String username, String password, HttpSession session)
			throws Exception {
		login(new User(username, password), session);
		
	}








}
