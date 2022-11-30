package pattern;

public class TabuleiroXadrez {

    static private TabuleiroXadrez instance = null;
    
    private TabuleiroXadrez(){}
    
    static TabuleiroXadrez getInstance()
    {
    	if( instance == null)
           instance = new TabuleiroXadrez();
        return instance;
    }  
}
