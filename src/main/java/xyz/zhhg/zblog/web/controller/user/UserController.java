package xyz.zhhg.zblog.web.controller.user;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.lang.exception.UpdateException;
import xyz.zhhg.zblog.lang.exception.userexception.loginexception.LoginException;
import xyz.zhhg.zblog.utils.graph.GraphUtils;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.controller.BaseController;
import xyz.zhhg.zblog.web.pojo.Menu;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.service.ArticleService;
import xyz.zhhg.zblog.web.service.MenuService;
import xyz.zhhg.zblog.web.service.UserService;
@Controller
public class UserController extends BaseController{

	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(){
		return getView(Views.LOGIN);
	}
	
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView login(String name,String pwd,HttpServletRequest request){
		ModelAndView loginedView=new ModelAndView();
		try {
			HttpSession session=null;
			if(request!=null)session=request.getSession();
			userService.login(name, pwd,session);
			loginedView.setViewName(redirectView(Views.HOME));
			List<Menu> menus=menuService.getUserMenuList((User)session.getAttribute("user"));
			session.setAttribute("menus", menus);
		} catch (LoginException e) {
			loginedView.addObject("msg",e.getMessage());
			loginedView.setViewName(getView(Views.LOGIN));
		} catch (SearchException e) {
		}		
		return loginedView;
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request){
		try{
			request.getSession().invalidate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView(redirectView(""));
	}
	
	
	@RequestMapping(value="/reg" , method=RequestMethod.GET)
	public String register(){

		return getView(Views.REG);
	}
	
	@RequestMapping(value="/reg" , method=RequestMethod.POST)
	public ModelAndView register(User user,HttpServletRequest request){
		ModelAndView modelAndView =new ModelAndView(getView(Views.REG_RESULT));
		userInit(user, request);
		try {
			userService.insert(user);
			modelAndView.addObject("msg", "注册成功");
			modelAndView.addObject("jumpadd", Views.LOGIN);
		} catch (InsertException e) {
			modelAndView.addObject("msg", e.getMessage());
			modelAndView.addObject("jumpadd", Views.REG);
		}
		return modelAndView;
		
	}
	
	private void userInit(User user,HttpServletRequest request){
		try {
			user.setIp(getIpAddr(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value={"/home","/user/home","*"} , method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request){
		ModelAndView view=new ModelAndView("/index.jsp");
		request.getSession().setAttribute("pigeonholeDates", articleService.getPigeonholeDate());
		
		Paging page=wrapPage(1);
		User user=(User) request.getSession().getAttribute("user");
		BigInteger uid=user==null?null:user.getId();
		try {
			ArticleSearchForm form=new ArticleSearchForm();
			form.setCommentNumOrder(true);
			form.setUserId(uid);
			articleService.search(form, page);
			
			view.addObject("page", page);
		} catch (SearchException e) {
			//TODO 日志 
			e.printStackTrace();
		}
		return view;
	}
	
	@RequestMapping("/getVerity")
	public void getVerity(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/*Random random=new Random();
		int verity =random.nextInt();
		response.setCharacterEncoding("UTF-8");
		request.getSession().setAttribute("verity", verity);
		
		response.getWriter().write(String.valueOf(verity));*/
		response.setContentType("image/jpeg");
		ImageIO.write(GraphUtils.getExpressionGraph(1, 2, '+'), "a", response.getOutputStream());

		
	}
	
	@RequestMapping(value="/userCenter",method=RequestMethod.GET)
	public ModelAndView userinfo(HttpServletRequest request){
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			view.addObject("msg", "请先登陆");
			view.addObject("jumpadd", Views.LOGIN);
			return view;
		}
		
		view.setViewName(getView(Views.ACCOUNT_PROFILE));
		return view;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView updateUser(User user,String newPwd,HttpServletRequest request){
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		HttpSession session=request.getSession();
		User old=(User) session.getAttribute("user");
		if(old==null){
			view.addObject("msg","请先登陆");
			view.addObject("jumpadd",Views.LOGIN);
			return view;
		}
		user.setId(old.getId());
		user.setName(old.getName());
		try {
			userService.update(user, newPwd);
			if(newPwd!=null){
				view.addObject("msg","更新成功请重新登陆");
				session.removeAttribute("user");
				view.addObject("jumpadd","/login");
			}else {
				view.addObject("msg","更新成功");
				session.setAttribute("user", userService.getUserInfoById(old.getId()));
				view.addObject("jumpadd","/userCenter");
			}
		} catch (UpdateException e) {
			view.addObject("msg",e.getMessage());
			view.addObject("jumpadd","/userCenter");
		}
		
		return view;
	}
}
