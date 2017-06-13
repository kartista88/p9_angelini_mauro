/**
 * 
 */
package test_strutturali_biblioteca;

import static org.junit.Assert.*;


import java.time.LocalDateTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Consultazione;
import Biblioteca.Libro;
import Biblioteca.UtenteRegistrato;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_consultazione {
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "WS" , 2017);
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	Consultazione consultazioneTestEmpty = new Consultazione();
	Consultazione consultazioneTest = new Consultazione(LocalDateTime.of(2017, 06, 11, 11, 00) , LocalDateTime.of(2017, 06, 11, 18, 00) , libroTest , utenteTest);

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
	public void testCostruttoreDefaultDataOraRitiro() {
		assertEquals("Test costruttore default controllo data ora ritiro" , null , consultazioneTestEmpty.getDataOraRitiro());
	}
	
	@Test
	public void testCostruttoreDefaultDataOraConsegna() {
		assertEquals("Test costruttore default controllo data ora consegna" , null , consultazioneTestEmpty.getDataOraConsegna());
	}

	@Test
	public void testCostruttoreDefaultLibro() {
		assertEquals("Test costruttore default controllo libro" , null , consultazioneTestEmpty.getLibro());
	}

	@Test
	public void testCostruttoreDefaultUtente() {
		assertEquals("Test costruttore default controllo utente" , null , consultazioneTestEmpty.getUtenteRegistrato());
	}
	
	@Test
	public void testSetDataRitiro() {
		consultazioneTestEmpty.setDataOraRitiro(LocalDateTime.of(2017, 07, 25, 11, 00));
		assertEquals("Test set data ritiro" , LocalDateTime.of(2017, 07, 25, 11, 00) , consultazioneTestEmpty.getDataOraRitiro());
	}
	
	@Test
	public void testSetDataConsegna() {
		consultazioneTestEmpty.setDataOraConsegna(LocalDateTime.of(2017, 07, 25, 18, 00));
		assertEquals("Test set data consegna" , LocalDateTime.of(2017, 07, 25, 18, 00) , consultazioneTestEmpty.getDataOraConsegna());
	}
	
	@Test
	public void testSetDataLibro() {
		consultazioneTestEmpty.setLibro(libroTest);
		assertEquals("Test set libro" , libroTest , consultazioneTestEmpty.getLibro());
	}
	
	@Test
	public void testSetUtente() {
		consultazioneTestEmpty.setUtenteRegistrato(utenteTest);
		assertEquals("Test set Utente" , utenteTest , consultazioneTestEmpty.getUtenteRegistrato());
	}
	
	@Test
	public void testSetPagato() {
		consultazioneTestEmpty.setPagato(true);
		assertEquals("Test set pagato" , true , consultazioneTestEmpty.isPagato());
	}

}
