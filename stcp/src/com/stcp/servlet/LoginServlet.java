package com.stcp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.GlyDao;
import com.stcp.entity.GlyEntity;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		/*
		 * 1.
		 * 2.
		 * 3.
		 */
		// 获取登录页面账号，密码
		String zh=request.getParameter("zh");
		String pass=request.getParameter("pass");
		
		GlyDao dao=new GlyDao();
		GlyEntity gly=dao.login(zh, pass);
		
		if(gly!=null) {
			//如果登录成功，需要将查询的管理员对象记录在session
			request.getSession().setAttribute("gly", gly);
			// 请求转发
			request.getRequestDispatcher("/back/main.jsp").forward(request, response);
		}else {
			// 登陆失败
			request.getRequestDispatcher("/back/index.jsp").forward(request, response);
		}
	}

}
