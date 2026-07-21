package com.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() {
		
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db",
	                "root",
	                "Admin@123");
			System.out.println("Database connected");
		}catch(Exception e) {
			e.printStackTrace();
			if(con==null) {
				System.out.println("DB CONNECTION FAILED");
			}
		}return con;
	

	}

}
