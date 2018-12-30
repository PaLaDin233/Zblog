package xyz.zhhg.zblog.lang.exception.userexception.registexception;

import xyz.zhhg.zblog.lang.exception.InsertException;


/**
 * 用户已存在异常
 * @author 清居
 *
 */
public class UserExistException extends InsertException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistException() {
		super();
	}

	public UserExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
