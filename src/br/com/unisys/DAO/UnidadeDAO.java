package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	// Metodo para Pegar objeto da tabela
	public List<Unidade> selectUnidade() throws SQLException {
		List<Unidade> listaUnidade= new ArrayList<Unidade>();
		try {
			String sql = "select * from unidades";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaUnidade.add(new Unidade(rs.getString("tipoUni"), rs.getString("descricao")));
				System.out.println(rs.getString("tipoUni") + " - " + rs.getString("descricao"));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaUnidade;
	}
	
	public static void main(String[] args) throws SQLException {
		UnidadeDAO unidadeDAO = new UnidadeDAO();
		unidadeDAO.selectUnidade();
	}
	
	
	

	
	
	
	
	
}
