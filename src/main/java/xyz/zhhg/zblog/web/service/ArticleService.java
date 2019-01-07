package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.lang.exception.UpdateException;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.service.baseinterface.Searchable;

@Service
public interface ArticleService extends Searchable<Article>{
	
	public void saveArticle(Article article) throws Exception;

	public Article loadArticle(BigInteger articleId)throws SearchException;

	public void findArticleList(BigInteger uid, Paging page) throws SearchException;

	void search(Map<String, Object> map, Paging page) throws SearchException;

	public void saveArticle(User user, Article article)throws UpdateException,InsertException;

	
	public void search(ArticleSearchForm form, Paging page)throws SearchException;
	
	public List<Date> getPigeonholeDate();

	public void deleteArticles(List<BigInteger> idList,User user);
}
