package com.jxy.controller;
import com.jxy.model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * Servlet implementation class LoginClServlet
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		UserBeanCl ubc=new UserBeanCl();
		  if(ubc.checkUser(u,p)){
			 //data prepared for jsp;
			  ArrayList al=ubc.getUsersByPage(1);
			  int pageCount=ubc.getPageCount();
			  request.setAttribute("al", al);
			  request.setAttribute("pageCount", pageCount);
			  request.setAttribute("pageNow", 1);
			  //将用户名放入session 默认持续30min；
			  request.getSession().setAttribute("myName", u);
			  //di xiao response.sendRedirect("wel.jsp");
			  request.getRequestDispatcher("main.jsp").forward(request, response);
		  }else{
			  request.getRequestDispatcher("login.jsp").forward(request, response);
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
