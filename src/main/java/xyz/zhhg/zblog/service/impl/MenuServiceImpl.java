package xyz.zhhg.zblog.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.dao.MenuDao;
import xyz.zhhg.zblog.pojo.Menu;
import xyz.zhhg.zblog.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao menuDao;

	@Override
	public boolean addMenuList(List<Menu> menuList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delMenuList(List<Menu> menuList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMenu(List<Menu> menuList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Menu getMenuById(BigInteger id) {
		return null;
	}

	@Override
	public List<Menu> getMenuListBySuperiorId(BigInteger superiorId) {
		return menuDao.getMenuBySuperiorId(superiorId);
	}

}