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

public class TesteArquivo2 {
  public static void main(String[] args) throws IOException {
    
    List <Material> mat= new  ArrayList<Material>();

    for(int i=1 ; i<=10 ; i++) {
      Material mat2= new  Material();
      mat2.setProduto("Produto " + i);
      mat2.setDataVecimento("0"+i +"/07/2019");
      mat.add(mat2);
    }
    
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
