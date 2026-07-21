


	import java.sql.Connection;
	import java.sql.DriverManager;

	public class TestDB {
	    public static void main(String[] args) {
	        try {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	            		"jdbc:mysql://localhost:3306/student_db",
	                "root",
	                "Admin@123"
	            );

	            System.out.println("Connection Success");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


