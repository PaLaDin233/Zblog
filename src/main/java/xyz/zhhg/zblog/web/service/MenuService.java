package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.web.pojo.Menu;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.baseinterface.Deleteable;
import xyz.zhhg.zblog.web.service.baseinterface.Insertable;
import xyz.zhhg.zblog.web.service.baseinterface.Searchable;
import xyz.zhhg.zblog.web.service.baseinterface.Updateable;

@Service
public interface MenuService extends Insertable<Menu>,Deleteable<Menu>,Updateable<Menu>,Searchable<Menu>{
	public Menu getMenuById(BigInteger id);
	public List<Menu>getMenuListBySuperiorId(BigInteger superiorId) throws SearchException;
	public boolean addMenuList(List<Menu> menuList);
	public boolean delMenuList(List<Menu> menuList);
	public boolean updateMenu(List<Menu> menuList);
	
	/**
	 * 获取用户的菜单列表
	 * @param user
	 * @return
	 * @throws SearchException 
	 */
	public List<Menu> getUserMenuList(User user) throws SearchException;
}
