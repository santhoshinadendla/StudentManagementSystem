import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.studentmanagement.DBConnection;

public class ReadStudent {

	public static void main(String[] args) {
	
		try {
			Connection con=DBConnection.getConnection();
		 Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM students");
		 
		while(rs.next()) 
		{
			System.out.println(rs.getInt("id")+" "+ rs.getString("name")+" "+rs.getString("course")+" "+rs.getString("age"));
		}con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
