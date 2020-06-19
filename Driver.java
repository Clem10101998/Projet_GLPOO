package connect;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Connection?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from client");
			//?useSSL=false&serverTimezone=UTC
			while (myRs.next()) {
				System.out.println(myRs.getString("firstname") + " " + myRs.getString("username"));
			}
			
		}catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
