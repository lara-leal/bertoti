
public class LojaDeRoupa {
	private String nomeLoja;
	private String endere�o;
	
	
	public LojaDeRoupa(String nomeLoja, String endere�o) {
		super();
		this.nomeLoja = nomeLoja;
		this.endere�o = endere�o;
	}


	public String getNomeLoja() {
		return nomeLoja;
	}


	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}


	public String getEndere�o() {
		return endere�o;
	}


	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public void setModelo(String modelo) {
		System.out.println("O modelo �:" + modelo);
	}
	
	public void setPreco(Double preco) {
		System.out.println("O pre�o �:" + preco);
	}
	
}
