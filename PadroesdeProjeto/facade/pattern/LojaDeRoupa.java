
public class LojaDeRoupa {
	private String nomeLoja;
	private String endereço;
	
	
	public LojaDeRoupa(String nomeLoja, String endereço) {
		super();
		this.nomeLoja = nomeLoja;
		this.endereço = endereço;
	}


	public String getNomeLoja() {
		return nomeLoja;
	}


	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}


	public String getEndereço() {
		return endereço;
	}


	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public void setModelo(String modelo) {
		System.out.println("O modelo é:" + modelo);
	}
	
	public void setPreco(Double preco) {
		System.out.println("O preço é:" + preco);
	}
	
}
