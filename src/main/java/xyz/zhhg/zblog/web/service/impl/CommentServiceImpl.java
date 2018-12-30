package xyz.zhhg.zblog.web.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.zblog.lang.exception.DeleteException;
import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.web.dao.ArticleDao;
import xyz.zhhg.zblog.web.dao.CommentDao;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.Comment;
import xyz.zhhg.zblog.web.service.CommentService;

@Transactional(rollbackFor=Exception.class)
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public void insert(Comment comment) throws InsertException {
		commentDao.insertComment(comment);
	}

	@Override
	public void delete(List<Comment> comments) throws DeleteException {
		commentDao.deleteComment(comments);
	}
	

	@Override
	
	public void discuss(Comment comment, BigInteger aid) throws InsertException {
		//设置评论为文章的root评论
		//comment.setAncestor(new BigInteger("0"));
		comment.setSuperior(new BigInteger("0"));
		//插入评论到评论表
		insert(comment);
		
		//获取插入评论的id
		BigInteger cid=commentDao.findLastIns();
		//设置评论的id
		comment.setId(cid);
		//将评论插入文章评论表
		commentDao.insertArticleComment(aid, cid);
		
	}

	

	@Override
	public void reply(Comment comment) throws InsertException {
		insert(comment);
	}


	
}
