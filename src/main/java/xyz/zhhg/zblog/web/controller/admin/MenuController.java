package xyz.zhhg.zblog.web.controller.admin;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.web.pojo.Menu;
import xyz.zhhg.zblog.web.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@RequestMapping("/getMenuList")
	public ModelAndView getMenuList(BigInteger superiorId){
		ModelAndView view=new ModelAndView();
		List<Menu> list;
		try {
			list = menuService.getMenuListBySuperiorId(superiorId);
			view.addObject("menuList", list);
			view.setViewName("");
		} catch (SearchException e) {
			view.addObject("msg", e.getMessage());
			e.printStackTrace();
		}
		
		return view;
	}
}
