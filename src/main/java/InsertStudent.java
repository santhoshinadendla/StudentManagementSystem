import java.sql.Connection;
import java.sql.PreparedStatement;

import com.studentmanagement.DBConnection;

public class InsertStudent {

	public static void main(String[] args) {
		try {
			Connection con=DBConnection.getConnection();
			String query = "INSERT INTO students(name,age,course)VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "ravi");
			ps.setInt(2, 21);
			ps.setString(3, "CSE");
			ps.executeUpdate();
			
			
			
			
			ps.setString(1, "sai");
			ps.setInt(2, 25);
			ps.setString(3, "EEE");
			ps.executeUpdate();
			
			
			
			ps.setString(1, "kishore");
			ps.setInt(2, 24);
			ps.setString(3, "AIML");
			ps.executeUpdate();
			
			
	
			System.out.println("Student inserted");
			
			
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

}
