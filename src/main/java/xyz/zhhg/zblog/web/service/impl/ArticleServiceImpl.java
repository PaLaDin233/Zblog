package xyz.zhhg.zblog.web.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.lang.exception.articleexception.ArticleNotExistException;
import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.dao.ArticleDao;
import xyz.zhhg.zblog.web.dao.CommentDao;
import xyz.zhhg.zblog.web.pojo.Article;
import xyz.zhhg.zblog.web.pojo.Comment;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.pojo.form.ArticleSearchForm;
import xyz.zhhg.zblog.web.service.ArticleService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	ArticleDao articleDao;
	
	@Autowired
	CommentDao commentDao;

	@Override
	public void saveArticle(Article article)throws Exception{
		//如果是新增文章，则设置文章的id
		if(null==article.getId()||article.getId().equals(new BigInteger("0"))){
			try {
				articleDao.insertArticle(article);
				article.setId(articleDao.findLastIns());			
			} catch (Exception e) {
				throw new Exception("保存文章失败");
			}
		}
		else{//是更新文章
			articleDao.updateArticle(article);
		}	
	}
	
	@Override
	public void saveArticle(User user, Article article) throws Exception {
		//设置文章所属用户id
		article.setUserId(user.getId());
		//设置文章修改日期
		article.setModifiedDate();
		//保存文章
		saveArticle(article);	
	}

	@Override
	public Article loadArticle(BigInteger articleId)throws SearchException {
		
		Article article=articleDao.getArticleDetailsByArticleId(articleId);
		if(null==article){
			throw new SearchException("查找异常");
		}
		//增加访问数
		try{
			articleDao.incViewNum(articleId);			
		}catch(Exception e){
			e.printStackTrace();
			//TODO 添加错误日志
		}
		//获取文章评论
		List<Comment> comments=commentDao.selectArticleComment(articleId);
		//添加文章评论列表进文章
		article.setComments(comments);
		
		return article; 
		
	}

	@Override
	public void findArticleList(BigInteger uid, Paging page)throws SearchException{
		Article articleRules=new Article();
		if(!uid.equals(new BigInteger("0")))
		articleRules.setUserId(uid);
		Map<String,Object> conditionMap=BeanUtils.java2Map(articleRules);
		search(conditionMap,page);
		
	}

	/**
	 * 直接查找，不对条件map进行处理
	 */
	@Override
	public List<Article> search(Map<String, Object> conditionMap){
		return articleDao.findArticle(conditionMap);
	}

	@Override
	public void search(Map<String, Object> map, Paging page) throws SearchException{
		
		map.put("firstIndex", page.getFirstResult());
		map.put("pageSize", page.getMaxResults());
		String title=(String) map.get("title");
		if(!StringUtils.isEmpty(title)){
			map.put("title", "%"+title+"%");
		}
		List<Article>articles= search(map);
		if(null==articles||articles.size()==0){
			throw new ArticleNotExistException("不存在满足条件的文章");
		}
		page.setResults(articles);
	}

	@Override
	public void search(ArticleSearchForm form, Paging page)
			throws SearchException {
		Map<String,Object> map=BeanUtils.java2Map(form);
		search(map,page);
	}



	
	
	
	
	
}
