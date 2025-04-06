package it.unitoma3.diadia;

import java.util.Scanner;

public class IOConsole {
	
	/*Stampa un messaggio nella console*/
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	/*Legge una riga in input dalla console*/
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}