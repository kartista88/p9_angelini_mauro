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
public class test_suite_funzionali_scriverecensione {
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
		gestoreTest.ricerca(libroTest);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScriviRecensioneSuccessoControlloVoto() throws IOException {
		gestoreTest.recensione(0, 4 , "Bello", libroTest);
		Integer voto = 4;
		assertEquals("Test recensione successo controllo voto" , voto , gestoreTest.getRecensioni().get(0).getVoto());
	}
	
	@Test
	public void testScriviRecensioneSuccessoControlloDescrizione() throws IOException {
		gestoreTest.recensione(0, 4 , "Bello", libroTest);
		assertEquals("Test recensione successo controllo voto" , "Bello" , gestoreTest.getRecensioni().get(0).getDescrizione());
	}
	
	@Test
	public void testScriviRecensioneSuccessoControlloLibro() throws IOException {
		gestoreTest.recensione(0, 4 , "Bello", libroTest);
		assertEquals("Test recensione successo controllo voto" , libroTest , gestoreTest.getRecensioni().get(0).getLibro());
	}
	
	@Test
	public void testScriviRecensioneSuccessoControlloUtente() throws IOException {
		gestoreTest.addUtenteRegistrato(utenteTest);
		gestoreTest.logIn("mauro" , "Mauro.88");
		gestoreTest.recensionelogin(0, 4 , "Bello", libroTest,utenteTest);
		assertEquals("Test recensione successo controllo utente" , utenteTest , gestoreTest.getRecensioni().get(0).getUtenteRegistrato());
	}
	

}
