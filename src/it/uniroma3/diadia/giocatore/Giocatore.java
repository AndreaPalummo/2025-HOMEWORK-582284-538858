package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	/**
	 * Classe Giocatore - Modella un giocatore di un gioco di ruolo.
	 * Un giocatore si muove all'interno del labirinto.
	 * Ha a disposizione dei cfu che tengono conto dei turni di gioco
	 * rimanenti e possiede una borsa che f� da inventario.
	 *
	 * @author Valerio Massimini
	 * @see Borsa
	 * @version homeworkB
	 */
	
	static final public int CFU_INIZIALI = 15;
	
	private int cfu;
	private Borsa borsa;
	
	/**
	 * Crea un giocatore
	 * @param cfu il numero di cfu del giocatore
	 * @param borsa l'inventario del giocatore
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	/**
	 * Metodo che restituisce i cfu del giocatore
	 * @return i cfu del giocatore
	 */
	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Metodo che setta i cfu del giocatore
	 * @param cfu cfu da settare
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	/**
	 * Metodo che restituisce la borsa del giocatore
	 * @return la borsa del giocatore 
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	/**
	 * Metodo che setta la borsa del giocatore
	 * @param borsa la borsa da settare
	 */
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
}
