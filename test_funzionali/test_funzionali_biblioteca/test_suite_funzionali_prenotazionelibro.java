package test_funzionali_biblioteca;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Biblioteca;
import Biblioteca.Catalogo;
import Biblioteca.Collocazione;
import Biblioteca.Gestore;
import Biblioteca.Libro;
import Biblioteca.UtenteRegistrato;

public class test_suite_funzionali_prenotazionelibro {
	Gestore gestoreTest = new Gestore();
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "EdizioniWhiteStar" , 2016);
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Centrale" , "CorsoMarche34R" , "01854465254");
	Collocazione collocazioneTest = new Collocazione("Turismo" , "3" , "BR8" , bibliotecaTest);
	Catalogo catalogoTest = new Catalogo("Librario" , libroTest, collocazioneTest);
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		gestoreTest.setCatalogo(catalogoTest);
		ArrayList<Libro> arrayLibriRicerca = new ArrayList<Libro>();
		ArrayList<Collocazione> arrayCollocazioniRicerca = new ArrayList<Collocazione>();
		arrayLibriRicerca.add(libroTest);
		arrayCollocazioniRicerca.add(collocazioneTest);
		gestoreTest.setLibriRicerca(arrayLibriRicerca);
		gestoreTest.setCollocazioniRicerca(arrayCollocazioniRicerca);
		gestoreTest.addUtenteRegistrato(utenteTest);
		gestoreTest.logIn("mauro", "Mauro.88");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrenotazioneSuccessoControlloLibro() {
		gestoreTest.prestito(utenteTest, libroTest);
		assertEquals("Test prestito successo controllo libro" , libroTest , gestoreTest.getPrestiti().get(0).getLibri());
	}
	
	@Test
	public void testPrenotazioneSuccessoControlloUtente() {
		gestoreTest.prestito(utenteTest, libroTest);
		assertEquals("Test prestito successo controllo utente" , utenteTest , gestoreTest.getPrestiti().get(0).getUtenteRegistrato());
	}
	
	@Test
	public void testPrenotazioneFallimentoLibroNonPresente() {
		Libro libroNonPresente = new Libro(false , "ISBN978-88-540-3044-2" , "Alaska" , "NationalGeografic" , "EdizioniWhiteStar" , 2016);
		gestoreTest.prestito(utenteTest, libroNonPresente);
		assertEquals("Test prestito fallito per libro non presente" , 0 , gestoreTest.getPrestiti().size());
	}
	
	@Test
	public void testPrenotazioneFallimentoLibroGiaPrenotato() {
		gestoreTest.prestito(utenteTest, libroTest);
		gestoreTest.prestito(utenteTest, libroTest);
		assertEquals("Test prestito fallito per libro gi� prenotato" , 1 , gestoreTest.getPrestiti().size());
	}
	
	

}
