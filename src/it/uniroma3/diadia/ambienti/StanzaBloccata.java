package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoDiSblocco;
	
	public StanzaBloccata(String nome, String attrezzo, String direzione) {
		super(nome);
		this.attrezzoDiSblocco = attrezzo;
		this.direzioneBloccata = direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        if (!super.hasAttrezzo(attrezzoDiSblocco) && direzioneBloccata.equals(direzione)) {
        	return this; 
        }
        else 
        	return super.getStanzaAdiacente(direzione);
	}
	
	@Override
    public String getDescrizione() {
        if(!super.hasAttrezzo(attrezzoDiSblocco))
            return "La stanza a "+direzioneBloccata +" � bloccata... "
            		+ "cerca qualcosa per aprirla.\n" + super.getDescrizione();
        return super.getDescrizione();
    }
}
