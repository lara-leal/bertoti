package strategypattern;

public class ComprarViagem {

	public static void main(String[] args) {
		AgenciaViagens av = new AgenciaViagens();
		av.setPacote(new pacoteInternacional());
		av.VerPacote();
	}

}
