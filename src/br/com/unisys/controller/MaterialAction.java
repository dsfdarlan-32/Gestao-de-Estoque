package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.FornecedorDAO;
import br.com.unisys.DAO.Material;
import br.com.unisys.DAO.MaterialDAO;

public class MaterialAction {
	
	MaterialDAO materialDAO = new MaterialDAO();
	
	public String adicionaMaterial(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
		Material material = new Material();
	    FornecedorDAO fornecedorDAO = new FornecedorDAO();
	  // Captura os dados do formulário.
	    String fonecedor = request.getParameter("fornecedor");
	    String Produto = request.getParameter("produto");
	    String preco = request.getParameter("preco");
	    String unidade = request.getParameter("unidade");
	    String estoque = request.getParameter("estoque");
	    String quantidade = request.getParameter("quantidade");
	    String statusM = request.getParameter("status");
	    String DataVecimento = request.getParameter("data");
	    fonecedor = fornecedorDAO.selectCodFor(fonecedor);
	    material.setFonecedor(fonecedor);
	    material.setProduto(Produto);
	    material.setPreco(Float.parseFloat(preco));
	    material.setUnidade(unidade);
	    material.setEstoque(estoque);
	    material.setQuantidade(Integer.parseInt(quantidade));
	    material.setStatusM(statusM);
	    material.setDataVecimento(DataVecimento);
	    String status = materialDAO.adicionar(material);
	return status; 
	
	}
	
	public List<Material> buscaMaterial() throws SQLException {
		List<Material> listaMaterial = new ArrayList<Material>();
		listaMaterial = materialDAO.selectMaterial();
		return listaMaterial;
	}
	
	public static void main(String[] args) throws SQLException {
		MaterialAction materialAction = new MaterialAction();
		materialAction.buscaMaterial();
	}
	
}