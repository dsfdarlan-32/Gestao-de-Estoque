package connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
 
import java.sql.SQLException;
 

public class connection {
	
	 public static String status = "Não conectou...";
	 
	 public connection() {
		 
	    }
	 
	 
	//Método de Conexão//
	 
	public static java.sql.Connection getConexaoMySQL() {
	 
	        Connection connection = null;
			return connection;
	}
	
	
	
	
	 

}
