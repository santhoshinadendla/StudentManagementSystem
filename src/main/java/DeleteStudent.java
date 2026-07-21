import java.sql.Connection;
import java.sql.PreparedStatement;

import com.studentmanagement.DBConnection;

public class DeleteStudent {

	public static void main(String[] args) {
		try {
			Connection con= DBConnection.getConnection();
			String query="DELETE FROM students WHERE id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, 12);
			ps.executeUpdate();
			System.out.println("student deleted");
			
			con.close();
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
