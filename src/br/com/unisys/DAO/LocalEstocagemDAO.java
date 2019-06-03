package br.com.unisys.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import connection.BancoDeDados;

public class LocalEstocagemDAO {
	private Connection cn;

	public LocalEstocagemDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	//Metodo para Adicionar objeto na tabela
	public String adicionar(LocalEstocagem localEstocagem) throws SQLException {
		try {
			
			String sql = "insert into localEstocagem (codLocal,corredor,prateleira,andar,box) " + "values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, localEstocagem.getCodLocal());
			stmt.setString(2, localEstocagem.getCorredor());
			stmt.setString(3, localEstocagem.getPrateleira());
			stmt.setString(4, localEstocagem.getAndar());
			stmt.setString(5, localEstocagem.getBox());
			stmt.execute();
			return "OK";
			
		} catch (Exception e) {
			return e.toString();
		}
	}
}
