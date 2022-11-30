package strategypattern;

public class AgenciaViagens {

	private String CidadeDestino;
	private String PaisDestino;
	private Integer TempoEstadia;
	private Double preco;
	
	private Pacote pacote;
	
	public AgenciaViagens(String cidadeDestino, String paisDestino, Integer tempoEstadia, Double preco, Pacote pacote) {
		this.CidadeDestino = cidadeDestino;
		this.PaisDestino = paisDestino;
		this.TempoEstadia = tempoEstadia;
		this.pacote = pacote;
	}
	public AgenciaViagens() {
		// TODO Auto-generated constructor stub
	}
	public String getCidadeDestino() {
		return CidadeDestino;
	}
	public void setCidadeDestino(String cidadeDestino) {
		CidadeDestino = cidadeDestino;
	}
	public String getPaisDestino() {
		return PaisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		PaisDestino = paisDestino;
	}
	public Integer getTempoEstadia() {
		return TempoEstadia;
	}
	public void setTempoEstadia(Integer tempoEstadia) {
		TempoEstadia = tempoEstadia;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	public void VerPacote() {
		this.pacote.pacote();
	}
}
	
	

