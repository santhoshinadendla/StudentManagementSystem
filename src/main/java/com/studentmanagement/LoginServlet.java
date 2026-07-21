package com.studentmanagement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=request.getParameter("name");
		System.out.println("NAME = "+ name);
        String password=request.getParameter("password");
		System.out.println("PASSWORD = "+password);
		try {
			System.out.println("Entering DB");
			Connection con=DBConnection.getConnection();
			if(con==null) {
				response.getWriter().println("DB Connection failed");
				return;
			}
			String sql="select * from login where username=? and password=?";
			 PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, name);ps.setString(2, password);
			  ResultSet rs= ps.executeQuery();
				if(rs.next()) {
					
					System.out.println("db match");
					request.getSession().setAttribute("username", name);
				
				response.sendRedirect("dashboard.jsp");
				 
				}
				else {
					System.out.println("No Match");
				          response.getWriter().println("invalid username or password");
			
			} 
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().println("Error:"+e.getMessage());
		}
		
		
		
}

	}
	


