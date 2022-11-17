public class Vestido implements LojaRoupa{

    
    @Override
    public void modelo(){
        System.out.println("Vestido longo florido");
    };

    @Override
    public void preco(){
        System.out.println("R$ 150");
    };
}