package xyz.zhhg.zblog.test;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import xyz.zhhg.zblog.web.pojo.Article;

public class DateTester {
	public static void main(String[] args) {
		Article javaBean=new Article();	
		//javaBean.setCommentNum(1);
		javaBean.setUserId(new BigInteger("3"));
		Calendar calendar=Calendar.getInstance();
		calendar.set(2018, 12, 27);
		Date selectDate=calendar.getTime();
		
		javaBean.setCreateTime(selectDate);
		
		System.out.println(javaBean.getCreateTime());
	}
}
