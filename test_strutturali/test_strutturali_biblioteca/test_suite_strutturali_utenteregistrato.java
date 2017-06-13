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

import Biblioteca.UtenteRegistrato;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_utenteregistrato {
	UtenteRegistrato utenteTestEmpty = new UtenteRegistrato();
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCostruttoreDefaultNome() {
		assertEquals("Test costruttore default controllo nome" , "" , utenteTestEmpty.getNome());
	}
	
	@Test
	public void testCostruttoreDefaultCognome() {
		assertEquals("Test costruttore default controllo cognome" , null , utenteTestEmpty.getCognome());
	}
	
	@Test
	public void testCostruttoreDefaulEta() {
		assertEquals("Test costruttore default controllo et�" , null , utenteTestEmpty.getEta());
	}
	
	@Test
	public void testCostruttoreDefaultIndirizzo() {
		assertEquals("Test costruttore default controllo indirizzo" , null , utenteTestEmpty.getIndirizzo());
	}
	
	@Test
	public void testCostruttoreDefaultEmail() {
		assertEquals("Test costruttore default controllo email" , null , utenteTestEmpty.getEmail());
	}
	
	@Test
	public void testCostruttoreDefaultTelefono() {
		assertEquals("Test costruttore default controllo telefono" , null , utenteTestEmpty.getTelefono());
	}
	
	@Test
	public void testCostruttoreDefaultUsername() {
		assertEquals("Test costruttore default controllo username" , null , utenteTestEmpty.getUsername());
	}
	
	@Test
	public void testCostruttoreDefaultPassword() {
		assertEquals("Test costruttore default controllo password" , null , utenteTestEmpty.getPassword());
	}
	
	@Test
	public void testCostruttoreParametriNome() {
		assertEquals("Test costruttore parametri controllo nome" , "Mauro" , utenteTest.getNome());
	}
	
	@Test
	public void testCostruttoreParametriCognome() {
		assertEquals("Test costruttore parametri controllo cognome" , "Angelini" , utenteTest.getCognome());
	}
	
	@Test
	public void testCostruttoreParametriEta() {
		assertEquals("Test costruttore parametri controllo et�" , "25" , utenteTest.getEta());
	}
	
	@Test
	public void testCostruttoreParametriIndirizzo() {
		assertEquals("Test costruttore parametri controllo indirizzo" , "Via P" , utenteTest.getIndirizzo());
	}
	
	@Test
	public void testCostruttoreParametriEmail() {
		assertEquals("Test costruttore parametri controllo email" , "mauro88ge@gmail.com" , utenteTest.getEmail());
	}
	
	@Test
	public void testCostruttoreParametriTelefono() {
		assertEquals("Test costruttore parametri controllo telefono" , "32056889225" , utenteTest.getTelefono());
	}
	
	@Test
	public void testCostruttoreParametriUsername() {
		assertEquals("Test costruttore parametri controllo username" , "mauro" , utenteTest.getUsername());
	}
	
	@Test
	public void testCostruttoreParametriPassword() {
		assertEquals("Test costruttore parametri controllo password" , "Mauro.88" , utenteTest.getPassword());
	}
	
	@Test
	public void testSetNome() {
		utenteTestEmpty.setNome("M");
		assertEquals("Test set nome" , "M" , utenteTestEmpty.getNome());
	}
	
	@Test
	public void testSetCognome() {
		utenteTestEmpty.setCognome("A");
		assertEquals("Test set cognome" , "A" , utenteTestEmpty.getCognome());
	}
	
	@Test
	public void testSetEta() {
		utenteTestEmpty.setEta("23");
		assertEquals("Test set eta" , "23" , utenteTestEmpty.getEta());
	}
	
	@Test
	public void testSetIndirizzo() {
		utenteTestEmpty.setIndirizzo("V");
		assertEquals("Test set indirizzo" , "V" , utenteTestEmpty.getIndirizzo());
	}
	
	@Test
	public void testSetmail() {
		utenteTestEmpty.setEmail("m");
		assertEquals("Test set email" , "m" , utenteTestEmpty.getEmail());
	}
	
	@Test
	public void testSetTelefono() {
		utenteTestEmpty.setTelefono("4567");
		assertEquals("Test set telefono" , "4567" , utenteTestEmpty.getTelefono());
	}
	
	@Test
	public void testSetUsername() {
		utenteTestEmpty.setUsername("Michele");
		assertEquals("Test set username" , "Michele" , utenteTestEmpty.getUsername());
	}
	
	@Test
	public void testSetPassword() {
		utenteTestEmpty.setPassword("Michele.88");
		assertEquals("Test set password" , "Michele.88" , utenteTestEmpty.getPassword());
	}
	
}
