package com.studentmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String course = request.getParameter("course");
		try {
			Connection con =DBConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO students (id,name,age,course)VALUES(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2,name);
			ps.setInt(3, Integer.parseInt(age));
			ps.setString(4, course);
			int result = ps.executeUpdate();
			
			if(result > 0) {
				response.getWriter().println("student added successfully");
			} else {
				response.getWriter().println("Failed to add student");
			}
			 ps.close();
			 con.close();
			 
		
		}catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("error:"+e.getMessage());
		}
		
		
	}

}
