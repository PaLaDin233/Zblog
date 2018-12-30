package xyz.zhhg.zblog.web.service.baseinterface;

import xyz.zhhg.zblog.lang.exception.userexception.loginexception.LoginException;

public interface Loginable<T> extends Searchable<T>{
	void login(T t) throws LoginException;
}
