package xyz.zhhg.zblog.web.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.pojo.Message;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.baseinterface.Deleteable;
import xyz.zhhg.zblog.web.service.baseinterface.Insertable;
import xyz.zhhg.zblog.web.service.baseinterface.Searchable;

@Service
public interface MessageService extends Insertable<Message>,Deleteable<BigInteger>,Searchable<Message>{

	void insert(Message message, User user) throws InsertException;
	
	public void search(BigInteger mid,Paging page) throws SearchException;
	
}
