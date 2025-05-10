package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	static final public String NON_VALIDO = "comando non valido";
	IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(NON_VALIDO);
	}

	@Override
	public void setParametro(String parametro) {}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NON_VALIDO;
	}

	@Override
	public String getParametro() {
		return null;
	}
	
}