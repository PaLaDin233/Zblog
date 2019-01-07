package xyz.zhhg.zblog.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.istack.internal.NotNull;

import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.pojo.Comment;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.CommentService;

@Controller
public class CommentController extends BaseController{
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/discuss/{aid}")
	public void discuss(@PathVariable("aid")BigInteger aid,Comment comment,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		User user=null;
		try{
			user=(User) request.getSession().getAttribute("user");			
			comment.setUid(user.getId());
		}
		catch(Exception e){
			
		}
		try{
			commentService.discuss(comment, aid);
			response.getWriter().write("评论成功");
			response.sendRedirect("/Zblog/getArticle/aid"+aid);
		}catch(Exception e){
			response.getWriter().write(e.getMessage());		
		}
	}
}
