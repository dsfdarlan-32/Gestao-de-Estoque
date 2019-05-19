package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.Fornecedor;
import br.com.unisys.DAO.FornecedorDAO;

public class FornecedorAction {
	
	
  FornecedorDAO fornecedorDAO = new FornecedorDAO();
	
	
	public String adicionaFornecedor(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException, SQLException{
	  Fornecedor fornecedor = new Fornecedor();
	  // Captura os dados do formulário.
	    String codigoFornecedor = request.getParameter("nomeFornecedor");
	    String nomeFornecedor = request.getParameter("codigoFornecedor");
		fornecedor.setNomeFornecedor(nomeFornecedor);
		fornecedor.setCodigoFornecedor(codigoFornecedor);
		String status =fornecedorDAO.adicionar(fornecedor);
		return status;
	}
}