import java.io.IOException;  

public class Main{  
    public static void main(String args[]) throws NumberFormatException, IOException{  
    	
    	LojaDeRoupa loja = new LojaDeRoupa("CLEITON LOJA", "Rua Douglas");
    	Tenis tenis = new Tenis(loja);
    	Vestido vestido = new Vestido(loja);
    	Calca calca = new Calca(loja);
    	tenis.setPrecoTenis();
    	vestido.setPrecoVestido();
    	calca.setPrecoCalca();
        
}  }