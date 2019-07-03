package br.com.unisys.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.BancoDeDados;

public class MaterialDAO {
	private Connection cn;

	public MaterialDAO() {
		cn = (Connection) new BancoDeDados().getConnection();
	}

	// Metodo para Adicionar objeto na tabela
	public String adicionar(Material material) throws SQLException {
		try {
			String sql = "insert into Material (fonecedor,Produto,preco,unidade,estoque,quantidade,statusM,DataVecimento) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);

			stmt.setString(1, material.getFonecedor());
			stmt.setString(2, material.getProduto());
			stmt.setFloat(3, material.getPreco());
			stmt.setString(4, material.getUnidade());
			stmt.setString(5, material.getEstoque());
			stmt.setInt(6, material.getQuantidade());
			stmt.setString(7, material.getStatusM());
			stmt.setString(8, material.getDataVecimento());
			stmt.execute();
			return "OK";
		} catch (Exception e) {
			return e.toString();
		}
	}

	// Metodo para Pegar objeto da tabela
	public List<Material> selectMaterial() throws SQLException {
		List<Material> listaMaterial = new ArrayList<Material>();
		try {
			String sql = "select * from Material";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaMaterial.add(new Material(rs.getString("fonecedor"), rs.getString("Produto"), rs.getFloat("preco"),
						rs.getString("unidade"), rs.getString("estoque"), rs.getInt("quantidade"),
						rs.getString("statusM"), rs.getString("DataVecimento")));
				System.out.println(rs.getString("fonecedor") + " - " + rs.getString("quantidade"));
			}
		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return listaMaterial;
	}

	// Metodo para Pegar quantidade material passado
	public int selectQuantidadeMat(String Prod) throws SQLException {
		int quant = 0;
		try {

			String sql = "Select quantidade From Material where Produto = '" + Prod + "'";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet quantMat = stmt.executeQuery(sql);
			quantMat.next();
			quant = quantMat.getInt("quantidade");
			return quant;

		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
		return quant;
	}
	
	// Metodo para atulizar quantidade material 
	public void upadateMaterial(int quant, String nome) throws SQLException {
		try {
			String sql = "UPDATE Material SET quantidade = "+ quant + " where Produto = '"+ nome +"'";
			PreparedStatement stmt = (PreparedStatement) cn.prepareStatement(sql);
			stmt.executeUpdate(sql);
			

		} catch (Exception e) {
			System.out.println("Causa do erro:" + e.getMessage());
		}
	}
	
	
	

	public static void main(String[] args) throws SQLException {
		MaterialDAO MaterialDAO = new MaterialDAO();
		MaterialDAO.upadateMaterial(58 ,"cimento");
		//System.out.println(test);
	}
}
