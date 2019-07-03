package br.com.unisys.DAO;

public class ADMProjetos {
	private Integer id_ADMProjetos;
	private String projeto;
	private String material;
	private Integer quantidade;
	private String etapaObra;

	public ADMProjetos() {
	}

	public ADMProjetos(Integer id_ADMProjetos,String projeto, String material, Integer quantidade, String etapaObra) {
		this.id_ADMProjetos = id_ADMProjetos;
		this.projeto = projeto;
		this.material = material;
		this.quantidade = quantidade;
		this.etapaObra = etapaObra;
	}
	
	public Integer getId_ADMProjetos() {
		return id_ADMProjetos;
	}

	public void setId_ADMProjetos(Integer id_ADMProjetos) {
		this.id_ADMProjetos = id_ADMProjetos;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getEtapaObra() {
		return etapaObra;
	}

	public void setEtapaObra(String etapaObra) {
		this.etapaObra = etapaObra;
	}

}
