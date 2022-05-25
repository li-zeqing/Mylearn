package com.mylove.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionTest {

	
	//方式一：
	@Test
	public void testConnection1() throws SQLException{
		
		
		Driver driver = new com.mysql.jdbc.Driver();
		//jdbc:mysql 协议
		//localhost ip地址
		//3306 端口号
		//test 数据库名
//		jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		//将用户名和密码封装在Properties中
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "123456");
		
		Connection conn = driver.connect(url, info);
		
		System.out.println(conn);
	}
	
	//方式二：
	@Test
	public void testConnection2() throws Exception {
		//反射 动态获取连接
		//1.获取Driver实现类对象
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		//2.提供要连接的数据库
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		
		//3.提供连接需要的用户名和密码
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "123456");
		
		//4.获取连接
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
		
	}
	
	
}
