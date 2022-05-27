package com.mylove3.preparedstatement.crud;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.junit.Test;

import com.mylove.connection.ConnectionTest;
import com.mylove3.util.JDBCUtils;

public class PreparedStatementUpdateTest {

	
	//修改customers表中的一条记录
	@Test
	public void testUpdate() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取数据库连接
			conn = JDBCUtils.getConnection();
			//2.预编译sql语句，返回PreparedStatement的实例
			String sql = "update customers set name = ? where id = ?";
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			ps.setString(1, "莫扎特");
			ps.setInt(2, 18);
			//4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.资源关闭
			JDBCUtils.closeResource(conn, ps);
			
		}
	}
	
	//向customers表中插入一条记录
	@Test
	public void testInsert() {
		//1.读取配置文件中的4个的基本信息
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
					
					Properties pros = new Properties();
					pros.load(is);
					
					String user = pros.getProperty("user");
					String password = pros.getProperty("password");
					String url = pros.getProperty("url");
					String driverClass = pros.getProperty("driverClass");
					
					//2.加载驱动
					Class.forName(driverClass);
					
					//3.获取连接
					conn = DriverManager.getConnection(url, user, password);
//				System.out.println(conn);
					//4.预编译sql语句，返回PreparedStatement的实例
					String sql = "insert into customers(name,email,birth)values(?,?,?)"; //? 占位符
					
					ps = conn.prepareStatement(sql);
					//5.填充占位符
					ps.setString(1, "张三");
					ps.setString(2, "zhangsan@163.com");
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
					java.util.Date date = sdf.parse("2000-01-01");
					ps.setDate(3,new Date(date.getTime()));
					
					//6.执行操作
					ps.execute();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					//7.资源的关闭
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
	}
}
