package it.unitoma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 5;

	private int cfu = CFU_INIZIALI;
	
	private Borsa borsa = new Borsa();
	
	/*Crea un nuovo giocatore*/
	public Giocatore() {}
	
	/*Restituisce il numero di cfu attuali del giocatore*/
	public int getCfu() {
		return this.cfu;
	}

	/*Imposta il numero di cfu del giocatore*/
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	/*Riduce di uno il numero di cfu del giocatore*/
	public void decrementaCfu() {
		this.cfu--;
		
		setCfu(this.cfu);
		
		System.out.println("CFU rimanenti: " + this.cfu);
	}
	
	/*Restituisce la borsa associata al giocatore*/
	public Borsa getBorsa() {
		return this.borsa;
	}
}
