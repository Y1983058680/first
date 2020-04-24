package com.stcp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stcp.entity.LxEntity;
import com.stcp.entity.UserEntity;

public class UserDao {
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
	
	public void register(String sql) {

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
	
	public UserEntity login(String zh,String pass) {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.���������������ݷ�װ��һ��ʵ�弯������
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		UserEntity user=null;
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from user where zh='"+zh+"' and pass='"+pass+"'");
			// ���
			if (rs.next()) {
				
				int id=rs.getInt("id");
				String zh1 = rs.getString("zh");
				String pass1 = rs.getString("pass");
				String realname = rs.getString("realname");
				user=new UserEntity(id,zh1,pass1,realname);
				
			}
			System.out.println("\n");
			System.out.println("\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
	}
	
	public List selectUser() {
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
			rs = stmt.executeQuery("select * from user");
			// ���
			while (rs.next()) {
				
				int id=rs.getInt("id");
				String zh = rs.getString("zh");
				String pass=rs.getString("pass");
				String realname=rs.getString("realname");
				UserEntity lx=new UserEntity(id,zh,pass,realname);
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
	
	public void userDel(String sql) {

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
	
	public UserEntity checkName(String zh) {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
		 * 2.���������������ݷ�װ��һ��ʵ�弯������
		 * 3.��ʵ�������ŵ�LIST����
		 * 4.��list���ظ����õĵط�
		 */
		UserEntity user=null;
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from user where zh='"+zh+"'");
			// ���
			if (rs.next()) {
				
				int id=rs.getInt("id");
				String zh1 = rs.getString("zh");
				String pass1 = rs.getString("pass");
				String realname = rs.getString("realname");
				user=new UserEntity(id,zh1,pass1,realname);
				
			}
			System.out.println("\n");
			System.out.println("\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
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
