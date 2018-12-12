package xyz.zhhg.zblog.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbctestDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String password="root";
		
		
		//加载驱动
		Class.forName(driver);
		
		//建立连接
		
		Connection connection=DriverManager.getConnection(url, username, password);
		
		//获取Statement
		
		Statement statement=connection.createStatement();
		
		//执行语句
		
		String sql="select * from member;";
		
		ResultSet rs=statement.executeQuery(sql);
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+"——"+rs.getString(2)+"——"+rs.getString(3));
		}
		
	}
}
