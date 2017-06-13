/**
 * 
 */
package test_funzionali_biblioteca;

import static org.junit.Assert.*;

import java.io.IOException;

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

/**
 * @author Mauro
 *
 */
public class test_suite_funzionali_richiedesingolaconsultazione {
	Gestore gestoreTest = new Gestore();
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "EdizioniWhiteStar" , 2016);
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Centrale" , "CorsoMarche34R" , "01854465254");
	Collocazione collocazioneTest = new Collocazione("Turismo" , "3" , "BR8" , bibliotecaTest);
	Catalogo catalogoTest = new Catalogo("Librario" , libroTest, collocazioneTest);
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gestoreTest.setCatalogo(catalogoTest);
		gestoreTest.addUtenteRegistrato(utenteTest);
		gestoreTest.logIn("mauro" , "Mauro.88");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSingolaConsultazioneSuccessoControlloUtente() throws IOException {
		gestoreTest.singolaConsultazione(utenteTest, libroTest);
		assertEquals("Test singola consultazione successo controllo utente" , utenteTest , gestoreTest.getConsultazioni().get(0).getUtenteRegistrato());
	}
	
	@Test
	public void testSingolaConsultazioneSuccessoControlloPagato() throws IOException {
		gestoreTest.singolaConsultazione(utenteTest, libroTest);
		assertEquals("Test singola consultazione successo controllo utente" , true , gestoreTest.getConsultazioni().get(0).isPagato());
	}
	
	@Test
	public void testSingolaConsultazioneSuccessoControlloLibro() throws IOException {
		gestoreTest.singolaConsultazione(utenteTest, libroTest);
		assertEquals("Test singola consultazione successo controllo utente" , libroTest , gestoreTest.getConsultazioni().get(0).getLibro());
	}

}
