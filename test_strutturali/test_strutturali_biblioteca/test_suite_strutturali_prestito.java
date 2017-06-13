/**
 * 
 */
package test_strutturali_biblioteca;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Libro;
import Biblioteca.Prestito;
import Biblioteca.UtenteRegistrato;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_prestito {
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "WS" , 2017);
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	Prestito prestitoTestEmpty = new Prestito();
	Prestito prestitoTest = new Prestito(LocalDate.of(2017, 06, 25),LocalDate.of(2017, 07, 25),utenteTest,libroTest);

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
	public void testCostruttoreDefaultDataConsegna() {
		assertEquals("Test costruttore default controllo data consegna", null , prestitoTestEmpty.getDataConsegna());
	}
	
	@Test
	public void testCostruttoreDefaultDataRitiro() {
		assertEquals("Test costruttore default controllo data ritiro", null , prestitoTestEmpty.getDataRitiro());
	}
	
	@Test
	public void testCostruttoreDefaultUtenteRegistrato() {
		assertEquals("Test costruttore default controllo utente registrato", null , prestitoTestEmpty.getUtenteRegistrato());
	}
	
	@Test
	public void testCostruttoreDefaultLibro() {
		assertEquals("Test costruttore default controllo libro", null , prestitoTestEmpty.getLibri());
	}
	
	@Test
	public void testCostruttoreParametriDataConsegna() {
		assertEquals("Test costruttore parametri controllo data consegna", LocalDate.of(2017, 07, 25) , prestitoTest.getDataConsegna());
	}
	
	@Test
	public void testCostruttoreParametriDataRitiro() {
		assertEquals("Test costruttore parametri controllo data ritiro", LocalDate.of(2017, 06, 25) , prestitoTest.getDataRitiro());
	}
	
	@Test
	public void testCostruttoreParametriUtenteRegistrato() {
		assertEquals("Test costruttore parametri controllo utente registrato", utenteTest , prestitoTest.getUtenteRegistrato());
	}
	
	@Test
	public void testCostruttoreParametriLibro() {
		assertEquals("Test costruttore parametri controllo libro", libroTest , prestitoTest.getLibri());
	}
	
	@Test
	public void testSetDataConsegna() {
		prestitoTestEmpty.setDataConsegna(LocalDate.of(2017, 02, 05));
		assertEquals("Test set data consegna", LocalDate.of(2017, 02, 05) , prestitoTestEmpty.getDataConsegna());
	}
	
	@Test
	public void testSetDataRitiro() {
		prestitoTestEmpty.setDataRitiro(LocalDate.of(2017, 02, 05));
		assertEquals("Test set data ritiro", LocalDate.of(2017, 02, 05) , prestitoTestEmpty.getDataRitiro());
	}
	
	@Test
	public void testSetUtenteRegistrato() {
		prestitoTestEmpty.setUtenteRegistrato(utenteTest);
		assertEquals("Test set utente registrato", utenteTest , prestitoTestEmpty.getUtenteRegistrato());
	}
	
	@Test
	public void testSetLibro() {
		prestitoTestEmpty.setLibri(libroTest);
		assertEquals("Test set libro", libroTest , prestitoTestEmpty.getLibri());
	}
	
	
	
	
	

}
