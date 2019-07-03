package br.com.unisys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import br.com.unisys.DAO.Material;

public class TesteArquivo4 {
  public static void main(String[] args) throws IOException {
    
    List <Material> mat= new  ArrayList<Material>();


      Material mat1= new  Material();
      mat1.setProduto("Produto 1");
      mat1.setQuantidade(50);
      mat.add(mat1);
  
      Material mat2= new  Material();
      mat2.setProduto("Produto 2");
      mat2.setQuantidade(100);
      mat.add(mat2);
      
      Material mat3= new  Material();
      mat3.setProduto("Produto 1");
      mat3.setQuantidade(100);
      mat.add(mat3);
      
      Material mat4= new  Material();
      mat4.setProduto("Produto 2");
      mat4.setQuantidade(50);
      mat.add(mat4);
      
      Material mat5= new  Material();
      mat5.setProduto("Produto 3");
      mat5.setQuantidade(35);
      mat.add(mat5);
    
    
    
    //Blank Document
    XWPFDocument document = new XWPFDocument();
      
    //Write the Document in file system
    FileOutputStream out = new FileOutputStream(new File("create_table.docx"));
    
    XWPFParagraph paragrafo1 = document.createParagraph();
    XWPFRun runParagrafo1 = paragrafo1.createRun();
    runParagrafo1.setText("Teste programinha título 1");
    runParagrafo1.setBold(true);
    runParagrafo1.addBreak();
    
    //create table
    XWPFTable table = document.createTable();
    
    //create first row
    XWPFTableRow tableRowOne = table.getRow(0);
    tableRowOne.getCell(0).setText("Material");
    tableRowOne.addNewTableCell().setText("Data de Vencimento");
    
    for(Material forn : mat ) {
      
    //create second row
      XWPFTableRow tableRow = table.createRow();
      tableRow.getCell(0).setText(forn.getProduto());
      tableRow.getCell(1).setText(forn.getDataVecimento());
      
    }

    document.write(out);
    out.close();
    System.out.println("create_table.docx written successully");
    
  }
}
