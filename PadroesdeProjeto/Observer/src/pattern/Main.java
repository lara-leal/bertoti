package pattern;
import pattern.Loja;
import pattern.Wishlist;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wishlist wish = new Wishlist("Iphone");
		Loja loja = new Loja("Casas bahia","Iphone", 3.000);
		
	loja.addObserver(wish);
	loja.notifyClients();
	loja.addClient();
	
 }
}