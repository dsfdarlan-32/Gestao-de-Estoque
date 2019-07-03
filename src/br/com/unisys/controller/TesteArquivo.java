package br.com.unisys.controller;

import java.util.ArrayList;
import java.util.HashSet;

public class TesteArquivo {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    
    list.add("afirst");
    list.add("first");
    list.add("bsecond");
    
    HashSet<String> uniqueValues = new HashSet<>(list);
    for (String value : uniqueValues) {
      System.out.println(value);
    }
  }
}
