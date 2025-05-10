package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	Labirinto labirinto;
	Labirinto labirinto2;
	@Before
	public void setUp() {
		labirinto = new Labirinto();
		labirinto2 = new Labirinto();
		labirinto.setStanzaVincente(new Stanza("bar"));
		labirinto.setStanzaIniziale(new Stanza("n18"));
	}
	

	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("bar",labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaVincenteDiversaDaQuellaIniziale() {
		assertNotEquals(labirinto.getStanzaIniziale().getNome(),labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testLabirintoVuoto() {
		assertNull(labirinto2.getStanzaIniziale());
	}
	
	@Test
	public void testLabirintoNonVuoto() {
		assertEquals("n18", labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testLabirintoVuotoSenzaStanzaVincente() {
		assertEquals(null,labirinto2.getStanzaVincente());
	}
}
