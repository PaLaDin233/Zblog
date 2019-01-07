package xyz.zhhg.zblog.test.utils.gson;

import java.math.BigInteger;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import xyz.zhhg.zblog.web.pojo.User;

public class GsonTester1 {
	
	
	@Test
	public void JsonToJavaBean(){
		User user=new User(new BigInteger("5"), "n123", "p321", 0, "123.123.123.1", 0, "123@123.qq", "12345678911");
		Gson gson=new Gson();
		String uJson=gson.toJson(user);
		User u=gson.fromJson(uJson,User.class);
		System.out.println(u);
	}
	@Test
	public void JavaBeanToJson(){
		
	}
}
