package br.com.unisys.DAO;

public class LocalEstocagem {
	private String codLocal;
	private String corredor;
	private String prateleira;
	private String andar;
	private String box;

	public LocalEstocagem() {
	}
	
	public LocalEstocagem(String codLocal, String corredor, String prateleira, String andar, String box) {
		this.codLocal = codLocal;
		this.corredor = corredor;
		this.prateleira = prateleira;
		this.andar = andar;
		this.box = box;
	}

	public String getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(String codLocal) {
		this.codLocal = codLocal;
	}

	public String getCorredor() {
		return corredor;
	}

	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

}
