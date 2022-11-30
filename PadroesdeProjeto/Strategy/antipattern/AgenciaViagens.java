package antipattern;

public class AgenciaViagens {
	
	private String CidadeDestino;
	private String PaisDestino;
	private Integer TempoEstadia;

	
	
	public AgenciaViagens(String cidadeDestino, String paisDestino, Integer tempoEstadia) {
		super();
		CidadeDestino = cidadeDestino;
		PaisDestino = paisDestino;
		TempoEstadia = tempoEstadia;
		
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
	
	@Override
	public String toString() {
		return "AgenciaViagens [totalPacote=" +", CidadeDestino=" + CidadeDestino + ", PaisDestino=" + PaisDestino + ", TempoEstadia="
				+ TempoEstadia + "]";
	}
	public void Pacote() {
		
	}
}

