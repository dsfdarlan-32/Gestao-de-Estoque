package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.BancoDeDados;

public class FornecedorDAO {
	private Connection cn;

	public FornecedorDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	// Metodo para Adicionar objeto na tabela
	public String adicionar(Fornecedor fornecedor) throws SQLException {
		try {
			String sql = "insert into fornecedores (codigoFor,nome) " + "values( ? ,?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNomeFornecedor());
			stmt.setString(2, fornecedor.getCodigoFornecedor());
			stmt.execute();
			return "OK";
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	// Metodo para Pegar objeto da tabela
	public List<Fornecedor> selectFornecedor() throws SQLException {

		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		try {
			String sql = "select * from fornecedores";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				listaFornecedores.add(new Fornecedor(rs.getString("codigoFor"), rs.getString("nome")));
				System.out.println(rs.getString("codigoFor") + " - " + rs.getString("codigoFor"));
			}

		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaFornecedores;
	}
	
	// Metodo para Pegar cod Fornecedor Passado
	public String selectCodFor(String fonecedor )  throws SQLException {
		String codFor="";
		try {
			String sql = "Select codigoFor From fornecedores where nome = '" + fonecedor + "' or codigoFor = '" + fonecedor +"'";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet cod = stmt.executeQuery(sql);
			cod.next();
			codFor = cod.getString("codigoFor");
			return codFor;

		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return codFor;
	}


	public static void main(String[] args) throws SQLException {
		//FornecedorDAO fornecedorDAO = new FornecedorDAO();
		//String teste = fornecedorDAO.selectCodFor("teste");
		System.out.println(11458);
	}

}















