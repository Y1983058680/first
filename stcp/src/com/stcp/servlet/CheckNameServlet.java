package com.stcp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.UserDao;
import com.stcp.entity.UserEntity;

/**
 * Servlet implementation class CheckNameServlet
 */
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNameServlet() {
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
		// TODO Auto-generated method stub
		String zh=request.getParameter("zh");
		
		UserDao dao=new UserDao();
		UserEntity user = dao.checkName(zh);
		String flag="N";
		if(user!=null) {
			flag="Y";
		}
		System.out.println(flag);
		//将数据返回到页面
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(flag);
	}

}
