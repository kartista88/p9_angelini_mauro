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

import Biblioteca.Abbonamento;
import Biblioteca.Biblioteca;
import Biblioteca.UtenteRegistrato;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_biblioteca {
	Biblioteca bibliotecaTestEmpty = new Biblioteca();
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Lercari","Villa Imperiale" , "010882356998");
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
	public void testCostruttoreDefaultNome() {
		assertEquals("Test costruttore default controllo nome" , null , bibliotecaTestEmpty.getNome());
	}
	
	@Test
	public void testCostruttoreDefaultIndirizzo() {
		assertEquals("Test costruttore default controllo indirizzo" , null , bibliotecaTestEmpty.getIndirizzo());
	}
	
	@Test
	public void testCostruttoreDefaultTelefono() {
		assertEquals("Test costruttore default controllo telefono" , null , bibliotecaTestEmpty.getTelefono());
	}
	
	@Test
	public void testCostruttoreParametriNome() {
		assertEquals("Test costruttore con parametri controllo nome" , "Biblioteca Lercari" , bibliotecaTest.getNome());
	}
	
	@Test
	public void testCostruttoreParametriIndirizzo() {
		assertEquals("Test costruttore parametri controllo indirizzo" , "Villa Imperiale" , bibliotecaTest.getIndirizzo());
	}
	
	@Test
	public void testCostruttoreParametriTelefono() {
		assertEquals("Test costruttore parametri  controllo telefono" , "010882356998" , bibliotecaTest.getTelefono());
	}
	
	@Test
	public void testSetNome() {
		bibliotecaTestEmpty.setNome("Biblioteca Berio");
		assertEquals("Test set nome" , "Biblioteca Berio" , bibliotecaTestEmpty.getNome());
	}
	
	@Test
	public void testSetIndirizzo() {
		bibliotecaTestEmpty.setIndirizzo("Via v");
		assertEquals("Test set indirizzo" , "Via v" , bibliotecaTestEmpty.getIndirizzo());
	}
	
	@Test
	public void testSetTelefono() {
		bibliotecaTestEmpty.setTelefono("123456789");
		assertEquals("Test set telefono" , "123456789" , bibliotecaTestEmpty.getTelefono());
	}
	
	
}
