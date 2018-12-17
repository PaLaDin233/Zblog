package xyz.zhhg.zblog.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.zblog.dao.ArticleDao;
import xyz.zhhg.zblog.pojo.Article;
import xyz.zhhg.zblog.service.ArticleService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	ArticleDao articleDao;

	@Override
	public synchronized boolean saveArticle(Article article){
		// TODO Auto-generated method stub
		try {
			if(!articleDao.saveArticle(article)){
				throw new Exception("保存异常");
			}
			article.setId(articleDao.findLastIns());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	@Override
	public Article loadArticle(BigInteger articleId) {
		List<Article> list=articleDao.findArticle(new Article(articleId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null; 
		
	}
	
	
	
}
