package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String nomeAttrezzoLucente;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.nomeAttrezzoLucente= attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!hasAttrezzo(nomeAttrezzoLucente))
			return "qui c'� un buio pesto...";
		else return super.toString();
    }
}
