package antipattern;

public class PacoteNacional extends AgenciaViagens {
	private Double precoNacional;

	public PacoteNacional(String cidadeDestino, String paisDestino, Integer tempoEstadia, Double precoNacional) {
		super(cidadeDestino, paisDestino, tempoEstadia);
		this.precoNacional = precoNacional;
	
	}

	public Double getPrecoNacional() {
		return precoNacional;
	}

	public void setPrecoNacional(Double precoNacional) {
		this.precoNacional = precoNacional;
	}
	
	@Override
	public void Pacote() {
		System.out.println("O valor do pacote nacional para esse destino é de R$" +(100 + precoNacional));
//		System.out.println( 100 + precoNacional);
 }
}