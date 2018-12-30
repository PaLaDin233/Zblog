package xyz.zhhg.zblog.test.servicetester;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.service.ArticleService;

public class ArticleSeriviceTester {
	ArticleService service;
	Date b;
	
	
	@Before
	public void init(){
		service=(ArticleService)new ClassPathXmlApplicationContext("spring-context.xml").getBean(ArticleService.class);
	}
	
	@Test
	public void Test1() throws SearchException{
		
		
		ArticleSearchForm articleSearchForm=new ArticleSearchForm();
		
		//articleSearchForm.setUserId(new BigInteger("3"));
		//articleSearchForm.setTitle("标题");
		Calendar calendar=new GregorianCalendar();

		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date date=calendar.getTime();
		
		System.out.println(date);
		articleSearchForm.setCreateTime(date);
		
		Map<String, Object> map=BeanUtils.java2Map(articleSearchForm);
		
		Paging page=new Paging(1,10);
		
		long b=System.currentTimeMillis();
		service.search(map, page);
		System.out.println("花费时间:"+(System.currentTimeMillis()-b));
		
		List<Article> list=(List<Article>) page.getResults();
				
		
		for (Article article : list) {
			System.out.println(article);	
		}
		
		
	}
}
