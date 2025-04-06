package it.unitoma3.diadia.ambienti;

import it.unitoma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	/*Inizia un nuovo labirinto vuoto*/
	public Labirinto() {}
	
	/* Crea la struttura del labirinto con le stanze e le connessioni tra di esse,
	 *  posizionando anche gli attrezzi iniziali.*/
	public void creaStanze() {

    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
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

		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
    }
	
	/*Restituisce la stanza che rappresenta l'obiettivo da raggiungere*/
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	/*Imposta la stanza in cui si trova il giocatore*/
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	/*Restituisce la stanza in cui si trova il giocatore*/
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}
