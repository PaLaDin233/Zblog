package xyz.zhhg.zblog.web.service.baseinterface;

import java.util.List;

import xyz.zhhg.zblog.lang.exception.DeleteException;

public interface Deleteable<T> {
	void delete(List<T> t)throws DeleteException;
}
