package com.mylove.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
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
	
	//方式三：使用DriverManager替换Driver
	@Test
	public void testConnection3() throws Exception {
		//1.获取Driver实现类对象
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		//2.提供另外三个连接基本信息
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		//注册驱动
		DriverManager.registerDriver(driver);
		//获取连接
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	
	//方式四：只是加载驱动，不用显示的注册驱动
	@Test
	public void testConnection4() throws Exception {
		//1.提供三个连接基本信息
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		
		//2.加载Driver驱动
		Class.forName("com.mysql.jdbc.Driver");
		//相较于方式三、可以省略如下操作：
//		Driver driver = (Driver) clazz.newInstance();
		//注册驱动
//		DriverManager.registerDriver(driver);
		
		//查看Driver源码：
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
			try {
				java.sql.DriverManager.registerDriver(new Driver());
			} catch (SQLException E) {
				throw new RuntimeException("Can't register driver!");
				}
		}
		 * 
		 * */
		
		//获取连接
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	
	//方式五：将数据库连接需要的4个基本信息声明在配置文件中
	@Test
	public void testConnection5() throws Exception {
		//1.读取配置文件中的4个的基本信息
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties pros = new Properties();
		pros.load(is);
		
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");
		
		//2.加载驱动
		Class.forName(driverClass);
		
		//3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn);
		
		
	}
}
