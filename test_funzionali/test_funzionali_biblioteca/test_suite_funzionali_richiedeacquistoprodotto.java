package test_funzionali_biblioteca;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Gestore;
import Biblioteca.Libro;

public class test_suite_funzionali_richiedeacquistoprodotto {
	Gestore gestoreTest = new Gestore();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRichiedeAcquistoprodottoISBN() throws IOException {
		Libro IS = new Libro(false , "ISBN 978-88-540-3041-1" , "" , "" , "" ,0);
		gestoreTest.suggerisciAcquisto(IS);
		assertEquals("Test richiesta acquisto prodotto per ISBN" , IS , gestoreTest.getLibroSuggerito());
	}
	
	@Test
	public void testRichiedeAcquistoprodottoISBNTitolo() throws IOException {
		Libro ISTI = new Libro(false , "ISBN 978-88-540-3041-56" , "Roma" , "" , "" ,0);
		gestoreTest.suggerisciAcquisto(ISTI);
		assertEquals("Test richiesta acquisto prodotto per ISBN e titolo" , ISTI , gestoreTest.getLibroSuggerito());
	}
	
	@Test
	public void testRichiedeAcquistoprodottoISBNTitoloAutore() throws IOException {
		Libro ISTIAU = new Libro(false , "ISBN 978-88-540-3041-1" , "Roma" , "NationalGeografic" , "" ,0);
		gestoreTest.suggerisciAcquisto(ISTIAU);
		assertEquals("Test richiesta acquisto prodotto per ISBN titolo e autore" , ISTIAU , gestoreTest.getLibroSuggerito());
	}
	
	@Test
	public void testRichiedeAcquistoprodottoISBNTitoloAutoreCasaEditrice() throws IOException {
		Libro ISTIAUCE = new Libro(false , "ISBN 978-88-540-3041-1" , "Roma" , "NationalGeografic" , "Edizioni White Star" ,0);
		gestoreTest.suggerisciAcquisto(ISTIAUCE);
		assertEquals("Test richiesta acquisto prodotto per ISBN titolo autore e casa editrice" , ISTIAUCE , gestoreTest.getLibroSuggerito());
	}
	
	@Test
	public void testRichiedeAcquistoprodottoISBNTitoloAutoreCasaEditriceAnnoEdizione() throws IOException {
		Libro ISTIAUCEAE = new Libro(false , "ISBN 978-88-540-3041-1" , "Roma" , "NationalGeografic" , "Edizioni White Star" ,2016);
		gestoreTest.suggerisciAcquisto(ISTIAUCEAE);
		assertEquals("Test richiesta acquisto prodotto per ISBN titolo autore casa editrice e anno edizione" , ISTIAUCEAE , gestoreTest.getLibroSuggerito());
	}

}
