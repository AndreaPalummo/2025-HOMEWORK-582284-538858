package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza biblioteca;
	Stanza n14;
	Attrezzo libro;
	Attrezzo palaEolica;
	
	@Before
	public void setUp() {
		biblioteca = new Stanza("Biblioteca");
		libro = new Attrezzo("libro",1);
		biblioteca.addAttrezzo(libro);
		n14 = new Stanza("n14");
		biblioteca.impostaStanzaAdiacente("est", n14);
		palaEolica = new Attrezzo("pala eolica", 12500);

	}
	
	@Test
	public void testHasAttrezzoTrue() {
		assertTrue(biblioteca.hasAttrezzo("libro"));
	}
	
	@Test
	public void testHasAttrezzoFalse() {
		assertFalse(biblioteca.hasAttrezzo("balestra"));
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertEquals("n14",biblioteca.getStanzaAdiacente("est").getNome());
	}
	
	@Test
	public void testStanzaAdiacenteNulla() {
		assertNull(biblioteca.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testRimuoviAttrezzoNonPresente(){
		assertFalse(biblioteca.removeAttrezzo(palaEolica));
	}

	@Test
	public void removeAttrezzoStanzaNonVuota() {
		assertTrue(biblioteca.removeAttrezzo(libro));
	}
	
	@Test
	public void addAttrezzoStanzaPiena() {
		Attrezzo a[]= new Attrezzo[Stanza.NUMERO_MASSIMO_ATTREZZI];
		riempiStanza(a, n14);

		assertFalse(n14.addAttrezzo(palaEolica));  
	}

	@Test
	public void addAttrezzoStanzaVuota() {
		assertTrue(n14.addAttrezzo(palaEolica));
	}

	@Test
	public void addAttrezzoStanzaQuasiPiena() {
		Attrezzo a[]= new Attrezzo[Stanza.NUMERO_MASSIMO_ATTREZZI-1];
		riempiStanza(a, n14);
		assertTrue(n14.addAttrezzo(new Attrezzo("scudo", 1)));  
	}

	/* Creo attrezzi e li aggiungo in una stanza */
	public void riempiStanza(Attrezzo a[], Stanza s) {
		for (int i=0; i<a.length; i++) {
			a[i] = new Attrezzo("",1);
			s.addAttrezzo(a[i]);
		}  
	}
}
