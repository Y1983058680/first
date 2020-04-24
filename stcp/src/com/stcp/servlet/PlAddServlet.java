package com.stcp.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.PlDao;
import com.stcp.entity.UserEntity;

/**
 * Servlet implementation class PlAddServlet
 */
public class PlAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlAddServlet() {
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
		String mid=request.getParameter("mid");
		String con=request.getParameter("con");
		
		Date systemDate = new Date();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String plsj=format1.format(systemDate);
		
		UserEntity user=(UserEntity)request.getSession().getAttribute("USER");
		String plr=user.getRealname();
		
		PlDao dao =new PlDao();
		String sql="insert into pl(mid,content,plr,plsj) "
				+ "values("+mid+",'"+con+"','"+plr+"','"+plsj+"')";
		dao.addPl(sql);
		
		String json="{'plr':'"+plr+"','plsj':'"+plsj+"'}";

		//将数据返回到页面
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(json);
	}

}
