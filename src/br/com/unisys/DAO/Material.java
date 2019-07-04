package br.com.unisys.DAO;

public class Material {
	
	private String fonecedor;
	private String Produto;
	private Float preco;
	private String unidade;
	private String estoque;
	private Integer quantidade;
	private String statusM;
	private String DataVecimento;

	public Material() {
	}
	
	public Material(String produto, Float preco, String dataVecimento) {
		super();
		this.Produto = produto;
		this.preco = preco;
		this.DataVecimento = dataVecimento;
	}

	public Material(String fonecedor, String Produto, Float preco, String unidade, String estoque, Integer quantidade,
			String statusM, String DataVecimento) {
		this.fonecedor = fonecedor;
		this.Produto = Produto;
		this.preco = preco;
		this.unidade = unidade;
		this.estoque = estoque;
		this.quantidade = quantidade;
		this.statusM = statusM;
		this.DataVecimento = DataVecimento;
	}
	
	public String getFonecedor() {
		return fonecedor;
	}

	public void setFonecedor(String fonecedor) {
		this.fonecedor = fonecedor;
	}

	public String getProduto() {
		return Produto;
	}

	public void setProduto(String produto) {
		Produto = produto;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getStatusM() {
		return statusM;
	}

	public void setStatusM(String statusM) {
		this.statusM = statusM;
	}

	public String getDataVecimento() {
		return DataVecimento;
	}

	public void setDataVecimento(String dataVecimento) {
		DataVecimento = dataVecimento;
	}
}
