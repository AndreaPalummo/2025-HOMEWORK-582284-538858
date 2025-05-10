package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	IO io;
	
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}