package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	Partita partita;
	Giocatore player;
	IO io;
	@Before
	public void setUp() {
		io = new IOConsole();
		partita = new Partita(io);
		player = new Giocatore();
		partita.setGiocatore(player);
	}
	
	@Test
	public void testIsFinitaPerMancanzaCfu() {
		player.setCfu(0);
		assertTrue("I cfu del giocatore sono 0", partita.isFinita());
	}
	
	@Test
	public void testIsFinitaTramiteSetFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaFalse() {
		assertFalse("variabile 'finita' di partita � false di default", this.partita.isFinita());
	}
	
	@Test
	public void testVintaAndandoInBiblioteca() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testAncoraNonVinta() {
		assertFalse("per vincere la partita il giocatore deve andare nella biblioteca", partita.vinta());
	}
	
	@Test 
	public void testNonVintaPerMancanzaDiCfu() {
		player.setCfu(0);
		assertFalse(partita.vinta());
	}
}
