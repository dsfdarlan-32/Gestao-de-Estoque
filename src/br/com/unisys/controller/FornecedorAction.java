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
	
	
	public void buscaFornecedor() throws SQLException{
		
		
		
		Fornecedor fornecedor = new Fornecedor();
		List<Fornecedor> listaFornecedores = new ArrayList();
		listaFornecedores =  fornecedorDAO.selectFornecedor();
		List<Fornecedor> itListaFornecedores = new ArrayList();
		
		for(int i=0;i<listaFornecedores.size();i++) {
			for(Fornecedor forn: listaFornecedores) {
				itListaFornecedores.add(forn);
				System.out.println(forn.getNomeFornecedor() + forn.getCodigoFornecedor());
			}
		}
		

	//	System.out.println(fornecedor.getNomeFornecedor() + " " + fornecedor.getCodigoFornecedor());

		
	}
	
	
	 public static void main(String[] args) throws SQLException {
		 FornecedorAction fornecedorAction = new FornecedorAction();
		 fornecedorAction.buscaFornecedor();

		}
	
}