package test_funzionali_biblioteca;

import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Biblioteca;
import Biblioteca.Catalogo;
import Biblioteca.Collocazione;
import Biblioteca.Gestore;
import Biblioteca.Libro;

public class test_suit_funzionali_ricercaprodotto {
	Gestore gestoreTest = new Gestore();
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "EdizioniWhiteStar" , 2016);
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Centrale" , "CorsoMarche34R" , "01854465254");
	Collocazione collocazioneTest = new Collocazione("Turismo" , "3" , "BR8" , bibliotecaTest);
	Catalogo catalogoTest = new Catalogo("Librario" , libroTest, collocazioneTest);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		gestoreTest.setCatalogo(catalogoTest);

	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testRicercaFallimentoCampivuoti() throws IOException {
		Libro libroVuoto = new Libro(false,"","","","",0);
		gestoreTest.ricerca(libroVuoto);
		assertEquals("Test ricerca con tutti i campi vuoti" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaSuccessoPerCasaEditrice() throws IOException {
		Libro libroCE = new Libro(false,"","","","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroCE);
		assertEquals("Test ricerca per casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));		
	}
	
	
	
	@Test
	public void testRicercaSuccessoPerAutore() throws IOException {
		Libro libroAU = new Libro(false,"","","NationalGeografic","",0);
		gestoreTest.ricerca(libroAU);
		assertEquals("Test ricerca per autore" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerAutoreCasaEditrice() throws IOException {
		Libro libroAUCE = new Libro(false,"","","NationalGeografic","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroAUCE);
		assertEquals("Test ricerca per autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerTitolo() throws IOException {
		Libro libroTI = new Libro(false,"","Brasile","","",0);
		gestoreTest.ricerca(libroTI);
		assertEquals("Test ricerca per titolo" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerTitoloCasaEditrice() throws IOException {
		Libro libroTICE = new Libro(false,"","Brasile","","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroTICE);
		assertEquals("Test ricerca per titolo e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerTitoloAutore() throws IOException {
		Libro libroTIAU = new Libro(false,"","Brasile","NationalGeografic","",0);
		gestoreTest.ricerca(libroTIAU);
		assertEquals("Test ricerca per titolo e autore" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerTitoloAutoreCasaEditrice() throws IOException {
		Libro libroTIAUCE = new Libro(false,"","Brasile","NationalGeografic","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroTIAUCE);
		assertEquals("Test ricerca per titolo, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerISBN() throws IOException {
		Libro libroIS = new Libro(false,"ISBN 978-88-540-3041-1","","","",0);
		gestoreTest.ricerca(libroIS);
		assertEquals("Test ricerca per ISBN" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerISBNCasaEd() throws IOException {
		Libro libroISCE = new Libro(false,"ISBN 978-88-540-3041-1","","","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroISCE);
		assertEquals("Test ricerca per ISBN e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
	}
	
	@Test
	public void testRicercaSuccessoPerISBNAutore() throws IOException {
		Libro libroISAU = new Libro(false,"ISBN 978-88-540-3041-1","","NationalGeografic","",0);
		gestoreTest.ricerca(libroISAU);
		assertEquals("Test ricerca per ISBN e autore" , libroTest , gestoreTest.getLibriRicerca().get(0));
	}
	
	@Test
	public void testRicercaSuccessoPerISBNAutoreCasaEditrice() throws IOException {
		Libro libroISAUCE = new Libro(false,"ISBN 978-88-540-3041-1","","NationalGeografic","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroISAUCE);
		assertEquals("Test ricerca per ISBN, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));	
	}
	
	@Test
	public void testRicercaSuccessoPerISBNTitolo() throws IOException {
		Libro libroISTI = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","","",0);
		gestoreTest.ricerca(libroISTI);
		assertEquals("Test ricerca per ISBN, titolo" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerISBNTitoloCasaEditrice() throws IOException {
		Libro libroISTICE = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroISTICE);
		assertEquals("Test ricerca per ISBN, titolo e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerISBNTitoloAutore() throws IOException {
		Libro libroISTIAU = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","NationalGeografic","",0);
		gestoreTest.ricerca(libroISTIAU);
		assertEquals("Test ricerca per ISBN, titolo, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaSuccessoPerISBNTitoloAutoreCasaEditrice() throws IOException {
		Libro libroISTIAUCE = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","NationalGeografic","EdizioniWhiteStar",0);
		gestoreTest.ricerca(libroISTIAUCE);
		assertEquals("Test ricerca per ISBN, titolo, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicercaFallimentoPerCasaEditrice() throws IOException {
		Libro libroCE = new Libro(false,"","","","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroCE);
		assertEquals("Test ricerca per casa editrice" , 0 , gestoreTest.getLibriRicerca().size());		
	}
	
	
	
	@Test
	public void testRicercaFallimentoPerAutore() throws IOException {
		Libro libroAU = new Libro(false,"","","NationalGeografi","",0);
		gestoreTest.ricerca(libroAU);
		assertEquals("Test ricerca per autore" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerAutoreCasaEditrice() throws IOException {
		Libro libroAUCE = new Libro(false,"","","NationalGeografi","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroAUCE);
		assertEquals("Test ricerca per autore e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerTitolo() throws IOException {
		Libro libroTI = new Libro(false,"","Brasil","","",0);
		gestoreTest.ricerca(libroTI);
		assertEquals("Test ricerca per titolo" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerTitoloCasaEditrice() throws IOException {
		Libro libroTICE = new Libro(false,"","Brasil","","EdizioniWhiteStr",0);
		gestoreTest.ricerca(libroTICE);
		assertEquals("Test ricerca per titolo e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerTitoloAutore() throws IOException {
		Libro libroTIAU = new Libro(false,"","Brasil","NationalGeografi","",0);
		gestoreTest.ricerca(libroTIAU);
		assertEquals("Test ricerca per titolo e autore" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerTitoloAutoreCasaEditrice() throws IOException {
		Libro libroTIAUCE = new Libro(false,"","Brasil","NationalGeografi","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroTIAUCE);
		assertEquals("Test ricerca per titolo, autore e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerISBN() throws IOException {
		Libro libroIS = new Libro(false,"ISBN 978-88-540-3041-","","","",0);
		gestoreTest.ricerca(libroIS);
		assertEquals("Test ricerca per ISBN" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerISBNCasaEd() throws IOException {
		Libro libroISCE = new Libro(false,"ISBN 978-88-540-3041-","","","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroISCE);
		assertEquals("Test ricerca per ISBN e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
	}
	
	@Test
	public void testRicercaFallimentoPerISBNAutore() throws IOException {
		Libro libroISAU = new Libro(false,"ISBN 978-88-540-3041-","","NationalGeografic","",0);
		gestoreTest.ricerca(libroISAU);
		assertEquals("Test ricerca per ISBN e autore" , 0 , gestoreTest.getLibriRicerca().size());
	}
	
	@Test
	public void testRicercaFallimentoPerISBNAutoreCasaEditrice() throws IOException {
		Libro libroISAUCE = new Libro(false,"ISBN 978-88-540-3041-","","NationalGeografi","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroISAUCE);
		assertEquals("Test ricerca per ISBN, autore e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());	
	}
	
	@Test
	public void testRicercaFallimentoPerISBNTitolo() throws IOException {
		Libro libroISTI = new Libro(false,"ISBN 978-88-540-3041-","Brasil","","",0);
		gestoreTest.ricerca(libroISTI);
		assertEquals("Test ricerca per ISBN, titolo" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerISBNTitoloCasaEditrice() throws IOException {
		Libro libroISTICE = new Libro(false,"ISBN 978-88-540-3041-","Brasil","","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroISTICE);
		assertEquals("Test ricerca per ISBN, titolo e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerISBNTitoloAutore() throws IOException {
		Libro libroISTIAU = new Libro(false,"ISBN 978-88-540-3041-","Brasil","NationalGeografi","",0);
		gestoreTest.ricerca(libroISTIAU);
		assertEquals("Test ricerca per ISBN, titolo, autore e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicercaFallimentoPerISBNTitoloAutoreCasaEditrice() throws IOException {
		Libro libroISTIAUCE = new Libro(false,"ISBN 978-88-540-3041-","Brasil","NationalGeografi","EdizioniWhiteSta",0);
		gestoreTest.ricerca(libroISTIAUCE);
		assertEquals("Test ricerca per ISBN, titolo, autore e casa editrice" , 0 , gestoreTest.getLibriRicerca().size());
		
	}

}
