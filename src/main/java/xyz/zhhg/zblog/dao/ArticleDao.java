package xyz.zhhg.zblog.dao;

import java.math.BigInteger;
import java.util.List;

import xyz.zhhg.zblog.pojo.Article;

public interface ArticleDao {
	public boolean saveArticle(Article article);
	
	public BigInteger findLastIns();

	public List<Article> findArticle(Article article);
}
