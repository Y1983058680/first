package com.stcp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stcp.entity.LxEntity;
import com.stcp.entity.MenuEntity;

public class MenuDao {
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
	
	public void menuAdd(String sql) {

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
	// 查询我的菜谱
	public List selectMenuByuid(String uid) {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		List list=new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu where uid="+uid);
			// 输出
			while (rs.next()) {
				
				int id=rs.getInt("id");
				int uid1=rs.getInt("uid");
				String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int ydl=rs.getInt("ydl");
				String createtime = rs.getString("createtime");
				int lxid=rs.getInt("lxid");
				
				MenuEntity menu=new MenuEntity(id,uid1,auther,title,content,ydl,createtime,lxid);
				list.add(menu);
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
	
	public MenuEntity selectDetail(String id) {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		MenuEntity menu=new MenuEntity();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu where id="+id);
			// 输出
			while (rs.next()) {
				
				int id1=rs.getInt("id");
				//int uid1=rs.getInt("uid");
				String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int ydl=rs.getInt("ydl");
				String createtime = rs.getString("createtime");
				int lxid=rs.getInt("lxid");
				
				menu=new MenuEntity();
				menu.setId(id1);
				menu.setAuther(auther);
				menu.setTitle(title);
				menu.setContent(content);
				menu.setYdl(ydl);
				menu.setCreatetime(createtime);
				menu.setLxid(lxid);
				
			}
			System.out.println("\n");
			System.out.println("\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return menu;
	}
	
	public List selectMenuByYdl() {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		List list=new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu order by ydl desc limit 0,10");
			// 输出
			while (rs.next()) {
				
				int id=rs.getInt("id");
				int uid1=rs.getInt("uid");
				String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int ydl=rs.getInt("ydl");
				String createtime = rs.getString("createtime");
				int lxid=rs.getInt("lxid");
				
				MenuEntity menu=new MenuEntity(id,uid1,auther,title,content,ydl,createtime,lxid);
				list.add(menu);
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
	
	public List selectMenu(String ss) {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		List list=new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu where title='"+ss+"' || auther='"+ss+"'");
			// 输出
			while (rs.next()) {
				
				int id=rs.getInt("id");
				int uid1=rs.getInt("uid");
				String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int ydl=rs.getInt("ydl");
				String createtime = rs.getString("createtime");
				int lxid=rs.getInt("lxid");
				
				MenuEntity menu=new MenuEntity(id,uid1,auther,title,content,ydl,createtime,lxid);
				list.add(menu);
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
	
	public List selectMenuByCreatetime() {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		List list=new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu order by createtime desc limit 0,10");
			// 输出
			while (rs.next()) {
				
				int id=rs.getInt("id");
				int uid1=rs.getInt("uid");
				String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int ydl=rs.getInt("ydl");
				String createtime = rs.getString("createtime");
				int lxid=rs.getInt("lxid");
				
				MenuEntity menu=new MenuEntity(id,uid1,auther,title,content,ydl,createtime,lxid);
				list.add(menu);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public List selectMenuByLx(String lxid) {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		List list=new ArrayList();
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu where lxid="+lxid);
			// 输出
			while (rs.next()) {
				
				int id=rs.getInt("id");
				int uid1=rs.getInt("uid");
				String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int ydl=rs.getInt("ydl");
				String createtime = rs.getString("createtime");
				int lxid1=rs.getInt("lxid");
				
				MenuEntity menu=new MenuEntity(id,uid1,auther,title,content,ydl,createtime,lxid1);
				list.add(menu);
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
	
	public void menuDel(String sql) {

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
	public MenuEntity selectMenuById(String id) {
		/*
		 * 1.从数据库查询学生信息放到结果集
		 * 2.将结果集里面的数据封装到一个实体集对象中
		 * 3.将实体类对象放到LIST里面
		 * 4.将list返回给调用的地方
		 */
		MenuEntity menu=null;
		try {
			// 获取连接
			connection = getConn();
			// 获取执行者
			stmt = connection.createStatement();
			// 执行查询，将查询结果放入结果集
			rs = stmt.executeQuery("select * from menu where id="+id);
			// 输出
			if (rs.next()) {
				
				int id1=rs.getInt("id");
				//int uid=rs.getInt("uid");
				//String auther = rs.getString("auther");
				String title = rs.getString("title");
				String content = rs.getString("content");
				//int ydl=rs.getInt("ydl");
				//String createtime = rs.getString("createtime");
				int lxid=rs.getInt("lxid");
				menu=new MenuEntity();
				menu.setId(id1);
				menu.setTitle(title);
				menu.setContent(content);
				menu.setLxid(lxid);
				
			}
			System.out.println("\n");
			System.out.println("\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return menu;
	}
	public void menuUp(String sql) {

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
