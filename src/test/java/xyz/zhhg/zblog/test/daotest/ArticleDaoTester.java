package xyz.zhhg.zblog.test.daotest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.web.dao.ArticleDao;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.service.ArticleService;

public class ArticleDaoTester {
	
	private ArticleDao articleDao;
	
	@Before
	public void init(){
		articleDao=(ArticleDao)new ClassPathXmlApplicationContext("spring-context.xml").getBean(ArticleDao.class);
	}
	
	
	@Test
	public void TestDelList(){
		List<BigInteger> idList=new ArrayList<BigInteger>();

		articleDao.deleteArticleByIdList(null,new BigInteger("3"));
	}
	
	@Test
	public void TestLastId(){
		insert();
		System.out.println(articleDao.findLastIns());
		
	}
	@Test
	public void insert(){
		articleDao.insertArticle(new Article());
	}
	
	@Test 
	public void findArticle(){
		ArticleSearchForm javaBean=new ArticleSearchForm();	
		//javaBean.setCommentNumOrder(true);
		javaBean.setViewsNumOrder(true);
		//javaBean.setLikesNumOrder(false);
		//javaBean.setUserId(new BigInteger("3"));
		javaBean.setTitle("%标题%");
		//Calendar calendar=Calendar.getInstance();
		//calendar.set(2018, 0, 27);
		//Date selectDate=calendar.getTime();
		
		//javaBean.setCreateTime(selectDate);
		Map<String,Object> map=BeanUtils.java2Map(javaBean);
		map.put("firstIndex", 1);
		map.put("pageSize", 100);
		
		
		//System.out.println(map);
		List<Article> list=articleDao.findArticle(map);
		
		for (Article article : list) {
			System.out.println(article);
		}
	}
	
	@Test
	public void selectCountArticle(){
		ArticleSearchForm javaBean=new ArticleSearchForm();	
		javaBean.setTitle("%标题%");
		Map<String,Object> map=BeanUtils.java2Map(javaBean);
		System.out.println(articleDao.selectCountArticle(map));
	}
	
	@Test
	public void getPigeonholeDate(){
		List<Date> ds=articleDao.getPigeonholeDate("%Y%m%d");
		for (Date date : ds) {
			System.out.println(date);
		}
	}
	
	@Test
	public void update(){
		Article article=new Article();
		article=articleDao.getArticleDetailsByArticleId(new BigInteger("18"));
		article.setTitle("新的标题");
		articleDao.updateArticle(article);
		article=articleDao.getArticleDetailsByArticleId(new BigInteger("18"));
		System.out.println(article);
		
	}
	
}
