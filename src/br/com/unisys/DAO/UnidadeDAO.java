package br.com.unisys.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import connection.BancoDeDados;

public class UnidadeDAO {
	private Connection cn;

	public UnidadeDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	//Metodo para Adicionar objeto na tabela
	public String adicionar(Unidade unidade) throws SQLException {

		try {
			
			String sql = "insert into unidades (tipoUni,descricao) " + "values( ? ,?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, unidade.getUnidade());
			stmt.setString(2, unidade.getDescricao());
			stmt.execute();
			
			return "OK";

		} catch (Exception e) {
		
			return e.toString();

		}
		
	}

}
