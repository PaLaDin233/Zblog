package xyz.zhhg.zblog.web.dao;

import java.math.BigInteger;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;

import xyz.zhhg.zblog.web.pojo.Comment;

public interface CommentDao {
	/**
	 * 添加一条评论
	 * @param comment
	 */
	public void insertComment(Comment comment);
	
	/**
	 * 为指定的文章添加评论
	 * @param aid
	 * @param cid
	 */
	public void insertArticleComment(@Param("aid")BigInteger aid, @Param("cid")BigInteger cid);
	public void deleteComment(List<Comment> comments);
	/**
	 * 获取指定评论的评论列表
	 * @param cid 指定评论的id
	 * @return
	 */
	public List<Comment> selectComment(BigInteger cid);
	/**
	 * 获取指定文章的评论列表
	 * @return
	 */
	public List<Comment> selectArticleComment(BigInteger aid);

	public BigInteger findLastIns();
	
	public BigInteger findAncestor(BigInteger id);
	
}
