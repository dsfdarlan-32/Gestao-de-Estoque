package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.Fornecedor;
import br.com.unisys.DAO.FornecedorDAO;

public class FornecedorAction extends HttpServlet{
	
	private static final long serialVersionUID = -6359616861621683724L;
	
  FornecedorDAO fornecedorDAO = new FornecedorDAO();
	
	
	public void adicionaFornecedor(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException, SQLException{
	  Fornecedor fornecedor = new Fornecedor();
	  // Captura os dados do formulário.
    String codigoFornecedor = request.getParameter("nome");
    String nomeFornecedor = request.getParameter("codigo");
		fornecedor.setNomeFornecedor(nomeFornecedor);
		fornecedor.setCodigoFornecedor(codigoFornecedor);
		fornecedorDAO.adicionar(fornecedor);

	}
}