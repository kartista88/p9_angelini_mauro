package test_strutturali_biblioteca;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Biblioteca;
import Biblioteca.Catalogo;
import Biblioteca.Collocazione;
import Biblioteca.Libro;

public class test_suite_strutturali_catalogo {
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "WS" , 2017);
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Lercari","Villa Imperiale" , "010882356998");
	Collocazione collocazioneTest = new Collocazione("A" , "Turismo" , "12345" , bibliotecaTest);
	Catalogo catalogoTestEmpty = new Catalogo();
	Catalogo catalogoTestParametro = new Catalogo("Riviste");
	Catalogo catalogoTest = new Catalogo("Librario" , libroTest , collocazioneTest );
	
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
	public void testCostruttoreDefaultTipo() {
		assertEquals("Test costruttore default controllo tipo" , null , catalogoTestEmpty.getTipo());
	}
	
	@Test
	public void testCostruttoreDefaultLibro() {
		assertEquals("Test costruttore default controllo libro" , null , catalogoTestEmpty.getLibri());
	}
	
	@Test
	public void testCostruttoreDefaultCollocazione() {
		assertEquals("Test costruttore default controllo collocazione" , null , catalogoTestEmpty.getCollocazioni());
	}
	
	@Test
	public void testCostruttoreParametroTipo() {
		assertEquals("Test costruttore parametro controllo tipo" , "Riviste" , catalogoTestParametro.getTipo());
	}
	
	@Test
	public void testCostruttoreParametriTipo() {
		assertEquals("Test costruttore default controllo tipo" , "Librario" , catalogoTest.getTipo());
	}
	
	@Test
	public void testCostruttoreParametriLibro() {
		assertEquals("Test costruttore default controllo libro" , libroTest , catalogoTest.getLibri().get(0));
	}
	
	@Test
	public void testCostruttoreParametriCollocazione() {
		assertEquals("Test costruttore default controllo collocazione" , collocazioneTest , catalogoTest.getCollocazioni().get(0));
	}
	
	@Test
	public void testSetTipo() {
		catalogoTestEmpty.setTipo("Trattati scientifici");
		assertEquals("Test set tipo catalogo" , "Trattati scientifici" , catalogoTestEmpty.getTipo());
	}
	
	@Test
	public void testSetAddLibri() {
		ArrayList<Libro> libriTest = new ArrayList<Libro>();
		libriTest.add(libroTest);
		catalogoTestEmpty.setLibri(libriTest);
		catalogoTestEmpty.addLibro(libroTest);
		assertEquals("Test set libri catalogo" , libriTest , catalogoTestEmpty.getLibri());
	}
	
	@Test
	public void testSetAddCollocazioni() {
		ArrayList<Collocazione> collocazioniTest = new ArrayList<Collocazione>();
		collocazioniTest.add(collocazioneTest);
		catalogoTestEmpty.setCollocazioni(collocazioniTest);
		catalogoTestEmpty.addCollocazione(collocazioneTest);
		assertEquals("Test set collocazioni catalogo" , collocazioniTest , catalogoTestEmpty.getCollocazioni());
	}
	

}
