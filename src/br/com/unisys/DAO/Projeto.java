package br.com.unisys.DAO;

public class Projeto {
	private Integer idProjeto;
	private String nomeProjeto;
	private float valorProjeto;

	public Projeto() {
	}

	public Projeto(Integer idProjeto, String nomeProjeto, float valorProjeto) {
		this.idProjeto = idProjeto;
		this.nomeProjeto = nomeProjeto;
		this.valorProjeto = valorProjeto;
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public float getValorProjeto() {
		return valorProjeto;
	}

	public void setValorProjeto(float valorProjeto) {
		this.valorProjeto = valorProjeto;
	}

}
