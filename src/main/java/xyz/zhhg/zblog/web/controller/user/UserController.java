package xyz.zhhg.zblog.web.controller.user;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.session.HttpServletSession;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.userexception.registexception.UserExistException;
import xyz.zhhg.zblog.utils.graph.GraphUtils;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.controller.BaseController;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.UserService;
@Controller
public class UserController extends BaseController{

	@Autowired
	UserService userService;
	
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
		} catch (Exception e) {
			loginedView.addObject("msg",e.getMessage());
			loginedView.setViewName(getView(Views.LOGIN));
		}		
		return loginedView;
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request){
		try{
			request.getSession().removeAttribute("user");
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
	@RequestMapping(value={"/home","/user/home"} , method=RequestMethod.GET)
	public String home(){
		return "";
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
}
