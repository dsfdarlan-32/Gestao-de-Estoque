package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			String sql = "insert into ADMProjetos (projeto,material,quantidade,etapaObra) "
					+ "values(?, ?, ?, ?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, aDMProjetos.getProjeto());
			stmt.setString(2, aDMProjetos.getMaterial());
			stmt.setInt(3, aDMProjetos.getQuantidade());
			stmt.setString(4, aDMProjetos.getEtapaObra());
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
				listaADMProjetos.add(new ADMProjetos(rs.getInt("id_ADMProjetos"), rs.getString("projeto"), rs.getString("material"),rs.getInt("quantidade"), rs.getString("etapaObra")));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaADMProjetos;
	}

	public static void main(String[] args) throws SQLException {
		ADMProjetosDAO localEstocagemDAO = new ADMProjetosDAO();
		localEstocagemDAO.selectDMProjetos();
	}
}
