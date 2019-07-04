package br.com.unisys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

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
		float preco = materialDAO.selectPrecoMat(material);
		int quant = materialDAO.selectQuantidadeMat(material);
		if (Integer.parseInt(quantidade) <= quant) {
			projeto = projetoDAO.selectCodPro(projeto);
			aDMProjetos.setProjeto(projeto);
			aDMProjetos.setMaterial(material);
			aDMProjetos.setQuantidade(Integer.parseInt(quantidade));
			aDMProjetos.setEtapaObra(etapaObra);
			aDMProjetos.setPreco(preco * Integer.parseInt(quantidade));
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
	
	public void buscaEtapaObra(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		
		String projeto = request.getParameter("projeto");
		
		List<String> listaEtapaProjeto = new ArrayList<String>();
		listaEtapaProjeto = aDMProjetosDAO.selectEtapasProjeto(projeto);
		
		HashSet<String> uniqueValues = new HashSet<>(listaEtapaProjeto);
		
    	// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("/home/darlan/Desktop/Status projeto.docx"));

		XWPFParagraph paragrafo1 = document.createParagraph();
		XWPFRun runParagrafo1 = paragrafo1.createRun();
		runParagrafo1.setText("Status projeto " + projeto);
		runParagrafo1.setBold(true);
		runParagrafo1.addBreak();

		// create table
		XWPFTable table = document.createTable();

		// create first row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Etapa Obra");
		tableRowOne.addNewTableCell().setText("Preço");
		tableRowOne.addNewTableCell().setText("Porcentagem");
		
		
		
	    for (String value : uniqueValues) {
	    	List<String> listaEtapaProjeto2 = aDMProjetosDAO.selectEtapasProjeto2(projeto, value);
	    	ProjetoDAO projetoDAO = new ProjetoDAO();


				// create second row
				XWPFTableRow tableRow = table.createRow();
				tableRow.getCell(0).setText(value);
				tableRow.getCell(1).setText(listaEtapaProjeto2.get(1));
				float porc = projetoDAO.selectValorPro(projeto);
				System.out.println(porc);
				DecimalFormat df = new DecimalFormat("0.00");
				String porcentagem = df.format(((Float.valueOf(listaEtapaProjeto2.get(1))*100) / porc));
				//tableRow.getCell(1).setText(String.valueOf(500));
				
				tableRow.getCell(2).setText(porcentagem + " %");
			

			


	    }
	    document.write(out);
		out.close();
		System.out.println("Lista de Materias nao Pago successully");
		

	
	}
	
	
	
	
	

	public static void main(String[] args) throws SQLException, IOException {
		ADMProjetosAction materialAction = new ADMProjetosAction();
		//materialAction.buscaEtapaObra();
	}

}