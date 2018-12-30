package xyz.zhhg.zblog.test.daotest;

import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhhg.zblog.web.dao.CommentDao;
import xyz.zhhg.zblog.web.pojo.Comment;

public class CommentDaoTester {

	private CommentDao commentDao;
	
	@Before
	public void init(){
		commentDao=(CommentDao)new ClassPathXmlApplicationContext("spring-context.xml").getBean(CommentDao.class);
	}
	
	
	
	@Test
	public void insertComment(){
		Comment comment=new Comment();
		comment.setSuperior(new BigInteger("0"));
		comment.setDetails("这是一条测试评论");
		comment.setUid(new BigInteger("3"));
		commentDao.insertComment(comment);
		
	}
	
	@Test
	public void insertArticleComment(){
		commentDao.insertArticleComment(new BigInteger("9"), new BigInteger("9"));
	}
	
	/**
	 * 获取指定评论的评论列表
	 * @param cid 指定评论的id
	 * @return
	 */
	@Test
	public void selectComment(){
		List list=commentDao.selectArticleComment(new BigInteger("19"));
		System.out.println(list);
		
	}
	
	
//	public void deleteComment(List<Comment> comments);
//	/**
//	 * 获取指定文章的评论列表
//	 * @return
//	 */
//	public List<Comment> selectArticleComment(BigInteger aid);
}
