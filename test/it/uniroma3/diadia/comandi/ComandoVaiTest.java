package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
    
    private ComandoVai comandoVai;
    private Partita partita;
    private IO io;
    private Stanza stanzaCorrente;
    private Stanza stanzaAdiacente;
    
    @Before
    public void setUp() {
        comandoVai = new ComandoVai();
        partita = new Partita(io);
        io = new IOConsole();
        comandoVai.setIO(io);
        
        stanzaCorrente = new Stanza("Stanza di test");
        stanzaAdiacente = new Stanza("Stanza adiacente");
        
        stanzaCorrente.impostaStanzaAdiacente("nord", stanzaAdiacente);
        partita.setStanzaCorrente(stanzaCorrente);
    }
    
    @Test
    public void testVaiDirezioneValida() {
        comandoVai.setParametro("nord");
        comandoVai.esegui(partita);
        assertEquals(stanzaAdiacente, partita.getStanzaCorrente());
    }
    
    @Test
    public void testVaiDirezioneNonValida() {
        comandoVai.setParametro("sud");
        comandoVai.esegui(partita);
        assertEquals(stanzaCorrente, partita.getStanzaCorrente());
    }
    
    @Test
    public void testVaiSenzaDirezione() {
        comandoVai.setParametro(null);
        comandoVai.esegui(partita);
        assertEquals(stanzaCorrente, partita.getStanzaCorrente());
    }
    
    @Test
    public void testDecrementoCFU() {
        int cfuIniziali = partita.getGiocatore().getCfu();
        comandoVai.setParametro("nord");
        comandoVai.esegui(partita);
        assertEquals(cfuIniziali - 1, partita.getGiocatore().getCfu());
    }
    
    @Test
    public void testGetNome() {
        assertEquals("vai", comandoVai.getNome());
    }
    
    @Test
    public void testGetParametro() {
        comandoVai.setParametro("nord");
        assertEquals("nord", comandoVai.getParametro());
    }
}