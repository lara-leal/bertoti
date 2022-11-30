public class Vestido {

	private LojaDeRoupa loja = new LojaDeRoupa("CLEITON LOJA", "Rua Douglas");

	public Vestido(LojaDeRoupa loja) {
		super();
		this.loja = loja;
	}

	public LojaDeRoupa getLoja() {
		return loja;
	}

	public void setLoja(LojaDeRoupa loja) {
		this.loja = loja;
	}
	
	public void setModeloVestido() {
		loja.setModelo("Vestido mid florido");
	}
	public void setPrecoVestido() {
		loja.setPreco(150.00);
	}
}
