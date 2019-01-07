package xyz.zhhg.zblog.test.daotest;

import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.zhhg.zblog.web.dao.MessageDao;
import xyz.zhhg.zblog.web.pojo.Message;

public class MessageDaoTester {
	
	private MessageDao messageDao;
	
	@Before
	public void init(){
		messageDao=(MessageDao)new ClassPathXmlApplicationContext("spring-context.xml").getBean(MessageDao.class);
	}
	
	@Test
	public void insertTest(){
		Message message=new Message();
		message.setDetail("雷aaa猴啊啊");
		message.setUid(new BigInteger("6"));
		message.setMid(new BigInteger("3"));
		messageDao.leaveMessage(message);
	}
	@Test
	public void getMessagetList(){
		List<Message> messages =messageDao.getLMessagesfromMasterId(new BigInteger("3"));
		for (Message message : messages) {
			System.out.println(message);
		}
	}
	
}
