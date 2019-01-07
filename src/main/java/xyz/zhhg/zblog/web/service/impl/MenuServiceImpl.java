package xyz.zhhg.zblog.web.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.DeleteException;
import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.lang.exception.UpdateException;
import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.web.dao.MenuDao;
import xyz.zhhg.zblog.web.pojo.Menu;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao menuDao;

	@Override
	public List<Menu> getUserMenuList(User user) throws SearchException {
		
		Menu javaBean=new Menu();
		javaBean.setSuperiorId(new BigInteger("0"));
		javaBean.setStatus(0);
		javaBean.setUsertype(user.getType());
		Map<String, Object> map=BeanUtils.java2Map(javaBean);
		return search(map);
	}
	
	@Override
	public List<Menu> getMenuListBySuperiorId(BigInteger superiorId) throws SearchException {
		Menu javaBean=new Menu();
		javaBean.setSuperiorId(superiorId);
		Map<String, Object> map=BeanUtils.java2Map(javaBean);
		return search(map);
	}

	@Override
	public List<Menu> search(Map<String, Object> map)
			throws SearchException {
		List<Menu> menus=menuDao.getMenuList(map);
		if(menus==null||menus.size()==0) throw new SearchException("没有菜单");
		return menus;
	}
	
	@Override
	public void insert(Menu menu) throws InsertException {
		menuDao.insertMenu(menu);
		
	}

	@Override
	public void delete(List<Menu> t) throws DeleteException {
		
		
	}

	@Override
	public void update(Menu t) throws UpdateException {
		// TODO Auto-generated method stub
		
	}


	
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




	

}
