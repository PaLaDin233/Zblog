package xyz.zhhg.zblog.test.servicetester;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.web.dao.CommentDao;
import xyz.zhhg.zblog.web.pojo.Comment;
import xyz.zhhg.zblog.web.service.CommentService;

public class CommentServiceTester {

	CommentService commentService;
	
	@Before
	public void init(){
		commentService=(CommentService)new ClassPathXmlApplicationContext("spring-context.xml").getBean(CommentService.class);
	}
	
	@Test
	public void discuss(){
		BigInteger aid=new BigInteger("19");
		Comment comment=new Comment();
		comment.setDetails("测试评论");
//		comment.setAncestor(new BigInteger("0"));
		comment.setSuperior(new BigInteger("0"));
		try {
			commentService.discuss(comment, aid);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void reply(){
		Comment comment=new Comment();
		comment.setDetails("测试评论");
//		comment.setAncestor(new BigInteger("15"));
		comment.setSuperior(new BigInteger("15"));
		try {
			commentService.reply(comment);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
