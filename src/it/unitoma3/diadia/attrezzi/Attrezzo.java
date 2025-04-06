package it.unitoma3.diadia.attrezzi;

public class Attrezzo {

	private String nome;
	private int peso;

	/*Crea un nuovo attrezzo con nome e peso specificati*/
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/*Restituise il nome dell'attrezzo*/
	public String getNome() {
		return this.nome;
	}

	/*Restituisce il peso dell'attrezzo*/
	public int getPeso() {
		return this.peso;
	}

	/*Restituisce una descrizione dell'attrezzo*/
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

}