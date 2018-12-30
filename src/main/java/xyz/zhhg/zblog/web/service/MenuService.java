package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.web.pojo.Menu;

@Service
public interface MenuService {
	public Menu getMenuById(BigInteger id);
	public List<Menu>getMenuListBySuperiorId(BigInteger superiorId);
	public boolean addMenuList(List<Menu> menuList);
	public boolean delMenuList(List<Menu> menuList);
	public boolean updateMenu(List<Menu> menuList);
}
