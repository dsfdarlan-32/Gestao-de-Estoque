package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.Unidade;
import br.com.unisys.DAO.UnidadeDAO;

public class UnidadeAction {
	
	UnidadeDAO unidadeDAO = new UnidadeDAO();
	
	
	public String adicionaUnidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		Unidade unidade = new Unidade();
	  // Captura os dados do formulário.
	    String unidade1 = request.getParameter("unidade");
	    String descricao = request.getParameter("descricao");
	    unidade.setUnidade(unidade1);
	    unidade.setDescricao(descricao);
		String status = unidadeDAO.adicionar(unidade);
		return status;
	}
	
	public List<Unidade> buscaUnidade() throws SQLException {
		List<Unidade> listaUnidade = new ArrayList<Unidade>();
		listaUnidade = unidadeDAO.selectUnidade();
		return listaUnidade;
	}
	
	public static void main(String[] args) throws SQLException {
		UnidadeAction unidadeAction = new UnidadeAction();
		unidadeAction.buscaUnidade();
	}
	
}