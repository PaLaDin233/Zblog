package xyz.zhhg.zblog.test.controller;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import xyz.zhhg.zblog.controller.ArticleController;
import xyz.zhhg.zblog.pojo.Article;

public class ArticleControllerTester {

	public static ArticleController controller; 
	
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
		
		ModelAndView andView=controller.saveArticle(article);
		//System.out.println(andView.getModel().get("msg"));
		assertEquals(andView.getModel().get("msg"),"添加失败");
	}
	
	@Test
	public void loadArticleTest(){
		Article article=new Article();
		article.setId(new BigInteger("1"));
		ModelAndView andView=controller.loadArticle(article.getId());
	}
	
	@AfterClass
	public static void after(){
		
	}
}
