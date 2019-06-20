package br.com.unisys.DAO;

public class Fornecedor {
	public String nomeFornecedor;
	public String codigoFornecedor;

	public Fornecedor() {
	}

	public Fornecedor(String codigoFornecedor, String nomeFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
}
