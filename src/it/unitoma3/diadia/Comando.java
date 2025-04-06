package it.unitoma3.diadia;
import java.util.Scanner;

public class Comando {

    private String nome;
    private String parametro;
    
    /*Analizza la stringa in input e la divide in nome e paramentro associato ad esso*/
    public Comando(String istruzione) {
    	Scanner scannerDiParole = new Scanner(istruzione);

		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
    }
    
    /*Restituisce il nome del comando*/
    public String getNome() {
        return this.nome;
    }

    /*Restituisce il paramentro associato al comando*/
    public String getParametro() {
        return this.parametro;
    }

    /*Verifica che il comando sia valido*/
    public boolean sconosciuto() {
        return (this.nome == null);
    }
}