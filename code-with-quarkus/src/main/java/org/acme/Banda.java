package org.acme;

public class Banda {

	private String Nome;
	private Especificacao espc;
	
	
	public Banda(String Nome, Especificacao e){
		this.Nome = Nome;
		this.espc = e;
		
	}
	
	public String getNome(){
		return this.Nome;
	}
	
	public Especificacao getEspc(){
		return this.espc;
	}
	
	
}
