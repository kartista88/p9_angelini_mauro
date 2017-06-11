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

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_libro {
	Libro libroTestEmpty = new Libro();
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "WS" , 2017);
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
	public void testCostruttoreDefaultDisponibile() {
		assertEquals("test costruttore default controllo disponibile" , false , libroTestEmpty.isDisponibile());
	}
	
	@Test
	public void testCostruttoreDefaultISBN() {
		assertEquals("test costruttore default controllo ISBN" , null , libroTestEmpty.getISBN());
	}
	
	@Test
	public void testCostruttoreDefaultTitolo() {
		assertEquals("test costruttore default controllo titolo" , null , libroTestEmpty.getTitolo());
	}
	
	@Test
	public void testCostruttoreDefaultAutore() {
		assertEquals("test costruttore default controllo autore" , null , libroTestEmpty.getAutore());
	}
	
	@Test
	public void testCostruttoreDefaultCasaEditrice() {
		assertEquals("test costruttore default controllo casa editrice" , null , libroTestEmpty.getCasaEditrice());
	}
	
	@Test
	public void testCostruttoreDefaultAnnoEdizione() {
		assertEquals("test costruttore default controllo anno edizione" , 0 , libroTestEmpty.getAnnoEdizione());
	}
	
	@Test
	public void testCostruttoreParametriDisponibile() {
		assertEquals("test costruttore parametri controllo disponibile" , true , libroTest.isDisponibile());
	}
	
	@Test
	public void testCostruttoreParametriISBN() {
		assertEquals("test costruttore parametri controllo ISBN" , "ISBN 978-88-540-3041-1" , libroTest.getISBN());
	}
	
	@Test
	public void testCostruttoreParametriTitolo() {
		assertEquals("test costruttore parametri controllo titolo" , "Brasile" , libroTest.getTitolo());
	}
	
	@Test
	public void testCostruttoreParametriAutore() {
		assertEquals("test costruttore parametri controllo autore" , "NationalGeografic" , libroTest.getAutore());
	}
	
	@Test
	public void testCostruttoreParametriCasaEditrice() {
		assertEquals("test costruttore parametri controllo casa editrice" , "WS" , libroTest.getCasaEditrice());
	}
	
	@Test
	public void testCostruttoreParametriAnnoEdizione() {
		assertEquals("test costruttore parametri controllo anno edizione" , 2017 , libroTest.getAnnoEdizione());
	}
	
	@Test
	public void testSetDisponibile() {
		libroTestEmpty.setDisponibile(true);
		assertEquals("test set disponibile" , true , libroTestEmpty.isDisponibile());
	}
	
	@Test
	public void testSetISBN() {
		libroTestEmpty.setISBN("ISBN 978-88-540-3014-1");
		assertEquals("test set ISBN" , "ISBN 978-88-540-3014-1" , libroTestEmpty.getISBN());
	}
	
	@Test
	public void testSetTitolo() {
		libroTestEmpty.setTitolo("Barcellona");
		assertEquals("test set titolo" , "Barcellona" , libroTestEmpty.getTitolo());
	}
	
	@Test
	public void testSetAutore() {
		libroTestEmpty.setAutore("NationalGeorgrafic");;
		assertEquals("test set autore" , "NationalGeorgrafic" , libroTestEmpty.getAutore());
	}
	
	@Test
	public void testSetCasaEditrice() {
		libroTestEmpty.setCasaEditrice("WS");
		assertEquals("test set casa editrice" , "WS" , libroTestEmpty.getCasaEditrice());
	}
	
	@Test
	public void testSetAnnoEdizione() {
		libroTestEmpty.setAnnoEdizione(2016);
		assertEquals("test set anno edizione" , 2016 , libroTestEmpty.getAnnoEdizione());
	}
	

}
