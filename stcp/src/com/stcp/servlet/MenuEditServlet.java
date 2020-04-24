package com.stcp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.LxDao;
import com.stcp.dao.MenuDao;
import com.stcp.entity.LxEntity;
import com.stcp.entity.MenuEntity;

/**
 * Servlet implementation class MenuEditServlet
 */
public class MenuEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuEditServlet() {
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
		// 1.��ȡid
		String id=request.getParameter("id");
		// 2.����menuDao��
		MenuDao mdao=new MenuDao();
		MenuEntity menu= mdao.selectMenuById(id);
		
		// 3.����lxDao��
		LxDao ldao=new LxDao();
		List list=ldao.selectLx();
		// 4.��ת���༭ҳ�棬
		request.setAttribute("menu",menu);
		request.setAttribute("lxs",list);
		
		request.getRequestDispatcher("/front/menu_edit.jsp").forward(request, response);
		
	}

}
