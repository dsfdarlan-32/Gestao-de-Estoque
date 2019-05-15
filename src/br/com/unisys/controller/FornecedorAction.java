package br.com.unisys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.Fornecedor;

public class FornecedorAction extends HttpServlet{
	
	private static final long serialVersionUID = -6359616861621683724L;
	Fornecedor fornecedor = new Fornecedor();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Captura os dados do formulário.
		String codigoFornecedor = request.getParameter("txtUsuario");
		String nomeFornecedor = request.getParameter("txtSenha");

		fornecedor.setCodigoFornecedor(codigoFornecedor);
		fornecedor.setNomeFornecedor(nomeFornecedor);
		

		}
	
	public void adicionaFornecedor() {
		
		

		

	}
}