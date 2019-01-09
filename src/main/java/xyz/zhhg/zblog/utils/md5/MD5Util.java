package xyz.zhhg.zblog.utils.md5;

import java.security.MessageDigest;

public final class MD5Util {
	private MD5Util(){}
	/**
	 * 返回全小写的MD5摘要字段
	 * @param str 需要进行摘要算法的源字段
	 * @param plusPassword 额外字段
	 * @return
	 */
	public static String md5(String str){
		return md5(str,"");
	}
	
	public static String md5(String str,String plusPassword) {
		return md5Til(str+plusPassword).toLowerCase();
	}
	/**
	 * 返回大写的MD5摘要字段
	 * @param str
	 * @param plusPassword
	 * @return
	 */
	public static String toUpperCaseMd5(String str,String plusPassword) {
		return md5Til(str+plusPassword).toUpperCase();
	}
	
	private static String md5Til(String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] bytes = md.digest(s.getBytes("utf-8"));
	        return toHex(bytes);
	    }
	    catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	private static String toHex(byte[] bytes) {

	    final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
	    StringBuilder ret = new StringBuilder(bytes.length * 2);
	    for (int i=0; i<bytes.length; i++) {
	        ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
	        ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
	    }
	    return ret.toString();
	}
}
