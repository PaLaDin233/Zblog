package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.web.pojo.Comment;
import xyz.zhhg.zblog.web.service.baseinterface.Deleteable;
import xyz.zhhg.zblog.web.service.baseinterface.Insertable;

@Service
public interface CommentService extends 
	Insertable<Comment>,Deleteable<Comment>{
	
	/**
	 * 对指定文章进行评论
	 * @throws InsertException 
	 */
	void discuss(Comment comment, BigInteger aid) throws InsertException;
	
	/**
	 * 对评论进行回复
	 * @throws InsertException 
	 */
	public void reply(Comment comment) throws InsertException;


	
}
