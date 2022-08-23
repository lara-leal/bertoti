package antipattern;

public class Main {

	public static void main(String[] args) {
				PacoteNacional pn = new PacoteNacional("Campos do Jordão", "Brasil", 7 , 880.00);
			PacoteInternacional pi = new PacoteInternacional("Paris", "França", 7);
			pn.Pacote();
			pi.Pacote();
		}


	}

