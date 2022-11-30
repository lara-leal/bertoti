public class Tenis {

	private LojaDeRoupa loja = new LojaDeRoupa("CLEITON LOJA", "Rua Douglas");

	public Tenis(LojaDeRoupa loja) {
		super();
		this.loja = loja;
	}

	public LojaDeRoupa getLoja() {
		return loja;
	}

	public void setLoja(LojaDeRoupa loja) {
		this.loja = loja;
	}
	
	public void setModeloTenis() {
		loja.setModelo("Nike dunk low");
	}
	public void setPrecoTenis() {
		loja.setPreco(1500.00);
	}
}
