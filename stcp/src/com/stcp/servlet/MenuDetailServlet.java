package com.stcp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.MenuDao;
import com.stcp.dao.PlDao;
import com.stcp.entity.MenuEntity;

/**
 * Servlet implementation class MenuDetailServlet
 */
public class MenuDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDetailServlet() {
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
		// 
		String id=request.getParameter("id");
		
		MenuDao dao=new MenuDao();
		
		MenuEntity menu=dao.selectDetail(id);
		String sql="update menu set ydl="+(menu.getYdl()+1)+" where id="+id;
		dao.menuUp(sql);
		request.setAttribute("menu", menu);
		
		PlDao dao1=new PlDao();
		List list=dao1.selectPlByMenu(id);
		request.setAttribute("pls", list);
		
		
		request.getRequestDispatcher("/front/menu_detail.jsp").forward(request, response);
	}

}
