package test_strutturali_biblioteca;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Abbonamento;
import Biblioteca.UtenteRegistrato;

public class test_suite_strutturale_abbonamento {
	UtenteRegistrato utenteTestEmpty = new UtenteRegistrato();
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	Abbonamento abbonamentoTestEmpty = new Abbonamento();
	Abbonamento abbonamentoTest = new Abbonamento(LocalDate.of(2017, 06, 11),LocalDate.of(2017, 07, 11),true,utenteTest);
	
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
	public void testCostruttoreDefaultDataInizio() {
		assertEquals("Test costruttore di default controllo data inizio" , null , abbonamentoTestEmpty.getDataInizio());
	}
	
	@Test
	public void testCostruttoreDefaultDataFine() {
		assertEquals("Test costruttore di default controllo data fine" , null , abbonamentoTestEmpty.getDataFine());
	}
	
	@Test
	public void testCostruttoreDefaultPagato() {
		assertEquals("Test costruttore di default controllo pagato" , false , abbonamentoTestEmpty.getPagato());
	}
	
	@Test
	public void testCostruttoreDefaultUtenteRegistrato() {
		assertEquals("Test costruttore di default controllo utente registrato" , null , abbonamentoTestEmpty.getUtenteRegistrato());
	}
	
	@Test
	public void testCostruttoreParametriDataInizio() {
		assertEquals("Test costruttore con parametri controllo data inizio" , LocalDate.of(2017, 06, 11) , abbonamentoTest.getDataInizio());
	}
	
	@Test
	public void testCostruttoreParametriDataFine() {
		assertEquals("Test costruttore con parametri controllo data fine" , LocalDate.of(2017, 07, 11) , abbonamentoTest.getDataFine());
	}
	
	@Test
	public void testCostruttoreParametriPagato() {
		assertEquals("Test costruttore con parametri controllo pagato" , true , abbonamentoTest.getPagato());
	}
	
	@Test
	public void testCostruttoreParametriUtenteRegistrato() {
		assertEquals("Test costruttore con parametri controllo utente registrato" , utenteTest , abbonamentoTest.getUtenteRegistrato());
	}
	
	@Test
	public void testSetDataInizio() {
		abbonamentoTestEmpty.setDataInizio(LocalDate.of(2017, 07, 25));
		assertEquals("Test Set e Get data inizio" , LocalDate.of(2017, 07, 25) , abbonamentoTestEmpty.getDataInizio());
	}
	
	@Test
	public void testSetDataFine() {
		abbonamentoTestEmpty.setDataFine(LocalDate.of(2018, 07, 25));
		assertEquals("Test Set e Get data fine" , LocalDate.of(2018, 07, 25) , abbonamentoTestEmpty.getDataFine());
	}
	
	@Test
	public void testSetPagato() {
		abbonamentoTestEmpty.setPagato(true);
		assertEquals("Test Set e Get pagato" , true , abbonamentoTestEmpty.getPagato());
	}
	
	@Test
	public void testSetUtenteRegistrato() {
		abbonamentoTestEmpty.setUtenteRegistrato(utenteTest);
		assertEquals("Test Set e Get utente registrato" , utenteTest , abbonamentoTestEmpty.getUtenteRegistrato());
	}

}
