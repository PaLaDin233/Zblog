package xyz.zhhg.zblog.web.dao;

import java.util.List;
import java.util.Map;

import xyz.zhhg.zblog.web.pojo.Menu;

public interface MenuDao {
	
	public List<Menu> getMenuList(Map<String,Object> map);
	
	public void insertMenu(Menu menu);
	
}
