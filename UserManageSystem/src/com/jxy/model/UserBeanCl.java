package com.jxy.model;
import java.sql.*;
import java.util.*;
public class UserBeanCl {
	    private Statement sm=null;
	    private ResultSet rs=null;
	    private Connection ct=null;
	    private int pageSize=3;
		private int rowCount=0;
		private int pageCount=0;
		
		public int getPageCount(){
			try{   
				   ct=new ConnDB().getConn();
				   sm=ct.createStatement();
				   rs=sm.executeQuery("select count(*) from userinformation");
	    		   if(rs.next()){
	    			   rowCount=rs.getInt(1);
	    		   }
	    		   if(rowCount%pageSize==0){
	    			   pageCount=rowCount/pageSize;
	    		   }else{
	    			   pageCount=rowCount/pageSize+1;
	    		   }
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				   this.close();
			}
			
			return pageCount;
		}
	    public ArrayList getUsersByPage(int pageNow){
	    	ArrayList al=new ArrayList();
	    	try{
	    		   ct=new ConnDB().getConn();
	    		   sm=ct.createStatement();
	    		   
	    		   rs=sm.executeQuery("select *from userinformation limit "+(pageNow-1)*pageSize+","+pageSize);
	    	while(rs.next()){
	    		userbean ub=new userbean();
	    		ub.setUserId(rs.getInt(1));
	    		ub.setUserName(rs.getString(2));
	    		ub.setPassword(rs.getString(3));
	    		ub.setEmail(rs.getString(4));
	    		ub.setGrade(rs.getInt(5));
	    		al.add(ub);
	    	  }    	
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally{
	    		this.close();
	    	}   	
	    	return al;
	    }
	    
		public void close(){
			try{
				if(rs!=null){
					rs.close();
					rs=null;
				}
				if(sm!=null){
					sm.close();
					sm=null;
				}
				if(ct!=null){
					ct.close();
					ct=null;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	    public boolean checkUser(String u,String p){
	    	boolean b=false;
	    	try{
	    		 ct=new ConnDB().getConn();
	    		 sm=ct.createStatement();
	    		 rs=sm.executeQuery("select password from userinformation where username='"+u+"'");
	    		  if(rs.next()){
	    		      if(rs.getString("password").equals(p)){
	    		    	  b=true;  
	    		      }
	    		      
	    		  }
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally{
	    		
	    		this.close();
	    		
	    	}
	    	return b;
	    }
	    public boolean deleteUserById(String id){
	    	boolean b=false;
	    	try{
	    		ct=new ConnDB().getConn();
	    		sm=ct.createStatement();
	    		int a=sm.executeUpdate("delete from userinformation where userid='"+id+"'");
	    		if(a==1){
	    			b=true;
	    		}    		
	    		
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally{
	    		this.close();
	    	}
	    	return b;
	    }
	    
	    public boolean addUser(String us,String ps,String em,String g){
	    	boolean b=false;
	    	try{
	    		ct=new ConnDB().getConn();
	    		sm=ct.createStatement();
	    		int a=sm.executeUpdate("insert into userinformation(username,password,email,grade) values('"+us+"','"+ps+"','"+em+"','"+g+"')");
	    		if(a==1){
	    			b=true;
	    		}    		
	    		
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally{
	    		this.close();
	    	}
	    	return b;
	    }
	    public boolean editUser(String id,String us,String ps,String em,String g){
	    	boolean b=false;
	    	try{
	    		ct=new ConnDB().getConn();
	    		sm=ct.createStatement();
	    		int a=sm.executeUpdate("update userinformation set username='"+us+"',password='"+ps+"',email='"+em+"',grade='"+g+"' where userid="+id);
	    		if(a==1){
	    			b=true;
	    		}    		
	    		
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}finally{
	    		this.close();
	    	}
	    	return b;
	    }
	

	public UserBeanCl() {
		// TODO Auto-generated constructor stub
	}

}
