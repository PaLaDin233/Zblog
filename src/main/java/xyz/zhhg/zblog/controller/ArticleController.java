package xyz.zhhg.zblog.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.pojo.Article;
import xyz.zhhg.zblog.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("saveArticle")
	public ModelAndView saveArticle(Article article){
		ModelAndView view=new ModelAndView("#");
		
		if(articleService.saveArticle(article)){
			view.addObject("msg", "添加成功");
		}else{
			view.addObject("msg", "添加失败");
		}
		
		
		return view;
	}
	
	@RequestMapping("loadArticle")
	public ModelAndView loadArticle(BigInteger articleId){
		ModelAndView view=new ModelAndView();
		Article article=articleService.loadArticle(articleId);
		if(article!=null){
			view.addObject("article", article);
			view.setViewName("test/test.jsp");
		}
		else{
			view.setViewName("404.html");
		}
		return view;
	}
}
