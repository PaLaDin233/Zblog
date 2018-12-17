package xyz.zhhg.zblog.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.pojo.Article;

@Service
public interface ArticleService {
	public boolean saveArticle(Article article);

	public Article loadArticle(BigInteger articleId);
}
