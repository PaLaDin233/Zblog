package xyz.zhhg.zblog.web.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.zhhg.zblog.lang.exception.DeleteException;
import xyz.zhhg.zblog.lang.exception.InsertException;
import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.lang.exception.UpdateException;
import xyz.zhhg.zblog.web.dao.ClasscifyDao;
import xyz.zhhg.zblog.web.pojo.Classcify;
import xyz.zhhg.zblog.web.pojo.User;
import xyz.zhhg.zblog.web.service.ClasscifyService;

@Service
public class ClasscifyServiceImpl implements ClasscifyService{

	@Autowired
	ClasscifyDao classcifyDao;
	
	@Override
	public void insert(Classcify classcify) throws InsertException {
		classcifyDao.insertClasscify(classcify);
	}

	@Override
	public void delete(List<BigInteger> ids) throws DeleteException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean delete(Classcify classcify) throws DeleteException {
		Classcify fo=new Classcify();
		fo.setId(classcify.getId());
		fo.setStatus(classcify.getStatus());
		return classcifyDao.updateClasscify(fo)==1?true:false;
	}

	@Override
	public void update(Classcify classcify) throws UpdateException {
		classcifyDao.updateClasscify(classcify);
	}

	@Override
	public List<Classcify> search(Map<String, Object> conditionMap)
			throws SearchException {
		return null;
	}

	@Override
	public List<Classcify> getClasscify(User user) {
		return classcifyDao.getClasscify(new BigInteger("0"));
	}

	

}
