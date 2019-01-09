package xyz.zhhg.zblog.web.conf;

public interface Views {
	/**
	 * 主页
	 */
	String HOME = "/";
	
	/**
	 * 登陆页
	 */
	String LOGIN = "/login";
	
	/**
	 * 注册页
	 */
	String REG = "/reg";
	
	/**
	 * 注册结果
	 */
	String REG_RESULT = "/message/message";
	
	/**
	 * 授权注册
	 */
	String OAUTH_REG = "/oauth_reg";

	/**
	 * 忘记密码申请
	 */
	String FORGOT_APPLY = "/forgot/apply";
	
	/**
	 * 忘记密码重置
	 */
	String FORGOT_RESET = "/forgot/reset";

	String Error_MESSAGE = "/message/message";
	
	/**
	 * 信息页
	 */
	String MESSAGE = "/message/message";
	/**
	 * 
	 */
	String INDEX = "/index";
	
	/**
	 * 文章列表页
	 */
	String ARTICLES = "/article/articles";
	
	/**
	 * 用户文章列表页
	 */
	String USERS_ARTICLE = "/user/articles";
	
	/**
	 * 文章详情页
	 */
	String ARTICLE_DETAILS = "/article/articleDetails";

	/**
	 * 文章编辑页
	 */
	String ARTICLE_EDIT="/user/article/articleEdit";
	
	/**
	 * 用户信息页
	 */
	String ACCOUNT_PROFILE = "/user/account/profile";
	
	
	/**
	 * 后台管理首页
	 */
	String ADMIN = "/admin/admin";
	
	/**
	 * 功能管理页
	 */
	String MENUMANAGER = "/admin/menu/MenuManager";
	
	String HOME_FEEDS = "/home/feeds";
	String HOME_POSTS = "/home/posts";
	String HOME_COMMENTS = "/home/comments";
	String HOME_FOLLOWS = "/home/follows";
	String HOME_FAVORS = "/home/favors";
	String HOME_FANS = "/home/fans";
	String HOME_NOTIFIES = "/home/notifies";

	String TA_HOME = "/ta/home";
	String ACCOUNT_AVATAR = "/user/account/avatar";
	String ACCOUNT_PASSWORD = "/user/account/password";
	String ACCOUNT_EMAIL = "/user/account/email";

	String BLOG_UPLOAD = "/post/upload";
	
	String TAGS_INDEX = "/tags/index";
	String TAGS_TAG = "/tags/tag";
	
	String BROWSE_GALLERY = "/gallery/index";
	String BROWSE_GALLERY_SNIPPET = "/gallery/snippet";
	String BROWSE_SEARCH = "/browse/search";
	String BROWSE_DETAIL = "/browse/detail";
	
	String ROUTE_POST_PUBLISH = "/group/%s/post";
	String ROUTE_POST_INDEX = "/group/%s/index";
	String ROUTE_POST_VIEW = "/group/%s/view";

	String MESSAGE_BOARD = "/user/messageboard";



	

	

	

	

	
}