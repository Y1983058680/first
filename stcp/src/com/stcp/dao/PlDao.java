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

	// ��ѯ
	public List selectPlByMenu(String mid) {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������ 2.������������ÿһ�����ݷ�װ��һ����ʵ��������� 3.��ʵ�������ŵ�list���� 4.��list��������õĵط�
		 */
		List list = new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from pl where mid=" + mid + " order by plsj desc");
			// ���
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

	// �ͷ���Դ
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
