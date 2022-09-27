package pattern;

public interface Observable {
	
	public void notifyClients();
	public void addObserver(Observer observer);
	public void addClient();
	
	

}
