package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe Partita - Questa classe modella una partita del gioco.
 *
 * @author Valerio Massimini
 * @see Stanza
 * @see Labirinto
 * @see Giocatore
 * @version homeworkB
 */

public class Partita {
	
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Giocatore giocatore;
	private IO io;
	private boolean finita;
	
	/**
	 * Crea una partita
	 * 
	 */
	public Partita(IO io){
		this.io = io;
		this.labirinto = new Labirinto();
		this.labirinto.creaStanze();
		this.stanzaCorrente = this.labirinto.getStanzaIniziale();
		this.giocatore = new Giocatore();
		this.finita = false;
		
	}
	
	/**
	 * Imposta la stanza corrente
	 * @param stanzaCorrente la stanza corrente da settare
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * Ritorna la stanza corrente
	 * @return stanzaCorrente la stanza corrente del giocatore
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 * @param finita 
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Imposta il giocatore della partita
	 * @param player il giocatore da impostare come giocatore della partita
	 */
	public void setGiocatore(Giocatore player) {
		this.giocatore = player;
	}
	
	/**
	 * Ritorna il giocatore della partita
	 * @return giocatore il giocatore della partita
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	/**
	 * Imposta il labirinto della partita
	 * @param mappaDiGioco il labirinto da settare come labirinto della partita
	 */
	public void setLabirinto(Labirinto mappaDiGioco) {
		this.labirinto = mappaDiGioco;
	}
	
	/**
	 * Ritorna il labirinto della partita
	 * @return labirinto il labirinto della partita
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * Ritorna la IO Console
	 * @return io la io console
	 */
	public IO getIO() {
		return this.io;
	}
}