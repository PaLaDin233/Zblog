package xyz.zhhg.zblog.test.controller;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.controller.ArticleController;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;

public class ArticleControllerTester {

	public static ArticleController controller; 
	ModelAndView view;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void before(){
		controller=(ArticleController) new ClassPathXmlApplicationContext("/spring-context.xml").getBean("articleController");
	}
	
	@Test
	public void saveArticleTest(){
		Article article=new Article();
		article.setTitle("第一篇博文");
		article.setUserId(new BigInteger("16"));
		article.setDetails("#1这是博客内容！");
		
		controller.saveArticle(null,article);
		//System.out.println(andView.getModel().get("msg"));
	}
	
	@Test
	public void loadArticleTest(){
		Article article=new Article();
		ModelAndView andView=controller.getArticle("19",null);
		article=(Article) andView.getModelMap().get("article");
		System.out.println(article);
	}
	
	@Test
	public void findUserArticleTest(){
		
		view=controller.getAllArticle("3", 0,null);
		Paging page=(Paging) view.getModel().get("page");
		System.out.println(page.getResults());
	}
	
	@Test
	public void findArticleByForm(){
		ArticleSearchForm articleSearchForm=new ArticleSearchForm();
		//articleSearchForm.setTitle("标题");
		
		view=controller.findArticleByConditionMap(1, articleSearchForm, null);
		Paging page=(Paging) view.getModel().get("page");
		System.out.println(page.getResults());
		
	}
	@AfterClass
	public static void after(){
		
	}
}
