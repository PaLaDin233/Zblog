package xyz.zhhg.zblog.web.controller.view.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.controller.BaseController;

@Controller
public class AccountViewController extends BaseController{
	
	@RequestMapping("/password")
	public String pwdView(){
		return getView(Views.ACCOUNT_PASSWORD);
	}
	
	@RequestMapping("/profile")
	public String profileView(){
		return getView(Views.ACCOUNT_PROFILE);
	}
}
