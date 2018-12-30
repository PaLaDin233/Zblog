package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.SearchException;
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

	public void saveArticle(User user, Article article)throws Exception;

	
	public void search(ArticleSearchForm form, Paging page)throws SearchException;

}
