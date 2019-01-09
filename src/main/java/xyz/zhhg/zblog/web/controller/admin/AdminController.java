package xyz.zhhg.zblog.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.controller.BaseController;
import xyz.zhhg.zblog.web.pojo.Menu;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.MenuService;

@Controller
public class AdminController extends BaseController{

	@Autowired
	MenuService menuService;
	
	@RequestMapping("/admin")
	public ModelAndView goAdminView(HttpServletRequest request){
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			view.addObject("msg", "请先登陆");
			view.addObject("jumpadd",Views.LOGIN);
			return view;
		}
		if(user.getType()==1){
			view.setViewName(getView(Views.ADMIN));
			return view;
		}
		
		view.addObject("msg", "sorry，没有权限真的不可以为所欲为~");
		view.addObject("jumpadd", Views.HOME);
		return view;
	}
	@RequestMapping("/admin/funcManager")
	public ModelAndView funcManger(){
		ModelAndView view=new ModelAndView(getView(Views.MENUMANAGER));
		return view;
	}
	
	@RequestMapping("/insertMenu")
	public ModelAndView addMenu(Menu menu) throws InsertException{
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		try{
			menuService.insert(menu);
			view.addObject("msg", "成功");
		}
		catch(Exception e){
			view.addObject("msg",e.getMessage());
		}
		return view;
	}

}
