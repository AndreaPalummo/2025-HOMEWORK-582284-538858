package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Borsa - Classe che modella l'inventario di un giocatore.
 * Una borsa pu� contenere attrezzi fintanto che non � piena.
 * @author Valerio Massimini
 * @see Attrezzo, Giocatore
 * @version homeworkB
 */

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	public final static int DEFAULT_NUMERO_ATTREZZI = 10;
	
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	/**
	 * Crea una borsa di capienza massima
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	 * Crea una borsa che pu� contenere attrezzi
	 * @param pesoMax capienza della borsa
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[DEFAULT_NUMERO_ATTREZZI]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge un attrezzo nella borsa se non ha gi� raggiunto la capienza massima
	 * @param attrezzo attrezzo da aggiungere in borsa
	 * @return true se l'attrezzo � stato aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null || this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==DEFAULT_NUMERO_ATTREZZI)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Ritorna la capienza massima della borsa (in peso)
	 * @return pesoMax la capienza massima della borsa
	 */
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Prende in ingresso il nome di un attrezzo in formato stringa e restituisce 
	 * l'attrezzo corrispondente se esistente
	 * @param nomeAttrezzo il nome dell'attrezzo da restituire
	 * @return a l'attrezzo corrispondente alla stringa, null se non esiste corrispondenza
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
	
	/**
	 * ritorna il peso corrente della borsa occupato dagli attrezzi
	 * @return peso il peso della borsa
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	/**
	 * Controlla se la borsa � vuota
	 * @return true se la borsa � vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Controlla se un attrezzo � presente in borsa
	 * @param nomeAttrezzo nome dell'attrezzo da cercare
	 * @return true se l'attrezzo � presente, false altrimenti
	 */
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa
	 * @param nomeAttrezzo nome dell'attrezzo da rimuovere
	 * @return a attrezzo rimosso, null se l'attrezzo da rimuovere non esiste
	 */

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo != null && hasAttrezzo(nomeAttrezzo)) {
			for (int i=0; i<this.numeroAttrezzi; i++) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					a=this.attrezzi[i];
					for (int j=i; j<this.numeroAttrezzi-1; j++) {
						this.attrezzi[j]=this.attrezzi[j+1];
					}
					this.numeroAttrezzi--;
				}
			}
		}
		return a;
	}
	
	/**
     * Restituisce la collezione di attrezzi presenti nella borsa.
     * @return la collezione di attrezzi nella borsa.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }
    
    /**
     * Restituisce una descrizione dello stato della borsa in formato stringa
     */
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa: borsa vuota");
		return s.toString();
	}
}