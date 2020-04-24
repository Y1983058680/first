package com.stcp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.stcp.entity.PlEntity;

public class PlDao {
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

	// 查询
	public List selectPlByMenu(String mid) {
		/*
		 * 1.从数据库查询学生信息放到结果集 2.将结果集里面的每一条数据封装到一个个实体类对象中 3.将实体类对象放到list里面 4.将list方会给调用的地方
		 */
		List list = new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from pl where mid=" + mid + " order by plsj desc");
			// 输出
			while (rs.next()) {

				int id = rs.getInt("id");
				int menuid = rs.getInt("mid");
				String content = rs.getString("content");
				String plr = rs.getString("plr");
				String plsj = rs.getString("plsj");

				PlEntity pl = new PlEntity(id, menuid, content, plr, plsj);

				list.add(pl);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	
	public void addPl(String sql) {

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

	// 释放资源
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
