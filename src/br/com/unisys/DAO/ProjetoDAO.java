package br.com.unisys.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import connection.BancoDeDados;

public class ProjetoDAO {
	private Connection cn;

	public ProjetoDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	//Metodo para Adicionar objeto na tabela
	public String adicionar(Projeto projeto) throws SQLException {

		try {
			
			String sql = "insert into projetos(nome,valor) " + "values( ? ,?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, projeto.getNomeProjeto());
			stmt.setFloat(2, projeto.getValorProjeto());
			stmt.execute();
			
			return "OK";

		} catch (Exception e) {
		
			return e.toString();

		}
		
	}

}
