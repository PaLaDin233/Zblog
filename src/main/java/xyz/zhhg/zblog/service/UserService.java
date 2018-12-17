package xyz.zhhg.zblog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.pojo.User;
import xyz.zhhg.zblog.service.baseinterface.Loginable;
import xyz.zhhg.zblog.service.baseinterface.Registable;
import xyz.zhhg.zblog.service.baseinterface.Searchable;

@Service
public interface UserService extends Loginable<User>,Registable<User>,Searchable<User>{
	@Override
	public User login(String name, String pwd);
	@Override
	public boolean regist(User t);
	@Override
	public List<User> search(User t);
}
