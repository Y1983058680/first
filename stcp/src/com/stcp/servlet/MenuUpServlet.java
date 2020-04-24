package com.stcp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.MenuDao;

/**
 * Servlet implementation class MenuUpServlet
 */
public class MenuUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUpServlet() {
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
		String lxid=request.getParameter("lxid");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		MenuDao dao=new MenuDao();
		String sql="update menu set title='"+title+"',content='"+content+"',lxid="+lxid+" where id="+id;
		dao.menuUp(sql);
		request.getRequestDispatcher("/menusel").forward(request, response);
		
	}

}
