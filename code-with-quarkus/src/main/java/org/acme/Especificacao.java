package org.acme;
public class Especificacao {

	
	private String bestSong;
	private String numMember;
	private String vocalist;
	
	
	public Especificacao(String bestSong, String numMember, String vocalist){
		this.bestSong = bestSong;
		this.numMember = numMember;
		this.vocalist = vocalist;
	}
	
	public String getBestSong(){
		return bestSong;
	}
	
	public String getnumMember(){
		return numMember;
	}
	
	public String getVocalist(){
		return vocalist;
	}
	
	//delegacao da comparacao de marca, modelo e cor do carro para a classe Especificacao, pois ela eh a dona dos atributos
	public boolean comparar(Especificacao esp){
		System.out.println(esp);
		if(bestSong.equals(esp.bestSong) && numMember.equals(esp.numMember) && vocalist.equals(esp.vocalist)){
			return true;
		} else {
			return false;
		}
	}
	
}
