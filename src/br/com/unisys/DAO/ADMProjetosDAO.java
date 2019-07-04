package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.BancoDeDados;

public class ADMProjetosDAO {
	private Connection cn;

	public ADMProjetosDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	// Metodo para Adicionar objeto na tabela
	public String adicionar(ADMProjetos aDMProjetos) throws SQLException {
		try {
			String sql = "insert into ADMProjetos (projeto,material,quantidade,etapaObra, preco) "
					+ "values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, aDMProjetos.getProjeto());
			stmt.setString(2, aDMProjetos.getMaterial());
			stmt.setInt(3, aDMProjetos.getQuantidade());
			stmt.setString(4, aDMProjetos.getEtapaObra());
			stmt.setFloat(5,aDMProjetos.getPreco());
			System.out.println();
			stmt.execute();
			return "OK";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// Metodo para Pegar objeto da tabela
	public List<ADMProjetos> selectDMProjetos() throws SQLException {
		List<ADMProjetos> listaADMProjetos = new ArrayList<ADMProjetos>();
		try {
			String sql = "select * from ADMProjetos";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaADMProjetos.add(
						new ADMProjetos(rs.getInt("id_ADMProjetos"), rs.getString("projeto"), rs.getString("material"),
								rs.getInt("quantidade"), rs.getString("etapaObra"), rs.getFloat("preco")));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro 1 :" + e.getMessage());
		}
		return listaADMProjetos;
	}
	
	// Metodo para Pegar etapas obra da tabela passada
	public List<String> selectEtapasProjeto(String projeto) throws SQLException {
		List<String> listaEtapa = new ArrayList<String>();
		try {
			ProjetoDAO projetoDAO = new ProjetoDAO();
			String projeto2 = projetoDAO.selectCodPro(projeto);
			
			String sql = "Select etapaObra From ADMProjetos Where projeto = '"+ projeto2 +"'";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaEtapa.add(rs.getString("etapaObra"));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaEtapa;
	}
	
	// Metodo para Pegar etapas obra da tabela passada
	public List<String> selectEtapasProjeto2(String projeto, String EtapaObra) throws SQLException {
		List<String> listaEtapa = new ArrayList<String>();
		try {
			ProjetoDAO projetoDAO = new ProjetoDAO();
			String projeto2 = projetoDAO.selectCodPro(projeto);
			
			String sql = "Select etapaObra, sum(preco) As preco  From ADMProjetos Where projeto = '"+ projeto2 +"' and etapaObra = '"+ EtapaObra +"' GROUP BY etapaObra;";
			
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaEtapa.add(rs.getString("etapaObra"));
				listaEtapa.add(rs.getString("preco"));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaEtapa;
	}
	
	

	public static void main(String[] args) throws SQLException {
		ADMProjetosDAO localEstocagemDAO = new ADMProjetosDAO();
//		localEstocagemDAO.selectDMProjetos();
		List<String> listaEtapa = new ArrayList<String>();
		listaEtapa = localEstocagemDAO.selectEtapasProjeto2("Casa 2", "meio");
		 HashSet<String> uniqueValues = new HashSet<>(listaEtapa);
		    for (String value : uniqueValues) {
		      System.out.println(value);
		    }
	}
}
