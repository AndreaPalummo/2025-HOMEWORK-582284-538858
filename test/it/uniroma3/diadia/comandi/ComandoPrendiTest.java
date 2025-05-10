package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
    
    private ComandoPrendi comandoPrendi;
    private Partita partita;
    private Stanza stanzaCorrente;
    private Attrezzo attrezzo;
    private IOConsole io;
    
    @Before
    public void setUp() {
        this.comandoPrendi = new ComandoPrendi();
        this.io = new IOConsole();
        this.comandoPrendi.setIO(io);
        
        this.partita = new Partita(io);
        this.stanzaCorrente = new Stanza("Aula N10");
        this.attrezzo = new Attrezzo("libro", 2);
        
        this.stanzaCorrente.addAttrezzo(attrezzo);
        this.partita.setStanzaCorrente(stanzaCorrente);
    }
    
    @Test
    public void testPrendiAttrezzoPresente() {
        comandoPrendi.setParametro("libro");
        comandoPrendi.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
        assertFalse(stanzaCorrente.hasAttrezzo("libro"));
    }
    
    @Test
    public void testPrendiAttrezzoInesistente() {
        comandoPrendi.setParametro("penna");
        comandoPrendi.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("penna"));
    }
    
    @Test
    public void testPrendiSenzaParametro() {
        comandoPrendi.setParametro(null);
        comandoPrendi.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
        assertTrue(stanzaCorrente.hasAttrezzo("libro"));
    }
    
    @Test
    public void testPrendiStanzaVuota() {
        stanzaCorrente.removeAttrezzo(attrezzo);
        comandoPrendi.setParametro("libro");
        comandoPrendi.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
    }
    
    @Test
    public void testPrendiPesoBorsaSuperato() {
        // Aggiungo un attrezzo pesante per riempire la borsa
        Attrezzo attrezzoPesante = new Attrezzo("armadio", 8);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzoPesante);
        
        // Aggiungo un altro attrezzo che porterebbe la borsa oltre il peso massimo
        Attrezzo altroAttrezzo = new Attrezzo("tavolo", 5);
        stanzaCorrente.addAttrezzo(altroAttrezzo);
        
        comandoPrendi.setParametro("tavolo");
        comandoPrendi.esegui(partita);
        
        // L'attrezzo non dovrebbe essere stato preso
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("tavolo"));
        assertTrue(stanzaCorrente.hasAttrezzo("tavolo"));
    }
    
    @Test
    public void testGetNome() {
        assertEquals("prendi", comandoPrendi.getNome());
    }
    
    @Test
    public void testGetParametro() {
        comandoPrendi.setParametro("libro");
        assertEquals("libro", comandoPrendi.getParametro());
    }
}
