package br.com.unisys.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import br.com.unisys.DAO.FornecedorDAO;
import br.com.unisys.DAO.Material;
import br.com.unisys.DAO.MaterialDAO;

public class MaterialAction {

	MaterialDAO materialDAO = new MaterialDAO();

	public String adicionaMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
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

	public void buscaMatNaoPago() throws SQLException, IOException {
		List<Material> listaMaterial = new ArrayList<Material>();
		listaMaterial = materialDAO.selectMatNaoPago();

		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("/home/darlan/Desktop/Lista de Materias nao Pago.docx"));

		XWPFParagraph paragrafo1 = document.createParagraph();
		XWPFRun runParagrafo1 = paragrafo1.createRun();
		runParagrafo1.setText("Lista de Materiais não Pago");
		runParagrafo1.setBold(true);
		runParagrafo1.addBreak();

		// create table
		XWPFTable table = document.createTable();

		// create first row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Material");
		tableRowOne.addNewTableCell().setText("Preço");
		tableRowOne.addNewTableCell().setText("Data de Vencimento");

		for (Material forn : listaMaterial) {

			// create second row
			XWPFTableRow tableRow = table.createRow();
			tableRow.getCell(0).setText(forn.getProduto());
			tableRow.getCell(1).setText(String.valueOf(forn.getPreco()));
			tableRow.getCell(2).setText(forn.getDataVecimento());
		}

		document.write(out);
		out.close();
		System.out.println("Lista de Materias nao Pago successully");

	}

	public static void main(String[] args) throws SQLException, IOException {
		MaterialAction materialAction = new MaterialAction();
		materialAction.buscaMatNaoPago();
	}

}