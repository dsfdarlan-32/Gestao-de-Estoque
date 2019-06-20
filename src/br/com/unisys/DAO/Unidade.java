package br.com.unisys.DAO;

public class Unidade {
	private String unidade;
	private String descricao;
	
	public Unidade() {
	}
	
	public Unidade(String unidade, String descricao) {
		this.unidade = unidade;
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
