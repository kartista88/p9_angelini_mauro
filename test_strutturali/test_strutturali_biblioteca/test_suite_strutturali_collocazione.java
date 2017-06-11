/**
 * 
 */
package test_strutturali_biblioteca;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Biblioteca;
import Biblioteca.Collocazione;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_collocazione {
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Lercari","Villa Imperiale" , "010882356998");
	Collocazione collocazioneTestEmpty = new Collocazione();
	Collocazione collocazioneTest = new Collocazione("A" , "Turismo" , "12345" , bibliotecaTest);

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCostruttoreDefaultSezione() {
		assertEquals("Test costruttore default controllo sezione" , null , collocazioneTestEmpty.getSezione());
	}
	
	@Test
	public void testCostruttoreDefaultScaffale() {
		assertEquals("Test costruttore default controllo scaffale" , null , collocazioneTestEmpty.getScaffale());
	}
	
	@Test
	public void testCostruttoreDefaultNumeroSeriale() {
		assertEquals("Test costruttore default controllo numero seriale" , null , collocazioneTestEmpty.getNumeroSeriale());
	}
	
	@Test
	public void testCostruttoreDefaultBiblioteca() {
		assertEquals("Test costruttore default controllo biblioteca" , null , collocazioneTestEmpty.getBiblioteca());
	}
	
	@Test
	public void testCostruttoreParametriSezione() {
		assertEquals("Test costruttore parametri controllo sezione" , "A" , collocazioneTest.getSezione());
	}
	
	@Test
	public void testCostruttoreParametriScaffale() {
		assertEquals("Test costruttore parametri controllo scaffale" , "Turismo" , collocazioneTest.getScaffale());
	}
	
	@Test
	public void testCostruttoreParametriNumeroSeriale() {
		assertEquals("Test costruttore parametri controllo numero seriale" , "12345" , collocazioneTest.getNumeroSeriale());
	}
	
	@Test
	public void testCostruttoreParametriBiblioteca() {
		assertEquals("Test costruttore parametri controllo biblioteca" , bibliotecaTest , collocazioneTest.getBiblioteca());
	}
	
	@Test
	public void testSetSezione() {
		collocazioneTestEmpty.setSezione("A");
		assertEquals("Test set sezione" , "A" , collocazioneTest.getSezione());
	}
	
	@Test
	public void testSetScaffale() {
		collocazioneTestEmpty.setScaffale("B");
		assertEquals("Test set scaffale" , "B" , collocazioneTestEmpty.getScaffale());
	}
	
	@Test
	public void testSetNumeroSeriale() {
		collocazioneTestEmpty.setNumeroSeriale("12345");
		assertEquals("Test set numero seriale" , "12345" , collocazioneTestEmpty.getNumeroSeriale());
	}
	
	@Test
	public void testSetBiblioteca() {
		collocazioneTestEmpty.setBiblioteca(bibliotecaTest);
		assertEquals("Test set scaffale" , bibliotecaTest , collocazioneTestEmpty.getBiblioteca());
	}
	
	

}
