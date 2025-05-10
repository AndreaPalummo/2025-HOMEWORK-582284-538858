package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;



public class ComandoPosaTest {
    
    private ComandoPosa comandoPosa;
    private Partita partita;
    private Stanza stanzaCorrente;
    private Attrezzo attrezzo;
    private IOConsole io;
    
    @Before
    public void setUp() {
        this.comandoPosa = new ComandoPosa();
        this.io = new IOConsole();
        this.comandoPosa.setIO(io);
        
        this.partita = new Partita(io);
        this.stanzaCorrente = new Stanza("Aula N10");
        this.attrezzo = new Attrezzo("libro", 2);
        
        this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        this.partita.setStanzaCorrente(stanzaCorrente);
    }
    
    @Test
    public void testPosaAttrezzoPresente() {
        comandoPosa.setParametro("libro");
        comandoPosa.esegui(partita);
        assertTrue(stanzaCorrente.hasAttrezzo("libro"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
    }
    
    @Test
    public void testPosaAttrezzoInesistente() {
        comandoPosa.setParametro("penna");
        comandoPosa.esegui(partita);
        assertFalse(stanzaCorrente.hasAttrezzo("penna"));
    }
    
    @Test
    public void testPosaSenzaParametro() {
        comandoPosa.setParametro(null);
        comandoPosa.esegui(partita);
        assertFalse(stanzaCorrente.hasAttrezzo("libro"));
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
    }
    
    @Test
    public void testPosaBorsaVuota() {
        partita.getGiocatore().getBorsa().removeAttrezzo("libro");
        comandoPosa.setParametro("libro");
        comandoPosa.esegui(partita);
        assertFalse(stanzaCorrente.hasAttrezzo("libro"));
    }
    
    @Test
    public void testGetNome() {
        assertEquals("posa", comandoPosa.getNome());
    }
    
    @Test
    public void testGetParametro() {
        comandoPosa.setParametro("libro");
        assertEquals("libro", comandoPosa.getParametro());
    }
    
    @Test
    public void testPosaMultipliAttrezzi() {
        // Aggiungo un secondo attrezzo alla borsa
        Attrezzo secondoAttrezzo = new Attrezzo("penna", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(secondoAttrezzo);
        
        // Poso il primo attrezzo
        comandoPosa.setParametro("libro");
        comandoPosa.esegui(partita);
        
        // Verifico che il primo attrezzo sia stato posato e il secondo sia ancora nella borsa
        assertTrue(stanzaCorrente.hasAttrezzo("libro"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("penna"));
        
        // Poso il secondo attrezzo
        comandoPosa.setParametro("penna");
        comandoPosa.esegui(partita);
        
        // Verifico che entrambi gli attrezzi siano stati posati
        assertTrue(stanzaCorrente.hasAttrezzo("libro"));
        assertTrue(stanzaCorrente.hasAttrezzo("penna"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("penna"));
        assertTrue(partita.getGiocatore().getBorsa().isEmpty());
    }
    
    @Test
    public void testVerificaPesoBorsaRidotto() {
        int pesoIniziale = partita.getGiocatore().getBorsa().getPeso();
        comandoPosa.setParametro("libro");
        comandoPosa.esegui(partita);
        
        // Verifico che il peso della borsa sia diminuito
        assertEquals(pesoIniziale - attrezzo.getPeso(), partita.getGiocatore().getBorsa().getPeso());
    }
}
