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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
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
	
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String course=request.getParameter("course");
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update students set name=? , age=?,course=? where ID=?");
			
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, course);
			ps.setInt(4, id);
			
			int result=ps.executeUpdate();
			if(result > 0) {
				response.getWriter().println("student updated");
			}else {
				response.getWriter().println("student not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
	

