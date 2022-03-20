package org.acme;


import java.util.List;
import java.util.LinkedList;

public class Model {
	
	private List<Banda> Bandas = new LinkedList<Banda>();

	
	
	public Model() {
		addBanda(new Banda("The Beatles", new Especificacao("Across the Universe", "Quatro", "John Lennon")));
		addBanda(new Banda("Green Day", new Especificacao("Wake Me Up When September Ends", "Tres", "Billie Joe")));
		addBanda(new Banda("Rolling Stones", new Especificacao("(I Can't Get No) Satisfaction", "Quatro", "Mick Jagger")));
		addBanda(new Banda("One Direction", new Especificacao("What Makes You Beautiful", "Quatro", "Harry Styles")));
	}
	
	
	
	public void addBanda(Banda Banda){
		Bandas.add(Banda);
	}
	
	public Banda buscarNome(String Nome){
		for(Banda Banda:Bandas){
			if(Banda.getNome().equals(Nome)) return Banda;
		}
		
		return null;
	}
	
	
	public List<Banda> buscarEspecificacao(Especificacao esp){
		List<Banda> BandasEncontrados = new LinkedList<Banda>();
		
		for(Banda Banda:this.Bandas){
			 if(esp.getBestSong().equals(Banda.getEspc().getBestSong()) || esp.getnumMember().equals(Banda.getEspc().getnumMember()) || esp.getVocalist().equals(Banda.getEspc().getVocalist())) BandasEncontrados.add(Banda);
		}
		
		return BandasEncontrados;
		
	}
	
	
	public List<Banda> buscarBestSong(String bestSong){
		List<Banda> BandasEncontrados = new LinkedList<Banda>();
		for(Banda Banda:Bandas) {
			if(Banda.getEspc().getBestSong().equals(bestSong)) BandasEncontrados.add(Banda);
		}
		return BandasEncontrados;
	}
	
	public List<Banda> buscarNumMember(String numMember){
		List<Banda> BandasEncontrados = new LinkedList<Banda>();
		for(Banda Banda:Bandas) {
			if(Banda.getEspc().getnumMember().equals(numMember)) BandasEncontrados.add(Banda);
		}
		return BandasEncontrados;
	}
	
	public List<Banda> buscarVocalist(String vocalist){
		List<Banda> BandasEncontrados = new LinkedList<Banda>();
		for(Banda Banda:Bandas) {
			if(Banda.getEspc().getVocalist().equals(vocalist)) BandasEncontrados.add(Banda);
		}
		return BandasEncontrados;
	}
	public List<Banda> getBandas(){
		return Bandas;
	}

}
