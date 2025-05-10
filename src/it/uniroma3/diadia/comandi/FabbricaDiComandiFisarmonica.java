package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	@Override
	public Comando costruisci(String nomeComando, IO io) {
		Scanner scanner = new Scanner(nomeComando);
		String nomeComandoDaEseguire = null;
		String parametro = null;
		Comando comando = null;
		
		if(scanner.hasNext())
			nomeComandoDaEseguire = scanner.next();		//prima parola del comando
		if(scanner.hasNext())
			parametro = scanner.next();					//seconda parola del comando
		
		if (nomeComandoDaEseguire == null)
			comando = new ComandoNonValido();
		
		else if (nomeComandoDaEseguire.equalsIgnoreCase("vai"))
			comando = new ComandoVai();
		
		else if (nomeComandoDaEseguire.equalsIgnoreCase("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComandoDaEseguire.equalsIgnoreCase("posa"))
			comando = new ComandoPosa();
		
		else if (nomeComandoDaEseguire.equalsIgnoreCase("aiuto"))
			comando = new ComandoAiuto();
		
		else if (nomeComandoDaEseguire.equalsIgnoreCase("fine"))
			comando = new ComandoFine();
		
		else if (nomeComandoDaEseguire.equalsIgnoreCase("guarda"))
			comando = new ComandoGuarda();
		else
			comando = new ComandoNonValido();
		
		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;
	}

}