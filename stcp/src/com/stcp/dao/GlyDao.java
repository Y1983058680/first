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

	public void addGly(String sql) {

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

	//��ѯ
			public GlyEntity login(String zh,String pass) {
				/*
				 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������
				 * 2.���������������ݷ�װ��һ��ʵ�弯������
				 * 3.��ʵ�������ŵ�LIST����
				 * 4.��list���ظ����õĵط�
				 */
				GlyEntity gly=null;
				try {
					// ��ȡ����
					connection = getConn();
					// ��ȡִ����
					stmt = connection.createStatement();
					// ִ�в�ѯ������ѯ�����������
					rs = stmt.executeQuery("select * from gly where zh='"+zh+"' and pass='"+pass+"'");
					// ���
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
