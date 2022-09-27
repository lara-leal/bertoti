package pattern;

import java.util.ArrayList;
import java.util.List;

public class Loja implements Observable{
	
	
	private List<Observer> observers = new ArrayList<>();
	public String nomeLoja;
	public String produto;
	public Double preco;
	
	public Loja(String nomeLoja, String produto, Double preco) {
		super();
		this.nomeLoja = nomeLoja;
		this.produto = produto;
		this.preco = preco;
	}
	
	
	public List<Observer> getObservers() {
		return observers;
	}


	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
	
	
	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}


	@Override
	public void notifyClients() {
		for(Observer obs: observers ) {
			obs.receivedEmail(produto);
			
		}	
	}


	@Override
	public void addClient() {
		
		System.out.println("Cliente foi adicionado");
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		// TODO Auto-generated method stub
		
	}	
	
		
	
	
}
