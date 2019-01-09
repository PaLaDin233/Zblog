package xyz.zhhg.zblog.test.daotest;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import xyz.zhhg.zblog.test.BaseSpingTester;
import xyz.zhhg.zblog.web.dao.ClasscifyDao;
import xyz.zhhg.zblog.web.pojo.Classcify;

@Transactional(rollbackFor=Exception.class)
public class ClassifyDaoTester extends BaseSpingTester {
	
	ClasscifyDao classcifyDao=(ClasscifyDao) context.getBean("classcifyDao");
	
	@Test
	public void insertTest(){
		Classcify classcify=new Classcify();
		classcify.setSuperior(new BigInteger("3"));
		classcify.setName("算法");
		classcifyDao.insertClasscify(classcify);
	}
	
	@Test
	public void getAllClasscify(){
		
		List<Classcify> classcifies=classcifyDao.getClasscify(null);
		for (Classcify classcify : classcifies) {
			System.out.println(classcify);
		}
	}
	
	@Test
	public void updateClasscify(){
		Classcify classcify=new Classcify();
		classcify.setId(new BigInteger("0"));
		classcify.setName("顶级");
		classcify.setSuperior(new BigInteger("0"));
		classcifyDao.updateClasscify(classcify);
		getAllClasscify();
	}
	
}
