package com.jxy.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jxy.model.*;
/**
 * Servlet implementation class PageCl
 */
@WebServlet("/PageCl")
public class PageCl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageCl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//pageNow
		String flag=request.getParameter("flag");
		if(flag.equals("1")){
			
		
		String s_pageNow=request.getParameter("pageNow");
		try{ 
			 
		    int pageNow=Integer.parseInt(s_pageNow);
			   
			 
			//调用UserBeanCl model
			
			UserBeanCl ubc=new UserBeanCl();
			ArrayList al=ubc.getUsersByPage(pageNow);
			int pageCount=ubc.getPageCount();
			  request.setAttribute("al", al);
			  request.setAttribute("pageCount", pageCount);
			  request.setAttribute("pageNow", pageNow);
			  request.getRequestDispatcher("wel.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		   }
		}else if(flag.equals("2")){
			try{
				//得到删除用户id号
				String userId=request.getParameter("id");
				
				UserBeanCl ubc=new UserBeanCl();
				
				if(ubc.deleteUserById(userId)){
					request.getRequestDispatcher("suc.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}	
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(flag.equals("3")){
			try{
				//add an account
				String userId=request.getParameter("userid");
				String userName=request.getParameter("username");
				String passWord=request.getParameter("password");
				String eMail=request.getParameter("emailaddress");
				String Grade=request.getParameter("grade");
				UserBeanCl ubc=new UserBeanCl();
				if(ubc.addUser(userName, passWord, eMail, Grade)){
					request.getRequestDispatcher("suc1.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(flag.equals("4")){
			try{
				//add an account
				String Id=request.getParameter("id");
				String userName=request.getParameter("username");
				String passWord=request.getParameter("password");
				String eMail=request.getParameter("emailaddress");
				String Grade=request.getParameter("grade");
				UserBeanCl ubc=new UserBeanCl();
				if(ubc.editUser(Id,userName, passWord, eMail, Grade)){
					request.getRequestDispatcher("suc.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
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
