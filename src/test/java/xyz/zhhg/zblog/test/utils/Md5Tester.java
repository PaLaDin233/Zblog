package xyz.zhhg.zblog.test.utils;

import org.junit.Test;

import xyz.zhhg.zblog.utils.md5.MD5Util;

public class Md5Tester {
	@Test
	public void Test1(){
		String str="123456";
		System.out.println(MD5Util.md5(str, "啥"));
		System.out.println(MD5Util.md5(str));
	}
}
