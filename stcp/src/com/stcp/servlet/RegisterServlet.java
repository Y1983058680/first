package com.stcp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡע�����ֵ
		String zh=request.getParameter("zh");
		String pass=request.getParameter("pass");
		String realname=request.getParameter("realname");
		// ����dao��ע�᷽��
		UserDao dao=new UserDao();
		String sql="insert into user(zh,pass,realname) values('"+zh+"','"+pass+"','"+realname+"')";
		dao.register(sql);
		// ��ת����¼
		request.getRequestDispatcher("/front/login.jsp").forward(request, response);
	}

}
