import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.studentmanagement.DBConnection;

public class UpdateStudent {
	public static void main(String[]args) {
		try {
			Connection con=DBConnection.getConnection();
			String query="UPDATE students SET name=?, age=?, course=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,"ravi kumar");
			ps.setInt(2, 22);
			ps.setString(3, "ECE");
			ps.setInt(4, 12);
			ps.executeUpdate();
		
			System.out.println("student updated");
			con.close();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
