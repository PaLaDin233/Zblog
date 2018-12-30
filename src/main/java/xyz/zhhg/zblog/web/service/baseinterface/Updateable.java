package xyz.zhhg.zblog.web.service.baseinterface;

import xyz.zhhg.zblog.lang.exception.UpdateException;

public interface Updateable<T> {
	void update(T t)throws UpdateException;
}
