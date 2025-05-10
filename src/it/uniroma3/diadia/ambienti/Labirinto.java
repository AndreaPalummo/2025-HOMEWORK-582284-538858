package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Labirinto - Classe che modella la mappa di gioco e
 * assegna una stanza iniziale e una vincente alla partita
 *
 * @author Valerio Massimini
 * @see Stanza
 * @version homeworkB
 */

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo grimaldello = new Attrezzo("grimaldello", 1);

		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBloccata("ATRIO", "grimaldello", "nord");
		Stanza aulaN11 = new Stanza("AULA N11");
		Stanza aulaN10 = new StanzaMagica("AULA N10");
		Stanza laboratorio = new StanzaBuia("LABORATORIO CAMPUS", "lanterna");
		Stanza biblioteca = new Stanza("BIBLIOTECA");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		laboratorio.addAttrezzo(grimaldello);
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}
	
	/**
	 * Restituisce la stanza iniziale
	 * @return stanzaIniziale la stanza iniziale del labirinto
	 */

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	/**
	 * Restituisce la stanza vincente
	 * @return stanzaVincente la stanza vincente del labirinto
	 */

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	/**
	 * Imposta la stanza iniziale del labirinto
	 * @param stanzaIniziale la stanza iniziale da settare
	 */
	public void setStanzaIniziale(Stanza stanzaInizale) {
		this.stanzaIniziale = stanzaInizale;
	}
	
	/**
	 * Imposta la stanza vincente del labirinto
	 * @param stanzaVincente la stanza vincente da assettare
	 */
	
	public void setStanzaVincente(Stanza stanzaVincente ) {
		this.stanzaVincente = stanzaVincente;
	}
}