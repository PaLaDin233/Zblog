package xyz.zhhg.zblog.web.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import xyz.zhhg.zblog.web.pojo.Article;

public interface ArticleDao {
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public boolean insertArticle(Article article);
	
	public int deleteArticleByIdList(@Param("idList")List<BigInteger> idList,@Param("uid")BigInteger uid);
	
	public int updateArticle(Article article);
	
	
	public int incViewNum(@Param("aid")BigInteger aid);

	/**
	 * 获取添加的最后一个文章id
	 * @return
	 */
	public BigInteger findLastIns();
	/**
	 * 获取满足条件的所有文章
	 * @param map 封装的条件map
	 * @return
	 */
	public List<Article> findArticle(Map<String, Object> map);
	
	
	public Article getArticleDetailsByArticleId(BigInteger id);
	
	/**
	 * 
	 * @param format 日期的表示参数可以是年%y，月：%m，日：%d;以及他们间的组合
	 * @return 文章表中对应表示参数的日期列表，
	 */
	public List<Date> getPigeonholeDate(String format);
	
	

}
