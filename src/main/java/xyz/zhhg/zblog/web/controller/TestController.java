package xyz.zhhg.zblog.web.controller;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import xyz.zhhg.zblog.utils.bean.BeanUtils;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.pojo.Article;

@Controller
public class TestController extends BaseController{
	@RequestMapping("/hi")
	public String hi(String str){
		System.out.println(str);
		return "../index.jsp";
	}
	@RequestMapping("/test")
	public @ResponseBody void test(HttpServletRequest request,@RequestBody String str){
		System.out.println("hello world");
		Map<String,String[]> map=request.getParameterMap();
		
		for (Entry<String, String[]> entry : map.entrySet()) {
			StringBuilder builder=new StringBuilder();
			builder.append("[ "+entry.getKey()
					+",{");
			for (String s: entry.getValue()) {
				builder.append(s);
			}
			builder.append("}]");
			System.out.println(builder.toString());
		}
		System.out.println("RequestBody:"+str);
	}
	@RequestMapping("/editTest")
	public String editTest(HttpServletRequest request){
		String editor[]=request.getParameterMap().get("editorValue");
		for (String string : editor) {
			System.out.println(string);
		}
		request.setAttribute("msg", editor);
		return getView(Views.Error_MESSAGE);
	}
}
