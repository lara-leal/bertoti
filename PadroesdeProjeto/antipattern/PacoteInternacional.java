package antipattern;

public class PacoteInternacional extends AgenciaViagens{

	public PacoteInternacional(String cidadeDestino, String paisDestino, Integer tempoEstadia) {
		super(cidadeDestino, paisDestino, tempoEstadia);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Pacote() {
		System.out.println("Valor do pacote Internacional para esse destino é de R$ 3000");
	}
}