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

	// ��������
	public Connection getConn() {
		Connection connection = null;

		try {
			// װ����������
			Class.forName("com.mysql.jdbc.Driver");
			// ��������,��ʵ�Ǵ�����һ�����Ӷ���
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
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в���
			stmt.execute(sql);
			// �ر�ͨ�����ͷ���Դ���رյ�˳���ȴ����ĺ�رգ��󴴽����ȹر�

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر�ͨ�����ͷ���Դ���رյ�˳���ȴ����ĺ�رգ��󴴽����ȹر�
			close();
		}
	}
	// ��ѯ�ҵĲ���
	public List selectMenuByuid(String uid) {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		List list=new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu where uid="+uid);
			// ���
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
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		MenuEntity menu=new MenuEntity();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu where id="+id);
			// ���
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
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		List list=new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu order by ydl desc limit 0,10");
			// ���
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
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		List list=new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu where title='"+ss+"' || auther='"+ss+"'");
			// ���
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
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		List list=new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu order by createtime desc limit 0,10");
			// ���
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
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		List list=new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu where lxid="+lxid);
			// ���
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
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в���
			stmt.execute(sql);
			// �ر�ͨ�����ͷ���Դ���رյ�˳���ȴ����ĺ�رգ��󴴽����ȹر�

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر�ͨ�����ͷ���Դ���رյ�˳���ȴ����ĺ�رգ��󴴽����ȹر�
			close();
		}
	}
	public MenuEntity selectMenuById(String id) {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.���������������ݷ�װ��һ��ʵ�弯������
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		MenuEntity menu=null;
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from menu where id="+id);
			// ���
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
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в���
			stmt.execute(sql);
			// �ر�ͨ�����ͷ���Դ���رյ�˳���ȴ����ĺ�رգ��󴴽����ȹر�

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// �ر�ͨ�����ͷ���Դ���رյ�˳���ȴ����ĺ�رգ��󴴽����ȹر�
			close();
		}
	}
	//�ͷ���Դ
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
