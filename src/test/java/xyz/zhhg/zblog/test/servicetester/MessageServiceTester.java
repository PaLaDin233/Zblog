package xyz.zhhg.zblog.test.servicetester;

import java.math.BigInteger;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import xyz.zhhg.zblog.lang.exception.SearchException;
import xyz.zhhg.zblog.test.BaseSpingTester;
import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.pojo.Message;
import xyz.zhhg.zblog.web.service.MessageService;

public class MessageServiceTester extends BaseSpingTester{

	MessageService messageService;
	
	@Before
	public void init(){
		messageService=(MessageService) context.getBean("messageServiceImpl");
		
	}
	
	@Test
	public void SelectTest() throws SearchException{
		Paging page=new Paging(0, 10);
		messageService.search(new BigInteger("3"), page);
		List<Message> messages= (List<Message>) page.getResults();
		for (Message message : messages) {
			System.out.println(message);
		}
	}
	
}
