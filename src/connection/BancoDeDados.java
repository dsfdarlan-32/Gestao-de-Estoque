package connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

 
public class BancoDeDados {
  
  protected Connection connection = null;
  protected Statement statement = null;
  protected ResultSet resultSet =  null;
  
  public void conectar () {
    String servidor = "jdbc:mysql://127.0.0.1:3306/meubanco";
    String usuario = "Darlan";
    String senha = "";
    String driver = "com.mysql.jdbc.Driver";
    
    try {
      Class.forName(driver);
      this.connection = (Connection) DriverManager.getConnection(servidor,usuario,senha);
      this.statement = (Statement) this.connection.createStatement();
      
    }catch(Exception e){
      System.out.println("Erro: " + e.getMessage());        
    }  
    
  }

  public boolean statusConexao(){
    
    if(this.connection != null){
      return true;
      
    }else {
      
    return false;
    }
    
  }
	 

}
