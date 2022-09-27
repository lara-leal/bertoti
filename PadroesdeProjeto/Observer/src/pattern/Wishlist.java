package pattern;

public class Wishlist implements  Observer{
	
	private Loja loja;
	
	public String produto;

	
	public Wishlist(String produto) {
		this.produto = produto;
		
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}

	@Override
	public void receivedEmail(String str) {
		
	System.out.println("Seu produto adicionado a wishlist está disponível novamente");
		
	}




}
