package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Comando "aiuto": stampa informazioni di aiuto.
 */
public class ComandoAiuto implements Comando {
	private IO io;
	
	static final public String[] elencoComandi = {
			
			"-guarda:	accedi alla tua posizione e allo stato della borsa",
			"-vai:		vai nella direzione desiderata",
			"-posa:		posa un oggetto dalla borsa", 
			"-prendi:	prendi un oggetto dalla stanza",
			"-aiuto: 	elenco dei comandi",
			"-fine:		termina la partita", 
	};
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("");
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]);

	}
	@Override
	public String getNome() {
	        return "aiuto";
	    }
	 
	@Override
	public void setParametro(String parametro) 	{}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	@Override
	public String getParametro() {
		return null;
	}

}