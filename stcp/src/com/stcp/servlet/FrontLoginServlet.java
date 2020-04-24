package com.stcp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.UserDao;
import com.stcp.entity.UserEntity;

/**
 * Servlet implementation class FrontLoginServlet
 */
public class FrontLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginServlet() {
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
		// 获取登录页面表单的值
		String zh=request.getParameter("zh");
		String pass=request.getParameter("pass");
		//
		UserDao dao=new UserDao();
		UserEntity user=dao.login(zh, pass);
		if(user!=null) {
			request.getSession().setAttribute("USER", user);
			request.getRequestDispatcher("/front/index.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/front/login.jsp").forward(request, response);
		}
		
	}

}
