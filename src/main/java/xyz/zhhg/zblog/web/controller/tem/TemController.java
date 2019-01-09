package xyz.zhhg.zblog.web.controller.tem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/go")
public class TemController {

	@RequestMapping("/{page}*")
	public String go(@PathVariable String page){
		System.out.println(page);
		return "/"+page+".jsp";
	}
	@RequestMapping("/jsp/{page}")
	public String gojsp(@PathVariable String page){
		return "/jsp/"+page+".jsp";
	}
}
