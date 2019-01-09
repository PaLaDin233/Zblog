package xyz.zhhg.zblog.web.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.DeleteException;
import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.dao.MessageDao;
import xyz.zhhg.zblog.web.pojo.Message;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageDao messageDao;
	
	@Override
	public void insert(Message message,User user) throws InsertException {
		message.setUid(user.getId());
		insert(message);
	}

	@Override
	public void insert(Message message) throws InsertException {
		messageDao.leaveMessage(message);
		
	}
	
	@Override
	public void delete(List<BigInteger> idList) throws DeleteException {
		messageDao.deleteMessageFromIdList(idList);
	}
	
	public void search(BigInteger mid,Paging page) throws SearchException{
		Message message=new Message();
		message.setMid(mid);
		Map<String,Object> map=BeanUtils.java2Map(message);
		//初始化条件map
		int firstIndex=page.getFirstResult();
		int pageSize=page.getMaxResults();
		
		map.put("firstIndex", firstIndex);
		map.put("pageSize", pageSize);
		
		
		List<Message> messages=null;
		
		
		messages=search(map);
		
		page.setResults(messages);
	}

	@Override
	public List<Message> search(Map<String, Object> conditionMap)
			throws SearchException {
		return messageDao.getMessageList(conditionMap);
	}

	

}
