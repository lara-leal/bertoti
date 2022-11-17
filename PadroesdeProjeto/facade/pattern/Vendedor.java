public class Vendedor {
    private LojaRoupa calca;
    private LojaRoupa vestido;
    private LojaRoupa tenis; 


    public Vendedor(){
        calca = new Calca();
        vestido = new Vestido();
        tenis = new Tenis();
    }

    public void VenderCalca(){
        calca.modelo();
        calca.preco();
    }

    public void VenderVestido(){
        vestido.modelo();
        vestido.preco();
    }
    public void VenderTenis(){
        tenis.modelo();
        tenis.preco();
    }
}
