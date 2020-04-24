package com.stcp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.MenuDao;

/**
 * Servlet implementation class MenuSelByLxServlet
 */
public class MenuSelByLxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSelByLxServlet() {
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
		// 获取类型id
		String lxid=request.getParameter("lxid");
		
		// 调用
		MenuDao dao=new MenuDao();
		List list=dao.selectMenuByLx(lxid);
		request.setAttribute("menulx", list);
		// 跳转
		request.getRequestDispatcher("/front/menu_lx_list.jsp").forward(request, response);
	}

}
