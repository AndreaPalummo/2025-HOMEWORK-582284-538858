package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	public final static String BORSA_VUOTA = "Non hai nessun oggetto in borsa.";
	public final static String NO_PARAMETRO = "Che attrezzo vuoi posare? \n"
			+ "Digita: \"prendi\" + \"nome attrezzo\".";
	public final static String ATTREZZO_POSATO = "Attrezzo posato!";
	public final static String ATTREZZO_NON_POSSEDUTO = "Non possiedi questo attrezzo.";
	public final static String SPAZIO_BORSA_RIMANENTE = "Spazio rimanente in borsa: ";
	
	private String attrezzo;
	IO io;
	
	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		/* Borsa vuota */
		if (borsa.isEmpty())
			io.mostraMessaggio(BORSA_VUOTA);
		/* Secondo parametro non inserito */
		else if (attrezzo==null)
			io.mostraMessaggio(NO_PARAMETRO);
		
		/* Secondo parametro inserito e borsa non vuota */
		else {
			Borsa inventario= partita.getGiocatore().getBorsa();		//inventario corrente
			
			/* attrezzo � presente nella borsa */
			if(inventario.hasAttrezzo(attrezzo)) {
				/* poso l'attrezzo */
				partita.getStanzaCorrente().addAttrezzo(inventario.removeAttrezzo(attrezzo));
				io.mostraMessaggio(ATTREZZO_POSATO);
				/* Stampo stato borsa */
				io.mostraMessaggio(SPAZIO_BORSA_RIMANENTE + (Borsa.DEFAULT_PESO_MAX_BORSA-(borsa.getPeso())) + "kg");
			}
			/* attrezzo non � presente nella borsa */
			else io.mostraMessaggio(ATTREZZO_NON_POSSEDUTO);
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
		
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo;
	}
}