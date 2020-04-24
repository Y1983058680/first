package com.stcp.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stcp.dao.MenuDao;
import com.stcp.entity.UserEntity;

/**
 * Servlet implementation class MenuAddServlet
 */
public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAddServlet() {
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
		// 1.获取表单的值
		String lxid=request.getParameter("lxid");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		// 2.从当前登录对象获取uid和auther
		UserEntity user=(UserEntity) request.getSession().getAttribute("USER");
		int uid=user.getId();
		
		String auther=user.getRealname();
		// 3.从系统获取时间
		Date systemDate = new Date();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createtime=format1.format(systemDate);
		
		MenuDao dao=new MenuDao();
		String sql="insert into menu(uid,auther,title,content,ydl,createtime,lxid) "
				+ "values("+uid+",'"+auther+"','"+title+"','"+content+"',0,'"+createtime+"',"+lxid+")";
		dao.menuAdd(sql);
		
		request.getRequestDispatcher("/menusel").forward(request, response);
		
	}
	
}
