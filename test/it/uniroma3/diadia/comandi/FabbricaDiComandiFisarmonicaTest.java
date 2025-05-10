package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandi factory;
	private Comando comandoDiTest;
	private IO io;
	
	@Before
	public void setUp(){
		factory = new FabbricaDiComandiFisarmonica();
		io = new IOConsole();
	}

	@Test
	public void testComandoFine() {
		comandoDiTest=factory.costruisci("fine",io);
		assertEquals("fine", comandoDiTest.getNome());
	}
	
	@Test
	public void testComandoVai() {
		comandoDiTest = factory.costruisci("vai nord",io);
		assertEquals("vai", comandoDiTest.getNome());
		assertEquals("nord", comandoDiTest.getParametro());
	}
	
	public void testGuarda() {
		comandoDiTest = factory.costruisci("guarda",io);
		assertEquals("guarda", comandoDiTest.getNome());
	}
	
	@Test
	public void testComandoVaiSenzaParametro() {
		comandoDiTest = factory.costruisci("vai",io);
		assertEquals("vai", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	
	@Test
	public void testComandoPrendi() {
		comandoDiTest = factory.costruisci("prendi libro",io);
		assertEquals("prendi", comandoDiTest.getNome());
		assertEquals("libro", comandoDiTest.getParametro());
	}
	
	@Test
	public void testComandoPrendiSenzaParametro() {
		comandoDiTest = factory.costruisci("prendi",io);
		assertEquals("prendi", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		comandoDiTest = factory.costruisci("posa notebook",io);
		assertEquals("posa", comandoDiTest.getNome());
		assertEquals("notebook", comandoDiTest.getParametro());
		
	}
	
	@Test
	public void testComandoPosaSenzaParametro() {
		comandoDiTest = factory.costruisci("posa",io);
		assertEquals("posa", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
		
	}
	
	@Test
	public void testFine() {
		comandoDiTest = factory.costruisci("fine",io);
		assertEquals("fine", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	
	@Test
	public void testAiuto() {
		comandoDiTest = factory.costruisci("aiuto", io);
		assertEquals("aiuto", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	
	@Test
	public void testComandoNonValido() {
		comandoDiTest = factory.costruisci("comando non valido", io);
		assertEquals("comando non valido", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
}