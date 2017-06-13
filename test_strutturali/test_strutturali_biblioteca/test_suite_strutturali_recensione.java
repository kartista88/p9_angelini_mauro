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

import Biblioteca.Libro;
import Biblioteca.Recensione;
import Biblioteca.UtenteRegistrato;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_recensione {
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "WS" , 2017);
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	Recensione recensioneTestEmpty = new Recensione();	
	Recensione recensioneTest = new Recensione( "5" , "Descrizione" , libroTest , utenteTest );
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
	public void testCostruttoreDefaultVoto() {
		Integer a = 0;
		assertEquals("Test costruttore default controllo voto" , a , recensioneTestEmpty.getVoto());
	}
	
	@Test
	public void testCostruttoreDefaultDescrizione() {
		assertEquals("Test costruttore default controllo descrizione" , null , recensioneTestEmpty.getDescrizione());
	}
	
	@Test
	public void testCostruttoreDefaultLibro() {
		assertEquals("Test costruttore default controllo libro" , null , recensioneTestEmpty.getLibro());
	}
	
	@Test
	public void testCostruttoreDefaultUtente() {
		assertEquals("Test costruttore default controllo voto" , null , recensioneTestEmpty.getUtenteRegistrato());
	}
	
	@Test
	public void testCostruttoreParametriVoto() {
		Integer a = 5;
		assertEquals("Test costruttore parametri controllo voto" , a , recensioneTest.getVoto());
	}
	
	@Test
	public void testCostruttoreParametriDescrizione() {
		assertEquals("Test costruttore parametri controllo descrizione" , "Descrizione" , recensioneTest.getDescrizione());
	}
	
	@Test
	public void testCostruttoreParametriLibro() {
		assertEquals("Test costruttore parametri controllo libro" , libroTest , recensioneTest.getLibro());
	}
	
	@Test
	public void testCostruttoreParametriUtente() {
		assertEquals("Test costruttore parametri controllo voto" , utenteTest , recensioneTest.getUtenteRegistrato());
	}
	
	@Test
	public void testSetVoto() {
		Integer a = 4;
		recensioneTestEmpty.setVoto(a);
		assertEquals("Test set voto" , a , recensioneTestEmpty.getVoto());
	}
	
	@Test
	public void testSetDescrizione() {
		recensioneTestEmpty.setDescrizione("Descr");
		assertEquals("Test set descrizione" , "Descr" , recensioneTestEmpty.getDescrizione());
	}
	
	@Test
	public void testSetLibro() {
		recensioneTestEmpty.setLibro(libroTest);
		assertEquals("Test set libro" , libroTest , recensioneTestEmpty.getLibro());
	}
	
	@Test
	public void testSetUtente() {
		recensioneTestEmpty.setUtenteRegistrato(utenteTest);
		assertEquals("Test set utente" , utenteTest , recensioneTestEmpty.getUtenteRegistrato());
	}
}
