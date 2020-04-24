package com.stcp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.LxDao;
import com.stcp.dao.MenuDao;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		LxDao ldao=new LxDao();
		List list=ldao.selectLx();
		request.getSession().setAttribute("lxs", list);
		
		MenuDao mdao=new MenuDao();
		List mlist=mdao.selectMenuByYdl();
		request.setAttribute("menuydl", mlist);
		
		List mlist1=mdao.selectMenuByCreatetime();
		request.setAttribute("menucreatetime", mlist1);
		// Ìø×ªµ½Ê×Ò³
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
		
	}

}
