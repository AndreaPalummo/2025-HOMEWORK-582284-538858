package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.ComandoVai;

public class IOSimulatorTest {

	private DiaDia simulazione;
	private IOSimulator io;
	
	final static private String MESSAGGIO_AIUTO= "-guarda:	accedi alla tua posizione e allo stato della borsa"
			+ "-vai:		vai nella direzione desiderata"
			+ "-posa:		posa un oggetto dalla borsa"
			+ "-prendi:	prendi un oggetto dalla stanza"
			+ "-aiuto: 	elenco dei comandi"
			+ "-fine:		termina la partita";
		


	@Before

	public void setUp() {
		this.io = new IOSimulator();
		simulazione=new DiaDia(io);
	}

	@Test
	public void testSimulazionePartitaComandoFine() {

		String[] comandi= {"fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO+ ComandoFine.MESSAGGIO_FINE, this.io.getOutput());
	}
	
	@Test
	public void testSimulazionePartitaComandoAiuto() {
		String[] comandi= {"aiuto","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((MESSAGGIO_AIUTO+ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));	
	}
	
	@Test
	public void testSimulazionePartitaComandoNonValido() {
		String[] comandi= {"daje","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals("Errore",(ComandoNonValido.NON_VALIDO+ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoGuarda() {
		String[] comandi= {"guarda","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		String outputStanza=this.simulazione.getPartita().getStanzaCorrente().getDescrizione();
		String outputBorsa=this.simulazione.getPartita().getGiocatore().getBorsa().toString();
		String outputGuarda=outputBorsa+outputStanza;

		assertEquals((outputGuarda+ComandoFine.MESSAGGIO_FINE), this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPosaBorsaVuota() {
		String[] comandi= {"posa","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((ComandoPosa.BORSA_VUOTA+ComandoFine.MESSAGGIO_FINE), this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPosaBorsaNoParametro() {
		Attrezzo attrezzo=new Attrezzo("anello",1);
		this.simulazione.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
		String[] comandi= {"posa","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((ComandoPosa.NO_PARAMETRO+ComandoFine.MESSAGGIO_FINE), this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPosa() {
		Attrezzo attrezzo=new Attrezzo("anello",1);
		this.simulazione.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
		String[] comandi= {"posa anello","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((ComandoPosa.ATTREZZO_POSATO + ComandoPosa.SPAZIO_BORSA_RIMANENTE + "10kg" + ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPrendiNoParametro() {
		String[] comandi= {"prendi","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((ComandoPrendi.NO_PARAMETRO + ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPrendi() {
		String[] comandi= {"prendi osso","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals(("Hai preso l'attrezzo \"osso\" e l'hai aggiunto all'inventario." +  ComandoPrendi.SPAZIO_BORSA_RIMANENTE +
		"9kg"+ ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPrendiBorsaPiena() {
		Attrezzo attrezzo=new Attrezzo("martello",11);
		this.simulazione.getPartita().getStanzaCorrente().addAttrezzo(attrezzo);
		String[] comandi= {"prendi martello","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((ComandoPrendi.BORSA_PIENA+ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoPrendiAttrezzoInesistente() {
		String[] comandi= {"prendi lanterna","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((ComandoPrendi.ATTREZZO_INESISTENTE + ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	@Test
	public void testSimulazionePartitaComandoVaiNoParametro() {
		String[] comandi= {"vai","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals((simulazione.getPartita().getStanzaCorrente().getDescrizione() + ComandoVai.NO_PARAMETRO + ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test
	public void testSimulazionePartitaComandoVaiDirezioneInesistente() {
		String[] comandi= {"vai nord-est","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals("Errore",(ComandoVai.DIREZIONE_INESISTENTE+ComandoFine.MESSAGGIO_FINE), 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
	
	@Test 
	public void testSimulazioneSempliceVaiConParametroEsatto() {
		String[] comandi= {"vai sud","fine"};
		this.io.setInput(comandi);
		simulazione.gioca();
		assertEquals(simulazione.getPartita().getStanzaCorrente().getDescrizione() + 
				"Ti sono rimasti " + simulazione.getPartita().getGiocatore().getCfu() + " cfu" + ComandoFine.MESSAGGIO_FINE, 
				this.io.getOutput().substring(DiaDia.MESSAGGIO_BENVENUTO.length()));
	}
}