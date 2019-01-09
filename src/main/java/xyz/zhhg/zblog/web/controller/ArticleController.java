package xyz.zhhg.zblog.web.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.Classcify;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.pojo.form.DeleteArticleForm;
import xyz.zhhg.zblog.web.service.ArticleService;
import xyz.zhhg.zblog.web.service.ClasscifyService;

@Controller
public class ArticleController extends BaseController{

	@Autowired
	ArticleService articleService;

	@Autowired
	ClasscifyService classcifyService;


	@RequestMapping(value="/saveArticle",method=RequestMethod.GET)
	public ModelAndView saveArticle(HttpServletRequest request){
		ModelAndView view=new ModelAndView(getView(Views.ARTICLE_EDIT));
		User user=(User) request.getSession().getAttribute("user");
		
		if(user==null){
			view.addObject("msg", "请登陆!");
			view.addObject("jumpadd", Views.LOGIN);
		}else{
			List<Classcify> classcifies=classcifyService.getClasscify(user);
			view.addObject("classcifies",classcifies);
		}
		return view;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/editArticle" ,method=RequestMethod.POST)
	public String saveArticle(HttpServletRequest request,Article article){
		System.out.println(article);
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
	
	@RequestMapping(value="/editArticle{aid}",method=RequestMethod.GET)
	public ModelAndView editArticle(@PathVariable(value="aid") String aid,HttpServletRequest request){
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		User user=null;
		user=(User) request.getSession().getAttribute("user");
		if(user==null){
			view.addObject("msg", "请先登陆");
			view.addObject("jumpadd", Views.LOGIN);
			return view;
		}
		
		Article article=null;
		try {
			article =articleService.loadArticle(new BigInteger(aid));	
			view.addObject("article", article);
			view.setViewName(getView(Views.ARTICLE_EDIT));
		} catch (SearchException e) {
			view.addObject("msg", e.getMessage());
			e.printStackTrace();
		}
		return view;
	}
	@RequestMapping(value="/editArticle{aid}",method=RequestMethod.POST)
	public ModelAndView editArticle(@PathVariable(value="aid") String aid,Article article,HttpServletRequest request){
		System.out.println(article);
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		User user=null;
		user=(User) request.getSession().getAttribute("user");
		if(user==null){
			view.addObject("msg", "请先登陆");
			view.addObject("jumpadd", Views.LOGIN);
			return view;
		}
		
		try {
			article.setId(new BigInteger(aid));
			articleService.saveArticle(user, article);
			view.setViewName(redirectView("/getArticle/aid"+aid));
		} catch (Exception e) {
			view.addObject("msg", e.getMessage());
			view.addObject("jumpadd", Views.HOME);
			e.printStackTrace();
		} 
		
		
		
		return view;
		
		
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
			,@PathVariable(value="pn") int pn){	
		ArticleSearchForm form=new ArticleSearchForm();
		form.setUserId(new BigInteger(uid));
		return findArticles(pn, form);
	}
	
	
	@RequestMapping("/myArticle/page{pn}")
	public ModelAndView myArticle(@PathVariable(value="pn")int pn,HttpServletRequest request){
		ModelAndView view;
		User user=getUser(request);
		
		ArticleSearchForm form=new ArticleSearchForm();
		
		if(user!=null){
			form.setUserId(user.getId());
			view=findArticles(pn, form);
			view.setViewName(getView(Views.USERS_ARTICLE));
		}
		else{
			return new ModelAndView(Views.LOGIN);
		}
		
		return view;
	}


	@RequestMapping(value="/getUsersArticleList/page{pn}")
	public ModelAndView getAllArticle(@PathVariable(value="pn") int pn){
		return getAllArticle("0", pn);
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
	
	/**
	 * 对页面传来date类型的字符串进行绑定
	 * @param bin
	 */
	@InitBinder 
	public void initBinder(ServletRequestDataBinder bin) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor cust = new CustomDateEditor(sdf, true);
		bin.registerCustomEditor(Date.class, cust);
	}

	@RequestMapping(value="/findArticles/page{pn}")
	public ModelAndView findArticles(@PathVariable(value="pn") int pn ,ArticleSearchForm form){
		Paging page = wrapPage(new Integer(pn));
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		try{
			articleService.search(form,page);
			view.addObject("page", page);
			view.addObject("searchFrom", form);
			view.setViewName(getView(Views.ARTICLES));
		}
		catch(SearchException e){
			view.addObject("msg", e.getMessage());
			//设置回跳地址
			view.addObject("jumpadd","/getUsersArticleList/page1");
		}
		return view;

	}
	
	
	public void getPigeonholeDate(HttpServletRequest request){
		ServletContext context= request.getServletContext();
		context.setAttribute("", articleService.getPigeonholeDate());
		
	}
	
	@RequestMapping("/deleteArticle")
	public ModelAndView deleteArticle(HttpServletRequest request,DeleteArticleForm idList){
		User user=getUser(request);
		ModelAndView view=new ModelAndView(getView(Views.Error_MESSAGE));
		if(user==null){
			view.addObject("msg", "请先登陆");
			view.addObject("jumpadd",Views.LOGIN);
		}else{
			articleService.deleteArticles(idList.getIdList(),user);
			view.addObject("msg", "删除成功");
			view.addObject("jumpadd", "/myArticle/page0");
		}
		
		return view;
	}
	

}
