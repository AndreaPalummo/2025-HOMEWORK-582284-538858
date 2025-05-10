package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	Stanza stanza;
	Attrezzo attrezzo;
	Stanza stanza2;
	
	@Before
	public void setUp() {
		stanza = new StanzaBloccata("segreteria", "rettore", "nord");
		attrezzo = new Attrezzo("rettore", 70);
		stanza2 = new Stanza("biblioteca");
		stanza.impostaStanzaAdiacente("nord", stanza2);
	}

	@Test
	public void testStanzaAncoraBloccata() {
		assertFalse(stanza2 == stanza.getStanzaAdiacente("nord"));
	}
	
	@Test 
	public void testStanzaSbloccata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanza2,stanza.getStanzaAdiacente("nord"));
	}
}