package xyz.zhhg.zblog.service.baseinterface;

import java.util.List;

public interface Searchable<T> {
	List<T> search(T t);
}
