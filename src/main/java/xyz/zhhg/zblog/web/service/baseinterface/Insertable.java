package xyz.zhhg.zblog.web.service.baseinterface;

import xyz.zhhg.zblog.lang.exception.InsertException;

public interface Insertable<T> {
	void insert(T t) throws InsertException;
	
}
