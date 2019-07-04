package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.BancoDeDados;

public class ProjetoDAO {
	private Connection cn;

	public ProjetoDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	// Metodo para Adicionar objeto na tabela
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

	// Metodo para Pegar objeto da tabela
	public List<Projeto> selectProjeto() throws SQLException {
		List<Projeto> listaProjeto = new ArrayList<Projeto>();
		try {
			String sql = "select * from projetos";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaProjeto.add(new Projeto(rs.getInt("idProjeto"), rs.getString("nome"), rs.getFloat("valor")));
				System.out.println(rs.getInt("idProjeto") + " - " + rs.getString("nome"));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaProjeto;
	}
	
	// Metodo para Pegar cod Projeto Passado
	public String selectCodPro(String projeto )  throws SQLException {
		String codPro="";
		try {
			
			String sql = "Select idProjeto From projetos where nome = '"+ projeto +"' or idProjeto = '"+ projeto + "'";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet cod = stmt.executeQuery(sql);
			cod.next();
			codPro = cod.getString("idProjeto");
			return codPro;

		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return codPro;
	}
	
	// Metodo para Pegar nome Projeto
		public String selectNomePro(int codProd )  throws SQLException {
			String nome="";
			try {
				
				String sql = "Select nome From projetos where idProjeto = '"+ codProd +"'";
				PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
				ResultSet nomePro = stmt.executeQuery(sql);
				nomePro.next();
				nome = nomePro.getString("nome");
				return nome;

			} catch (Exception e) {
				System.out.println("Causa do erro:" + e.getMessage());
			}
			return nome;
		}
		
		// Metodo para Pegar nome Projeto
		public float selectValorPro(String nome )  throws SQLException {
			
			Float valor = (float) 0.0 ;
			try {
				
				String sql = "select valor from projetos Where nome='"+ nome +"'";
				PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
				ResultSet nomePro = stmt.executeQuery(sql);
				nomePro.next();
				valor = nomePro.getFloat("valor");
				return valor;

			} catch (Exception e) {
				System.out.println("Causa do erro:" + e.getMessage());
			}
			return valor;
		}
		
		

	public static void main(String[] args) throws SQLException {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		float teste = projetoDAO.selectValorPro("casa 2");
		System.out.println(teste);
	}

}


















