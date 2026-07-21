import java.sql.Connection;

import com.studentmanagement.DBConnection;

public class TestConnection {

	public static void main(String[] args) {
		Connection con=DBConnection.getConnection();
		if(con!=null) {
			System.out.println("connection successfull");
		}

	}

}
