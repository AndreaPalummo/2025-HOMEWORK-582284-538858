package it.unitoma3.diadia.giocatore;

import it.unitoma3.diadia.ambienti.Stanza;
import it.unitoma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	private Stanza stanza;

	/*Crea una bosrsa con peso massimo predefinito*/
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	/*Crea una borsa con peso massimo personalizzato*/
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}

	/*Aggiunge un attrezzo alla borsa*/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		if (this.numeroAttrezzi==10)
			return false;
		
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	/*Restituisce il peso massimo che la borsa può contenere*/
	public int getPesoMax() {
		return this.pesoMax;
	}

	/*Cerca e restituisce un attrezzo della borsa*/
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}

	/*Calcola e restituisce la somma del peso degli attrezzi nella borsa*/
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	/*Verifica se la borsa è vuota*/
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/*Verifica se un attrezzo è presente nella borsa*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/*Rimuove un attrezzo dalla borsa*/
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i = 0; i < this.numeroAttrezzi; i++) {
			if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				for(int j = i + 1; j <this.numeroAttrezzi; j++) {
					attrezzi[j - 1] = attrezzi[j];
				}
				
				attrezzi[this.numeroAttrezzi - 1] = null;
				this.numeroAttrezzi--;
				
				break;
			}
		}
		return a;
	}
	
	/*Restituisce una descrizione della borsa e del suo contenuto*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	/*Restituisce la stanza associata alla borsa*/
	public Stanza getStanza() {
		return stanza;
	}

	/*Associa una stanza alla borsa*/
	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}
}