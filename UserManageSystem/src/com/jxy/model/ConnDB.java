//get connection with database
package com.jxy.model;


import java.sql.*;
public class ConnDB {

	public ConnDB() {
		// TODO Auto-generated constructor stub
	}
	private Connection ct=null;
	public Connection getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user","root","19940119jxy");
		}catch (Exception e){
			e.printStackTrace();
		}
		return ct;
	}

}
