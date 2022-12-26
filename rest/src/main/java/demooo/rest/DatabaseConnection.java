package demooo.rest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
 public Connection getConnection() throws ClassNotFoundException, SQLException {
	 String un = "root";
		String p = "Vijaykumar@123";
		Class.forName("com.mysql.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/books";
		Connection con = DriverManager.getConnection(url, un, p);
		return con; 
 }
}
