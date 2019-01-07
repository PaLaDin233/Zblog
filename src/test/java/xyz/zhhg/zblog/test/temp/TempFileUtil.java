package xyz.zhhg.zblog.test.temp;

import java.io.IOException;
import java.sql.Date;

/**
 * 将webapp/js下面的所有文件.下载的后缀去掉
 * @author 清居
 *
 */
public class TempFileUtil {
	public static void main(String[] args) throws IOException {
		Date date=new Date(System.currentTimeMillis());
		
		System.out.println(date.toLocalDate());
	
	}
}
