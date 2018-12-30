package xyz.zhhg.zblog.web.service.baseinterface;

import java.util.List;
import java.util.Map;

import xyz.zhhg.zblog.lang.exception.SearchException;

public interface Searchable<T> {
	/**
	 * 
	 * @param t 查询的返回结果
	 * @return
	 */
	List<T> search(Map<String,Object> conditionMap)throws SearchException;
}
