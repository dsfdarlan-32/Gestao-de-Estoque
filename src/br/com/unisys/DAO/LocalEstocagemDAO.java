package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.BancoDeDados;

public class LocalEstocagemDAO {
	private Connection cn;

	public LocalEstocagemDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	// Metodo para Adicionar objeto na tabela
	public String adicionar(LocalEstocagem localEstocagem) throws SQLException {
		try {

			String sql = "insert into localEstocagem (codLocal,corredor,prateleira,andar,box) "
					+ "values(?, ?, ?, ?, ?)";
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

	// Metodo para Pegar objeto da tabela
	public List<LocalEstocagem> selectLocalEstocagem() throws SQLException {
		List<LocalEstocagem> listaLocalEstocagem = new ArrayList<LocalEstocagem>();
		try {
			String sql = "select * from localEstocagem";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaLocalEstocagem.add(new LocalEstocagem(rs.getString("codLocal"), rs.getString("corredor"),
						rs.getString("prateleira"), rs.getString("andar"), rs.getString("box")));
				System.out.println(rs.getString("codLocal") + " - " + rs.getString("corredor"));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaLocalEstocagem;
	}
	
	public static void main(String[] args) throws SQLException {
		LocalEstocagemDAO localEstocagemDAO = new LocalEstocagemDAO();
		localEstocagemDAO.selectLocalEstocagem();
	}
}
