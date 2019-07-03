package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.ADMProjetos;
import br.com.unisys.DAO.ADMProjetosDAO;
import br.com.unisys.DAO.FornecedorDAO;
import br.com.unisys.DAO.Material;
import br.com.unisys.DAO.MaterialDAO;
import br.com.unisys.DAO.ProjetoDAO;

public class ADMProjetosAction {

	ADMProjetosDAO aDMProjetosDAO = new ADMProjetosDAO();
	MaterialDAO materialDAO = new MaterialDAO();

	public String adicionaMaterais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		ADMProjetos aDMProjetos = new ADMProjetos();
		ProjetoDAO projetoDAO = new ProjetoDAO();
		// Captura os dados do formulário.
		String projeto = request.getParameter("projeto");
		String material = request.getParameter("material");
		String quantidade = request.getParameter("quantidade");
		String etapaObra = request.getParameter("etapaObra");
		int quant = materialDAO.selectQuantidadeMat(material);
		if (Integer.parseInt(quantidade) <= quant) {
			projeto = projetoDAO.selectCodPro(projeto);
			aDMProjetos.setProjeto(projeto);
			aDMProjetos.setMaterial(material);
			aDMProjetos.setQuantidade(Integer.parseInt(quantidade));
			aDMProjetos.setEtapaObra(etapaObra);
			materialDAO.upadateMaterial((quant - Integer.parseInt(quantidade)), material);
			return aDMProjetosDAO.adicionar(aDMProjetos);
		} else {
			return "Quantidade de mateial maior que a cadastrada em estoque";
		}
	}		

	public String SelectNome(int cod) throws SQLException {
		ProjetoDAO projetoDAO = new ProjetoDAO();

		String nome = projetoDAO.selectNomePro(cod);
		return nome;
	}

	public List<ADMProjetos> buscaADMProjetos() throws SQLException {
		List<ADMProjetos> listaADMProjetos = new ArrayList<ADMProjetos>();
		listaADMProjetos = aDMProjetosDAO.selectDMProjetos();
		return listaADMProjetos;
	}

	public static void main(String[] args) throws SQLException {
		ADMProjetosAction materialAction = new ADMProjetosAction();
		materialAction.buscaADMProjetos();
	}

}