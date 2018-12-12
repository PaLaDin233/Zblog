package xyz.zhhg.zblog.service.baseinterface;

public interface Loginable<T> {
	T login(String name,String pwd);
}
