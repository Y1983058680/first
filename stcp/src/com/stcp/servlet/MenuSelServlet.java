package com.stcp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.MenuDao;
import com.stcp.entity.UserEntity;

/**
 * Servlet implementation class MenuSelServlet
 */
public class MenuSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSelServlet() {
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
		// 1.从session获取当前登录用户id
		UserEntity user = (UserEntity) request.getSession().getAttribute("USER");
		int uid = user.getId();
		// 2.调用DAO方法，查询当前登录用户发表的
		MenuDao dao=new MenuDao();
		List list=dao.selectMenuByuid(uid+"");
		request.setAttribute("menus", list);
		// 3.展示页面展示我的菜谱
		request.getRequestDispatcher("/front/menu_list.jsp").forward(request, response);
	}

}
