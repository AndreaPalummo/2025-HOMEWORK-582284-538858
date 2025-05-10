package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author Valerio Massimini
 *                
 * @version homeworkB
 */

public class DiaDia {
	
	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'�?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chiss�!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	private Partita partita;
	private IO io;
	
	public DiaDia(IO io) {
		this.partita = new Partita(io);
		this.io = io;
	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione � eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		Comando comandoDaEseguire= factory.costruisci(istruzione, partita.getIO());
		comandoDaEseguire.esegui(partita);
		
		if (this.partita.vinta())
			io.mostraMessaggio("\nHai vinto!");
		else if (this.partita.getGiocatore().getCfu() == 0)
			io.mostraMessaggio("\nGame Over: hai terminato i cfu.");
		
		return this.partita.isFinita();
	}
	
	public Partita getPartita() {
		return this.partita;
	}
		  
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}