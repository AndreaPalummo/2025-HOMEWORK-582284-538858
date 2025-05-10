package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Comando "vai": cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */
public class ComandoVai implements Comando {
	public static final String NO_PARAMETRO = "Dove vuoi andare? Digita \"vai\" + \"direzione\".";
	public static final String DIREZIONE_INESISTENTE = "Direzione inesistente";
	private String direzione;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();

		if(this.direzione==null) {
			io.mostraMessaggio(stanzaCorrente.getDescrizione());
			io.mostraMessaggio(NO_PARAMETRO);
		}

		else { 
			Stanza prossimaStanza = null;
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				io.mostraMessaggio(DIREZIONE_INESISTENTE);
			else {
				partita.setStanzaCorrente(prossimaStanza);
				Giocatore giocatore = partita.getGiocatore();
				int cfu = giocatore.getCfu();
				giocatore.setCfu(--cfu);
				io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
				io.mostraMessaggio("Ti sono rimasti " + giocatore.getCfu() + " cfu");
			}
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
}