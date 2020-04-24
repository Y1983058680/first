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
	public List selectLx() {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������ 2. 3.��ʵ�������ŵ�LIST���� 4.��list���ظ����õĵط�
		 */
		List list = new ArrayList();
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from lx");
			// ���
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

	public void delLx(String sql) {

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

	// ��ѯ
	public LxEntity selectLxById(String id) {
		/*
		 * 1.�����ݿ��ѯѧ����Ϣ�ŵ������ 2.���������������ݷ�װ��һ��ʵ�弯������ 3.��ʵ�������ŵ�LIST���� 4.��list���ظ����õĵط�
		 */
		LxEntity lx = null;
		try {
			// ��ȡ����
			connection = getConn();
			// ��ȡִ����
			stmt = connection.createStatement();
			// ִ�в�ѯ������ѯ�����������
			rs = stmt.executeQuery("select * from lx where id="+id);
			// ���
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
