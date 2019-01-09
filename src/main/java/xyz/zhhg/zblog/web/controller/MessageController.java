package xyz.zhhg.zblog.web.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.pojo.Message;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.MessageService;

@Controller
public class MessageController extends BaseController{
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/putMessage")
	public ModelAndView putMessage(Message message,HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		ModelAndView view=new ModelAndView();
		if(user==null){
			view.addObject("msg", "请先登陆");
			view.setViewName(getView(Views.Error_MESSAGE));
			view.addObject("jumpadd", Views.LOGIN);
		}
		try {
			messageService.insert(message, user);
			view.addObject("msg", "成功");
			view.setViewName("");
		} catch (InsertException e) {
			view.addObject("msg", "留言失败");
			view.setViewName(getView(Views.Error_MESSAGE));
			view.addObject("jumpadd", Views.HOME);
		}
		
		return view;
	}
	
	@RequestMapping("/messageboard/mid{mid}/page{pid}")
	public ModelAndView messageBoard(@PathVariable BigInteger uid,@PathVariable int pid){
		Paging page=wrapPage(pid);
		ModelAndView view=new ModelAndView();
		try {
			messageService.search(uid, page);
			view.addObject("page",page);
			view.setViewName(getView(Views.MESSAGE_BOARD));
		} catch (SearchException e) {
			view.addObject("msg", "查找失败");
			view.setViewName(getView(Views.Error_MESSAGE));
			view.addObject("jumpadd", Views.HOME);
		}
		
		return view;
	}
}
