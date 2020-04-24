package com.stcp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stcp.entity.LxEntity;

public class LxDao {
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
	public List selectLx() {
		/*
		 * 1.从数据库查询学生信息放到结果集 2. 3.将实体类对象放到LIST里面 4.将list返回给调用的地方
		 */
		List list = new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from lx");
			// 输出
			while (rs.next()) {

				int id = rs.getInt("id");
				String lxmc = rs.getString("lxmc");

				LxEntity lx = new LxEntity(id, lxmc);
				list.add(lx);
			}
			System.out.println("\n");
			System.out.println("\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void addLx(String sql) {

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

	public void delLx(String sql) {

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

	// 查询
	public LxEntity selectLxById(String id) {
		/*
		 * 1.从数据库查询学生信息放到结果集 2.将结果集里面的数据封装到一个实体集对象中 3.将实体类对象放到LIST里面 4.将list返回给调用的地方
		 */
		LxEntity lx = null;
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from lx where id="+id);
			// 输出
			if (rs.next()) {

				int id1 = rs.getInt("id");
				String lxmc = rs.getString("lxmc");

				lx = new LxEntity(id1, lxmc);

			}
			System.out.println("\n");
			System.out.println("\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return lx;
	}

	public void upLx(String sql) {

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
