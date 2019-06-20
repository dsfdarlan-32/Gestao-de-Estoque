package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.Fornecedor;
import br.com.unisys.DAO.FornecedorDAO;
import javax.ws.rs.Path;

@Path("FornecedorAction")
public class FornecedorAction {

	FornecedorDAO fornecedorDAO = new FornecedorDAO();

	public String adicionaFornecedor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Fornecedor fornecedor = new Fornecedor();
		// Captura os dados do formulário.
		String codigoFornecedor = request.getParameter("nomeFornecedor");
		String nomeFornecedor = request.getParameter("codigoFornecedor");
		fornecedor.setNomeFornecedor(nomeFornecedor);
		fornecedor.setCodigoFornecedor(codigoFornecedor);
		String status = fornecedorDAO.adicionar(fornecedor);
		return status;
	}

	public List<Fornecedor> buscaFornecedor() throws SQLException {
		List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
		listaFornecedores = fornecedorDAO.selectFornecedor();
		return listaFornecedores;
	}

	public static void main(String[] args) throws SQLException {
		FornecedorAction FornecedorAction = new FornecedorAction();
		FornecedorAction.buscaFornecedor();
	}

}