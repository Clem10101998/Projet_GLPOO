package connect;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sign?useSSL=false&serverTimezone=UTC", "root", "Clement1998");
			Statement Stmt = Conn.createStatement();
			ResultSet Rs = Stmt.executeQuery("select * from connection");
			//?useSSL=false&serverTimezone=UTC
			while (Rs.next()) {
				System.out.println(Rs.getString("firstname") + " " + Rs.getString("lastname"));
			}
			}catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
