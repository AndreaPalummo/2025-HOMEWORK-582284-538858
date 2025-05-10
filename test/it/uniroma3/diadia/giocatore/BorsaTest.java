package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	Borsa borsone;
	Attrezzo spada;
	Borsa borsetta;
	
	@Before
	public void setUp() {
		borsone = new Borsa();
		spada = new Attrezzo("spada", 3);
		borsetta = new Borsa();
		borsetta.addAttrezzo(spada);
	}
	
	@Test
	public void testIsEmptyTrue() {
		assertTrue(borsone.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		assertFalse(borsetta.isEmpty());
	}
	
	@Test
	public void testHasAttrezzoTrue() {
		assertTrue(borsetta.hasAttrezzo("spada"));
	}
	
	@Test
	public void testHasAttrezzoFalse() {
		assertFalse(borsetta.hasAttrezzo("Sacro Graal"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		borsetta.removeAttrezzo("spada");
		assertFalse(borsetta.hasAttrezzo("spada"));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		assertNull(borsetta.removeAttrezzo("Calice di fuoco"));
	}
	
	@Test 
	public void testGetPeso() {
		assertEquals(3,borsetta.getPeso());
	}
	
	@Test
	public void testAddAttrezzoBorsaNonPiena() {
		assertTrue(borsetta.addAttrezzo(new Attrezzo("ascia", 7)));
	}
	
	@Test
	public void testAddAttrezzoMaxPesoRaggiuntoInBorsa() {
		assertFalse(borsetta.addAttrezzo(new Attrezzo("Martello",8)));
	}
	
	@Test
	public void testAddAttrezzoNumeroMaxAttrezziRaggiuntoInBorsa() {
		Attrezzo a[] = new Attrezzo[Borsa.DEFAULT_NUMERO_ATTREZZI];
		riempiBorsa(a,borsone);
		assertFalse(borsone.addAttrezzo(spada));
	}
	
	/* Creo oggetti e li aggiungo in una borsa */
	public void riempiBorsa(Attrezzo a[], Borsa s) {
		for (int i=0; i<a.length; i++) {
			a[i] = new Attrezzo("",1);
			s.addAttrezzo(a[i]);
		}
	}
}
