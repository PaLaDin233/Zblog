package xyz.zhhg.zblog.web.service.impl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.lang.exception.UpdateException;
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
	public void saveArticle(Article article)throws InsertException{
		//如果是新增文章，则设置文章的id
		if(null==article.getId()||article.getId().equals(new BigInteger("0"))){
			try {
				articleDao.insertArticle(article);
				article.setId(articleDao.findLastIns());			
			} catch (Exception e) {
				throw new InsertException("保存文章失败");
			}
		}
		else{//是更新文章
			articleDao.updateArticle(article);
			System.out.println("更新前："+article);
		}	
	}
	
	@Override
	public void saveArticle(User user, Article article) throws UpdateException,InsertException {
		//设置文章所属用户id
		if(null==article.getId()||article.getId().equals(new BigInteger("0"))){
			article.setUserId(user.getId());
		}else{
			Article test=null;
			try {
				test=loadArticle(article.getId());
			} catch (SearchException e) {
				throw new UpdateException("请不要自己输入文章编号，这样是不可以的");
			}
			if(!user.getId().equals(test.getUserId())){
				throw new UpdateException("没有权限");
			}
			article.setUserId(user.getId());
		}
		
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
		page.setTotalCount(articleDao.selectCountArticle(map));
	}

	@Override
	public List<Date> getPigeonholeDate() {
		return articleDao.getPigeonholeDate("%y%m%d");
	}

	@Override
	public void deleteArticles(List<BigInteger> idList,User user) {
		articleDao.deleteArticleByIdList(idList, user.getId());
		
	}



	
	
	
	
	
}
