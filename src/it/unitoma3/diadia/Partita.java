package it.unitoma3.diadia;

import it.unitoma3.diadia.ambienti.Labirinto;
import it.unitoma3.diadia.giocatore.Giocatore;

public class Partita {

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	/*Inizia una nuova partita creando un labirinto e un giocatore*/
	public Partita(){
		this.labirinto = new Labirinto();
		this.labirinto.creaStanze();
		this.giocatore = new Giocatore();
		this.finita = false;
	}

	/*Verifica se la partita è stata vinta*/
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente().getNome().equals(this.labirinto.getStanzaVincente().getNome());
	}

	/*Verifica se la partita è terminata*/
	public boolean isFinita() {
		return this.finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/*Imposta lo stato della partita come terminata*/
	public void setFinita() {
		this.finita = true;
	}

	/*Restituisce il riferimento al labirinto della partita*/
	public Labirinto getLabirinto() {
		return this.labirinto;
	}	
	
	/*Restituisce il riferimento al giocatore della partita*/
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
}
