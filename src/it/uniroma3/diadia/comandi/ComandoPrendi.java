package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/** 
 * Comando "prendi": dato un attrezzo scelto da un giocatore, verifica che 
 * sia presente nella stanza corrente e lo posiziona nella borsa di un 
 * giocatore (se non � piena).
 * 
 * @author Valerio Massimini
 * @version homeworkB
 */

public class ComandoPrendi implements Comando {
	public final static String STANZA_VUOTA = "Nessun attrezzo nella stanza.";
	public final static String NO_PARAMETRO = "Che attrezzo vuoi prendere? "
			+ "\nDigita: \"prendi\" + \"nome attrezzo\".";
	public final static String BORSA_PIENA = "Non hai abbastanza spazio in borsa";
	public final static String SPAZIO_BORSA_RIMANENTE = "Spazio rimanente in borsa: ";
	public final static String ATTREZZO_INESISTENTE = "L'attrezzo non si trova in questa stanza.";
			
	private String attrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getStanzaCorrente(); 		//stanza corrente
		
		if (stanzaCorrente.isEmpty()) {
			io.mostraMessaggio(STANZA_VUOTA);
		} else if (attrezzo==null)
			io.mostraMessaggio(NO_PARAMETRO);
		
		/* Secondo parametro inserito e stanza non vuota */
		else {
			/* attrezzo � presente nella stanza */
			if (stanzaCorrente.hasAttrezzo(attrezzo)) {
				Attrezzo attrezzoDaRimuovere = stanzaCorrente.getAttrezzo(attrezzo);	//attrezzo da prendere dalla stanza
				Borsa borsa = partita.getGiocatore().getBorsa();						//borsa del giocatore
				
				/* borsa piena: non prendo l'attrezzo */
				if ((attrezzoDaRimuovere.getPeso() + borsa.getPeso())>Borsa.DEFAULT_PESO_MAX_BORSA)
					io.mostraMessaggio(BORSA_PIENA);
				/* Borsa non piena: prendo l'attrezzo e lo rimuovo dalla stanza */
				else {
					stanzaCorrente.removeAttrezzo(attrezzoDaRimuovere);
					borsa.addAttrezzo(attrezzoDaRimuovere);
					io.mostraMessaggio("Hai preso l'attrezzo \"" + attrezzoDaRimuovere.getNome() + "\" e l'hai aggiunto all'inventario.");
					io.mostraMessaggio("Spazio rimanente in borsa: " + (Borsa.DEFAULT_PESO_MAX_BORSA - borsa.getPeso()) + "kg"); 
				}	
			}
			/* Attrezzo non presente nella stanza */
			else io.mostraMessaggio(ATTREZZO_INESISTENTE);
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}
}