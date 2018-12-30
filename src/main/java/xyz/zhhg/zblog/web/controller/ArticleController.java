package xyz.zhhg.zblog.web.controller;

import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.service.ArticleService;

@Controller
public class ArticleController extends BaseController{
	
	@Autowired
	ArticleService articleService;
	
	
	@RequestMapping(value="/saveArticle",method=RequestMethod.GET)
	public String saveArticle(){
		return getView(Views.ARTICLE_EDIT);
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveArticle" ,method=RequestMethod.POST)
	public String saveArticle(HttpServletRequest request,Article article){
		//获取当前用户
		User user=null;
		if(null!=request){			
			try{
				user=(User) request.getSession().getAttribute("user");
			}catch(Exception e){
				request.setAttribute("msg", "会话已过期，请重新登陆!");
				request.setAttribute("jumpadd", Views.LOGIN);
			}
		}
		if(null==user){//当用户未登录时返回提示页面,之后跳转到登陆页面
			request.setAttribute("msg", "用户未登录!");
			request.setAttribute("jumpadd", Views.LOGIN);
			
		}else{
			try {
				articleService.saveArticle(user,article);
				request.setAttribute("msg", "保存成功");
				String jumpadd="/getArticle/aid"+article.getId();
				request.setAttribute("jumpadd", jumpadd);
			} catch (Exception e) {
				request.setAttribute("msg",e.getMessage());
				String jumpadd=request.getRequestURI();
				request.setAttribute("jumpadd", jumpadd);
			}
		}
		return getView(Views.MESSAGE);
		
		
	}
	
/*	@RequestMapping("/loadArticle")
	public ModelAndView loadArticle(BigInteger articleId){
		ModelAndView view=new ModelAndView();
		Article article;
		try {
			article = articleService.loadArticle(articleId);
		}catch(SearchException e){
			view.addObject("msg", e.getMessage());
		}
		return view;
	}*/
/*	@RequestMapping("/getUsersArticle/{uid}")
	public ModelAndView getAllArticle(@PathVariable(value="uid") String uid){
		System.out.println("uid:"+uid);
		return getAllArticle(uid,0);
	}*/
	
	/**
	 * 根据用户id，分页查找文章
	 * @param uid
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getUsersArticleList/{uid}/page{pn}")
	public ModelAndView getAllArticle(@PathVariable(value="uid") String uid
			,@PathVariable(value="pn") int pn,HttpServletRequest request){	
		ArticleSearchForm form=new ArticleSearchForm();
		form.setUserId(new BigInteger(uid));
		return findArticleByConditionMap(pn, form,request);
	}
	

	@RequestMapping(value="/getUsersArticleList/page{pn}")
	public ModelAndView getAllArticle(@PathVariable(value="pn") int pn,HttpServletRequest request){
		return getAllArticle("0", pn,request);
	}
	
	/**
	 * 查询指定编号的文章详细信息
	 * @param aid 文章的编号
	 * @return 查询后的跳转页面，
	 * @查询到时 在返回页面添加article键值对，返回页面为{@code Views.ARTICLE_DETAILS}}
	 * @未查询到时 返回页面添加msg信息,返回页面为{@code Views.Error_MESSAGE},设置返回之后跳转页面为request来源uri
	 */
	@RequestMapping(value="/getArticle/aid{aid}")
	public ModelAndView getArticle(@PathVariable(value="aid") String aid,HttpServletRequest request){
		Article article=null;
		ModelAndView view=new ModelAndView();
		try{
			article =articleService.loadArticle(new BigInteger(aid));
			view.addObject("article", article);
			view.setViewName(getView(Views.ARTICLE_DETAILS));
		}catch(SearchException e){
			view.addObject("msg", e.getMessage());
			if(null!=request)view.addObject("jumpadd", request.getRequestURI());
			view.setViewName(getView(Views.Error_MESSAGE));
		}
		
		return view;
	}
	
	@RequestMapping(value="/findArticles/page{pn}",method=RequestMethod.POST)
	public ModelAndView findArticleByConditionMap(@PathVariable(value="pn") int pn ,ArticleSearchForm form,HttpServletRequest request){
		Paging page = wrapPage(new Integer(pn));
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		try{
			articleService.search(form,page);
			view.addObject("page", page);
			view.setViewName(getView(Views.ARTICLES));
		}
		catch(SearchException e){
			view.addObject("msg", e.getMessage());
			//设置回跳地址
			if(request!=null)
			view.addObject("jumpadd",request.getRequestURI());
		}
		return view;
		
	}
	
}
