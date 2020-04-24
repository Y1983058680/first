package com.stcp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stcp.entity.GlyEntity;


public class GlyDao {
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;

	// 创建链接
	public Connection getConn() {
		Connection connection = null;

		try {
			// 装载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 建立连接,其实是创建了一个连接对象
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stcp", "root", "111");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public void addGly(String sql) {

		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行操作
			stmt.execute(sql);
			// 关闭通道，释放资源，关闭的顺序：先创建的后关闭，后创建的先关闭

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭通道，释放资源，关闭的顺序：先创建的后关闭，后创建的先关闭
			close();
		}
	}

	//查询
			public GlyEntity login(String zh,String pass) {
				/*
				 * 1.从数据库查询学生信息放到结果集
				 * 2.将结果集里面的数据封装到一个实体集对象中
				 * 3.将实体类对象放到LIST里面
				 * 4.将list返回给调用的地方
				 */
				GlyEntity gly=null;
				try {
					// 获取连接
					connection = getConn();
					// 获取执行者
					stmt = connection.createStatement();
					// 执行查询，将查询结果放入结果集
					rs = stmt.executeQuery("select * from gly where zh='"+zh+"' and pass='"+pass+"'");
					// 输出
					if (rs.next()) {
						
						int id=rs.getInt("id");
						String zh1 = rs.getString("zh");
						String pass1 = rs.getString("pass");
						
						gly=new GlyEntity(id,zh1,pass1);
						
					}
					System.out.println("\n");
					System.out.println("\n");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close();
				}
				return gly;
			}
			
			//释放资源
			public void close() {
				try {
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					if (connection != null) {
						connection.close();
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
