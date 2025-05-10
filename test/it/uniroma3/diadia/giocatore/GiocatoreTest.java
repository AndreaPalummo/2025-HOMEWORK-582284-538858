package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {

    private Giocatore giocatore;
    
    @Before
    public void setUp() {
        this.giocatore = new Giocatore();
    }
    
    @Test
    public void testCfuInizialiNonNulli() {
        assertNotNull(giocatore.getCfu());
    }
    
    @Test
    public void testCfuInizialiCoretti() {
        assertEquals(Giocatore.CFU_INIZIALI, giocatore.getCfu());
    }
    
    @Test
    public void testSetCfu() {
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu());
    }
    
    @Test
    public void testBorsaInizialeNonNulla() {
        assertNotNull(giocatore.getBorsa());
    }
    
    @Test
    public void testBorsaInizialeVuota() {
        assertTrue(giocatore.getBorsa().isEmpty());
    }
    
    @Test
    public void testBorsaInizialeZeroPeso() {
        assertEquals(0, giocatore.getBorsa().getPeso());
    }
    
    @Test
    public void testSetBorsa() {
        Borsa nuovaBorsa = new Borsa();
        Attrezzo attrezzo = new Attrezzo("libro", 2);
        nuovaBorsa.addAttrezzo(attrezzo);
        
        giocatore.setBorsa(nuovaBorsa);
        
        assertEquals(nuovaBorsa, giocatore.getBorsa());
        assertTrue(giocatore.getBorsa().hasAttrezzo("libro"));
        assertEquals(2, giocatore.getBorsa().getPeso());
    }
    
    @Test
    public void testBorsaAggiuntaAttrezzi() {
        Attrezzo attrezzo = new Attrezzo("libro", 2);
        giocatore.getBorsa().addAttrezzo(attrezzo);
        
        assertTrue(giocatore.getBorsa().hasAttrezzo("libro"));
        assertEquals(2, giocatore.getBorsa().getPeso());
    }
    
    @Test
    public void testDecrementoCfu() {
        int cfuIniziali = giocatore.getCfu();
        giocatore.setCfu(cfuIniziali - 1);
        assertEquals(cfuIniziali - 1, giocatore.getCfu());
    }
    
    @Test
    public void testAzzeramentoCfu() {
        giocatore.setCfu(0);
        assertEquals(0, giocatore.getCfu());
    }
    
    @Test
    public void testAumentoCfu() {
        int cfuIniziali = giocatore.getCfu();
        giocatore.setCfu(cfuIniziali + 5);
        assertEquals(cfuIniziali + 5, giocatore.getCfu());
    }
    
    @Test
    public void testRimozioneAttrezzoDaBorsa() {
        Attrezzo attrezzo = new Attrezzo("libro", 2);
        giocatore.getBorsa().addAttrezzo(attrezzo);
        
        // Controllo che l'attrezzo sia stato aggiunto
        assertTrue(giocatore.getBorsa().hasAttrezzo("libro"));
        
        // Rimuovo l'attrezzo
        Attrezzo rimosso = giocatore.getBorsa().removeAttrezzo("libro");
        
        // Controllo che l'attrezzo sia stato rimosso
        assertNotNull(rimosso);
        assertEquals("libro", rimosso.getNome());
        assertEquals(2, rimosso.getPeso());
        assertFalse(giocatore.getBorsa().hasAttrezzo("libro"));
        assertEquals(0, giocatore.getBorsa().getPeso());
    }
    
    @Test
    public void testBorsaCapacitaMassima() {
        // Creo un attrezzo che supera il peso massimo della borsa
        Attrezzo attrezzoPesante = new Attrezzo("armadio", Borsa.DEFAULT_PESO_MAX_BORSA + 1);
        
        // Tento di aggiungere l'attrezzo
        boolean risultato = giocatore.getBorsa().addAttrezzo(attrezzoPesante);
        
        // Controllo che l'attrezzo non sia stato aggiunto
        assertFalse(risultato);
        assertFalse(giocatore.getBorsa().hasAttrezzo("armadio"));
        assertEquals(0, giocatore.getBorsa().getPeso());
    }
}