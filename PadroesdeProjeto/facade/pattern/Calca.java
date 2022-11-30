public class Calca {

	private LojaDeRoupa loja = new LojaDeRoupa("CLEITON LOJA", "Rua Douglas");

	public Calca(LojaDeRoupa loja) {
		super();
		this.loja = loja;
	}

	public LojaDeRoupa getLoja() {
		return loja;
	}

	public void setLoja(LojaDeRoupa loja) {
		this.loja = loja;
	}
	
	public void setModeloCalca() {
		loja.setModelo("Calça wide leg");
	}
	public void setPrecoCalca() {
		loja.setPreco(200.00);
	}
}
