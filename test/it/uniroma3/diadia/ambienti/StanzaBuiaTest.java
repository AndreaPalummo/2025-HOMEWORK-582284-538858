package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	Stanza stanza;
	Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		stanza = new StanzaBuia("BatCaverna","pipistrello");
		attrezzo = new Attrezzo("pipistrello", 2);
	}
	
	@Test
	public void testNonSiVede() {
		assertEquals("qui c'� un buio pesto...", stanza.getDescrizione());
	}
	
	@Test
	public void testStanzaIlluminata() {
		stanza.addAttrezzo(attrezzo);
		assertFalse("qui c'� un buio pesto..." == stanza.getDescrizione());
	}
}