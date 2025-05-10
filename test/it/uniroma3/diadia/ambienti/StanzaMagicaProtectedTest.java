package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtectedTest {
	StanzaMagicaProtected stanza;
	Attrezzo attrezzo;
	Attrezzo[] lista;

	@Before
	public void setUp() {
		this.stanza = new StanzaMagicaProtected("");
		this.attrezzo = new Attrezzo("cappello", 1);
		this.lista = this.stanza.getAttrezzi();
	}

	@Test
	public void testAddAttrezzoUnaVoltaNoMagia() {
		this.stanza.addAttrezzo(attrezzo);
		Attrezzo[] a = stanza.getAttrezzi();
		assertEquals(a[0].toString(), "cappello (1kg)");
	}
	
	@Test
	public void testAddAttrezzoQuattoVolteConMagia() {
		posaAttrezzoQuattroVolte(attrezzo);
	
		assertEquals(lista[0].toString(), "olleppac (2kg)");
	}
	
	@Test
	public void testAddAttrezzoOttoVolteConDoppiaMagia() {
		posaAttrezzoQuattroVolte(attrezzo);
		posaAttrezzoQuattroVolte(lista[0]);		
		
		assertEquals(lista[0].toString(), "cappello (4kg)");
	}
	
	private void posaAttrezzoQuattroVolte(Attrezzo a) {
		for (int i=0; i<4; i++) {
			this.stanza.removeAttrezzo(a);
			this.stanza.addAttrezzo(a);
		}	
	}
}