package xyz.zhhg.zblog.lang.exception.userexception.loginexception;


/**
 * 密码错误异常
 * @author 清居
 *
 */
public class ErrorPassWordException extends LoginException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3277289598896863105L;

	public ErrorPassWordException() {
		// TODO Auto-generated constructor stub
	}

	public ErrorPassWordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ErrorPassWordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ErrorPassWordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ErrorPassWordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
