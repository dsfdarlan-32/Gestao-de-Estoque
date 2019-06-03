package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	
  
  public Connection getConnection() {
	  Connection cn = null;
	  
	  try {
		  
		  Class.forName("com.mysql.jdbc.Driver");

		  String url = "jdbc:mysql://localhost/web2";
		  String username = "darlan"; 
		  String password = "92381534";
		  
		  cn = DriverManager.getConnection(url, username,password);
	
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	 
	  return cn;
 }
	

}
