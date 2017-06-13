/**
 * 
 */
package test_strutturali_biblioteca;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Abbonamento;
import Biblioteca.Biblioteca;
import Biblioteca.Catalogo;
import Biblioteca.Collocazione;
import Biblioteca.Consultazione;
import Biblioteca.Gestore;
import Biblioteca.Libro;
import Biblioteca.Prestito;
import Biblioteca.Recensione;
import Biblioteca.UtenteRegistrato;

/**
 * @author Mauro
 *
 */
public class test_suite_strutturali_gestore {
	Biblioteca bibliotecaTest = new Biblioteca("Biblioteca Lercari","Villa Imperiale" , "010882356998");
	UtenteRegistrato utenteTest = new UtenteRegistrato("Mauro","Angelini","25","Via P","mauro88ge@gmail.com","32056889225","mauro","Mauro.88");
	ArrayList<UtenteRegistrato> arrayUtenti = new ArrayList<UtenteRegistrato>();
	Abbonamento abbonamentoTest = new Abbonamento(LocalDate.of(2017, 06, 11),LocalDate.of(2017, 07, 11),true,utenteTest);
	ArrayList<Abbonamento> arrayAbbonamenti = new ArrayList<Abbonamento>();
	Collocazione collocazioneTest = new Collocazione("A" , "Turismo" , "12345" , bibliotecaTest);
	ArrayList<Collocazione> arrayCollocazioni = new ArrayList<Collocazione>();
	Libro libroTest = new Libro(true , "ISBN 978-88-540-3041-1" , "Brasile" , "NationalGeografic" , "WS" , 2017);
	ArrayList<Libro> arrayLibri = new ArrayList<Libro>();
	Consultazione consultazioneTest = new Consultazione(LocalDateTime.of(2017, 06, 11, 11, 00) , LocalDateTime.of(2017, 06, 11, 18, 00) , libroTest , utenteTest);
	ArrayList<Consultazione> arrayConsultazioni = new ArrayList<Consultazione>();
	Prestito prestitoTest = new Prestito(LocalDate.of(2017, 06, 25),LocalDate.of(2017, 07, 25),utenteTest,libroTest);
	ArrayList<Prestito> arrayPrestiti = new ArrayList<Prestito>();
	Catalogo catalogoTest = new Catalogo("Librario" , libroTest , collocazioneTest );
	Recensione recensioneTest = new Recensione("5" , "Descrizione" , libroTest , utenteTest );
	ArrayList<Recensione> arrayRecensioni = new ArrayList<Recensione>();
	Gestore gestoreTestEmpty = new Gestore();
	Integer id = 1;
	Gestore gestoreTest = new Gestore(id,libroTest,arrayRecensioni,catalogoTest,arrayConsultazioni,arrayAbbonamenti,arrayUtenti,arrayPrestiti);


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
	public void testCostruttoreDefaultUtenteLogin() {
		assertEquals("Test costruttore default controllo utente login" , null , gestoreTestEmpty.getUtentelogin());
	}
	
	@Test
	public void testCostruttoreDefaultIsLogin() {
		assertEquals("Test costruttore default controllo utente � login" , false , gestoreTestEmpty.isLogin());
	}
	
	@Test
	public void testCostruttoreParametriIdUtenteLogin() {
		assertEquals("Test costruttore parametri controllo id utente login" , id , gestoreTest.getIdUtenteLogin());
	}
	
	@Test
	public void testCostruttoreParametriLibroSuggerito() {
		assertEquals("Test costruttore parametri controllo libro suggerito" , libroTest , gestoreTest.getLibroSuggerito());
	}
	
	@Test
	public void testCostruttoreParametriRecensioni() {
		assertEquals("Test costruttore parametri controllo lista recensioni" , arrayRecensioni , gestoreTest.getRecensioni());
	}
	
	@Test
	public void testCostruttoreParametriCatalogo() {
		assertEquals("Test costruttore parametri controllo catalogo" , catalogoTest , gestoreTest.getCatalogo());
	}
	
	@Test
	public void testCostruttoreParametriConsultazioni() {
		assertEquals("Test costruttore parametri controllo lista consultazioni" , arrayConsultazioni , gestoreTest.getConsultazioni());
	}
	
	@Test
	public void testCostruttoreParametriAbbonamenti() {
		assertEquals("Test costruttore parametri controllo lista abbonamenti" , arrayAbbonamenti , gestoreTest.getAbbonamenti());
	}
	
	@Test
	public void testCostruttoreParametriUtentiRegistrati() {
		assertEquals("Test costruttore parametri lista utenti registrati" , arrayUtenti , gestoreTest.getUtentiRegistrati());
	}
	
	@Test
	public void testCostruttoreParametriPrestiti() {
		assertEquals("Test costruttore parametri lista prestiti" , arrayPrestiti , gestoreTest.getPrestiti());
	}
	
	@Test
	public void testAddRecensione() {
		gestoreTest.addRecensione(recensioneTest);
		assertEquals("Test add recensione" , recensioneTest , gestoreTest.getRecensioni().get(0));
	}
	
	@Test
	public void testAddAbbonamenti() {
		gestoreTest.addAbbonamenti(abbonamentoTest);
		assertEquals("Test add abbonamenti" , abbonamentoTest , gestoreTest.getAbbonamenti().get(0));
	}
	
	@Test
	public void testAddUtentiRegistrati() {
		gestoreTest.addUtenteRegistrato(utenteTest);
		assertEquals("Test add utenti registrati" , utenteTest , gestoreTest.getUtentiRegistrati().get(0));
	}
	
	@Test
	public void testAddPrestito() {
		gestoreTest.addPrestito(prestitoTest);
		assertEquals("Test add prestito" , prestitoTest , gestoreTest.getPrestiti().get(0));
	}
	
	@Test
	public void testSetGetCatalogo() {
		gestoreTestEmpty.setCatalogo(catalogoTest);
		assertEquals("Test set get catalogo" , catalogoTest , gestoreTestEmpty.getCatalogo());
	}
	
	@Test
	public void testSetGetUtentiRegistrati() {
		gestoreTestEmpty.setUtentiRegistrati(arrayUtenti);
		assertEquals("Test set get utenti" , arrayUtenti , gestoreTestEmpty.getUtentiRegistrati());
	}
	
	@Test 
	public void testSetGetUtenteLogin() {
		gestoreTestEmpty.setUtentelogin(utenteTest);
		assertEquals("Test set get utente login" , utenteTest , gestoreTestEmpty.getUtentelogin());
	}
	
	@Test
	public void testSetGetLogin() {
		gestoreTestEmpty.setLogin(true);
		assertEquals("Test set get login" , true , gestoreTestEmpty.isLogin());
	}
	
	@Test
	public void testSetGetIdLogin() {
		gestoreTestEmpty.setIdUtenteLogin(id);
		assertEquals("Test set get id utente login" , id , gestoreTestEmpty.getIdUtenteLogin());
	}
	
	@Test
	public void testSetGetLibroSuggerito() {
		gestoreTestEmpty.setLibroSuggerito(libroTest);
		assertEquals("Test set get libro suggerito" , libroTest , gestoreTestEmpty.getLibroSuggerito());
	}
	
	@Test
	public void testSetGetRecensioni() {
		gestoreTestEmpty.setRecensioni(arrayRecensioni);
		assertEquals("Test set get recensioni" , arrayRecensioni , gestoreTestEmpty.getRecensioni());
	}
	
	@Test
	public void testSetGetConsultazioni() {
		gestoreTestEmpty.setConsultazioni(arrayConsultazioni);
		assertEquals("Test set get consultazioni" , arrayConsultazioni , gestoreTestEmpty.getConsultazioni());
	}
	
	@Test
	public void testSetGetAbbonamenti() {
		gestoreTestEmpty.setAbbonamenti(arrayAbbonamenti);
		assertEquals("Test set get abbonamenti" , arrayAbbonamenti , gestoreTestEmpty.getAbbonamenti());
	}
	
	@Test
	public void testSetGetPrestiti() {
		gestoreTestEmpty.setPrestiti(arrayPrestiti);
		assertEquals("Test set get equals" , arrayPrestiti , gestoreTestEmpty.getPrestiti());
	}
	
	@Test
	public void testSetGetLibriRicerca() {
		gestoreTestEmpty.setLibriRicerca(arrayLibri);
		assertEquals("Test set get libri ricerca" , arrayLibri , gestoreTestEmpty.getLibriRicerca());		
	}
	
	@Test
	public void testSetGetCollocazioni() {
		gestoreTestEmpty.setCollocazioniRicerca(arrayCollocazioni);
		assertEquals("Test set get collocazioni" , arrayCollocazioni , gestoreTestEmpty.getCollocazioniRicerca());
	}
	
	@Test
	public void testIscriviSuccesso() throws IOException {
		UtenteRegistrato utenteCorretto = new UtenteRegistrato("Michele","Angelini","14","Via piantelli 2A","michele25ge@gmail.com","3346599851335","michele","Michele.88");
		gestoreTestEmpty.iscrivi(utenteCorretto);
		assertEquals("Test iscrizione utente andata a buon fine" , utenteCorretto , gestoreTestEmpty.getUtentiRegistrati().get(0));
	}
	
	@Test
	public void testIscriviEtaErrata() throws IOException {
		UtenteRegistrato utenteCorretto = new UtenteRegistrato("Michele","Angelini","14","Via piantelli 2A","michele25ge@gmail.com","3346599851335","michele","Michele.88");
		UtenteRegistrato utenteUsernameErrato = new UtenteRegistrato("Michele","Angelini","12","Via piantelli 2A","michele25ge@gmail.com","3346599851335","mick","Michele.88");
		gestoreTestEmpty.iscrivi(utenteCorretto);
		gestoreTestEmpty.iscrivi(utenteUsernameErrato);
		assertEquals("Test iscrizione utente non andata a buon fine per username gi� esistente" ,  utenteCorretto , gestoreTestEmpty.getUtentiRegistrati().get(gestoreTestEmpty.getUtentiRegistrati().size()-1));
	}
	
	@Test
	public void testIscriviUsernameErrato() throws IOException {
		UtenteRegistrato utenteCorretto = new UtenteRegistrato("Michele","Angelini","14","Via piantelli 2A","michele25ge@gmail.com","3346599851335","michele","Michele.88");
		UtenteRegistrato utenteUsernameErrato = new UtenteRegistrato("Michele","Angelini","14","Via piantelli 2A","michele25ge@gmail.com","3346599851335","michele","Michele.88");
		gestoreTestEmpty.iscrivi(utenteCorretto);
		gestoreTestEmpty.iscrivi(utenteUsernameErrato);
		assertEquals("Test iscrizione utente non andata a buon fine per username gi� esistente" ,  utenteCorretto , gestoreTestEmpty.getUtentiRegistrati().get(gestoreTestEmpty.getUtentiRegistrati().size()-1));
	}
	
	@Test
	public void testIscriviPasswordErrata() throws IOException {
		UtenteRegistrato utenteCorretto = new UtenteRegistrato("Michele","Angelini","14","Via piantelli 2A","michele25ge@gmail.com","3346599851335","michele","Michele.88");
		UtenteRegistrato utenteUsernameErrato = new UtenteRegistrato("Michele","Angelini","14","Via piantelli 2A","michele25ge@gmail.com","3346599851335","mick","Michele88");
		gestoreTestEmpty.iscrivi(utenteCorretto);
		gestoreTestEmpty.iscrivi(utenteUsernameErrato);
		assertEquals("Test iscrizione utente non andata a buon fine per username gi� esistente" ,  utenteCorretto , gestoreTestEmpty.getUtentiRegistrati().get(gestoreTestEmpty.getUtentiRegistrati().size()-1));
	}
	
	@Test
	public void testLogInSuccesso() throws IOException {
		gestoreTest.addUtenteRegistrato(utenteTest);
		gestoreTest.logIn(utenteTest.getUsername(), utenteTest.getPassword());
		assertEquals("Test log in utente andata a buon fine" , utenteTest , gestoreTest.getUtentelogin());
	}
	
	@Test
	public void testLogInUsernameErrato() throws IOException {
		gestoreTest.addUtenteRegistrato(utenteTest);
		gestoreTest.logIn("maur", utenteTest.getPassword());
		assertEquals("Test log in utente non andata a buon fine per username errato" , null , gestoreTest.getUtentelogin());
	}
	
	@Test
	public void testLogInPasswordErrata() throws IOException {
		gestoreTest.addUtenteRegistrato(utenteTest);
		gestoreTest.logIn(utenteTest.getUsername(), "Mauro.888");
		assertEquals("Test log in utente non andata a buon fine per password errata" , null , gestoreTest.getUtentelogin());
	}
	
	@Test
	public void testLogOut() throws IOException {
		gestoreTest.setUtentelogin(utenteTest);
		gestoreTest.logOut();
		assertEquals("Test log out utente" , null , gestoreTest.getUtentelogin());
	}
	
	
	
	@Test
	public void testRicerca1() throws IOException {
		Libro libroVuoto = new Libro(false,"","","","",0);
		gestoreTest.ricerca(libroVuoto);
		assertEquals("Test ricerca con tutti i campi vuoti" , 0 , gestoreTest.getLibriRicerca().size());
		
	}
	
	@Test
	public void testRicerca2() throws IOException {
		Libro libroCE = new Libro(false,"","","","WS",0);
		gestoreTest.ricerca(libroCE);
		assertEquals("Test ricerca per casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	
	
	@Test
	public void testRicerca3() throws IOException {
		Libro libroAU = new Libro(false,"","","NationalGeografic","",0);
		gestoreTest.ricerca(libroAU);
		assertEquals("Test ricerca per autore" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca4() throws IOException {
		Libro libroAUCE = new Libro(false,"","","NationalGeografic","WS",0);
		gestoreTest.ricerca(libroAUCE);
		assertEquals("Test ricerca per autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca5() throws IOException {
		Libro libroTI = new Libro(false,"","Brasile","","",0);
		gestoreTest.ricerca(libroTI);
		assertEquals("Test ricerca per titolo" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca6() throws IOException {
		Libro libroTICE = new Libro(false,"","Brasile","","WS",0);
		gestoreTest.ricerca(libroTICE);
		assertEquals("Test ricerca per titolo e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca7() throws IOException {
		Libro libroTIAU = new Libro(false,"","Brasile","NationalGeografic","",0);
		gestoreTest.ricerca(libroTIAU);
		assertEquals("Test ricerca per titolo e autore" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca8() throws IOException {
		Libro libroTIAUCE = new Libro(false,"","Brasile","NationalGeografic","WS",0);
		gestoreTest.ricerca(libroTIAUCE);
		assertEquals("Test ricerca per titolo, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca9() throws IOException {
		Libro libroIS = new Libro(false,"ISBN 978-88-540-3041-1","","","",0);
		gestoreTest.ricerca(libroIS);
		assertEquals("Test ricerca per ISBN" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca10() throws IOException {
		Libro libroISCE = new Libro(false,"ISBN 978-88-540-3041-1","","","WS",0);
		gestoreTest.ricerca(libroISCE);
		assertEquals("Test ricerca per ISBN e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
	}
	
	@Test
	public void testRicerca11() throws IOException {
		Libro libroISAU = new Libro(false,"ISBN 978-88-540-3041-1","","NationalGeografic","",0);
		gestoreTest.ricerca(libroISAU);
		assertEquals("Test ricerca per ISBN e autore" , libroTest , gestoreTest.getLibriRicerca().get(0));
	}
	
	@Test
	public void testRicerca12() throws IOException {
		Libro libroISAUCE = new Libro(false,"ISBN 978-88-540-3041-1","","NationalGeografic","WS",0);
		gestoreTest.ricerca(libroISAUCE);
		assertEquals("Test ricerca per ISBN, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));	
	}
	
	@Test
	public void testRicerca13() throws IOException {
		Libro libroISTI = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","","",0);
		gestoreTest.ricerca(libroISTI);
		assertEquals("Test ricerca per ISBN, titolo" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca14() throws IOException {
		Libro libroISTICE = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","","WS",0);
		gestoreTest.ricerca(libroISTICE);
		assertEquals("Test ricerca per ISBN, titolo e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca15() throws IOException {
		Libro libroISTIAU = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","NationalGeografic","",0);
		gestoreTest.ricerca(libroISTIAU);
		assertEquals("Test ricerca per ISBN, titolo, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testRicerca16() throws IOException {
		Libro libroISTIAUCE = new Libro(false,"ISBN 978-88-540-3041-1","Brasile","NationalGeografic","WS",0);
		gestoreTest.ricerca(libroISTIAUCE);
		assertEquals("Test ricerca per ISBN, titolo, autore e casa editrice" , libroTest , gestoreTest.getLibriRicerca().get(0));
		
	}
	
	@Test
	public void testPrestitoLibroDisponibilePresenteUtente() throws IOException {
		gestoreTest.prestito(utenteTest, libroTest);
		assertEquals("Test prestito con successo controllo utente" , utenteTest , gestoreTest.getPrestiti().get(0).getUtenteRegistrato());
		
	}
	
	@Test
	public void testPrestitoLibroDisponibilePresenteLibro() throws IOException {
		gestoreTest.prestito(utenteTest, libroTest);
		assertEquals("Test prestito con successo controllo libro" , libroTest , gestoreTest.getPrestiti().get(0).getLibri());
		
	}
	
	@Test
	public void testPrestitoLibroNonDisponibile() throws IOException {
		Libro libroNonDisponibile = new Libro(false,"","","","",0);
		gestoreTest.prestito(utenteTest, libroNonDisponibile);
		assertEquals("Test prestito fallito controllo utente" , 0 , gestoreTest.getPrestiti().size());
		
	}
	
	@Test
	public void testAbbonamento() throws IOException {
		gestoreTest.iscrivi(utenteTest);
		gestoreTest.logIn("mauro", "Mauro.88");
		gestoreTest.abbonamento();
		
		assertEquals("Test abbonamento" , utenteTest , gestoreTest.getUtentelogin());
	}
	
	@Test
	public void testRecensioneEsitoPositivo() throws IOException {
		Integer voto = 5;
		assertEquals("Test recensione controllo esito", true , gestoreTest.recensione(0, voto, "Bello", libroTest));
	}
	
	@Test
	public void testRecensioneEsitoNegativoValoreSottoRange() throws IOException {
		Integer voto = 0;
		assertEquals("Test recensione controllo esito", false , gestoreTest.recensione(0, voto, "Bello", libroTest));
	}
	
	@Test
	public void testRecensioneEsitoNegativoValoreSopraRange() throws IOException {
		Integer voto = 6;
		assertEquals("Test recensione controllo esito", false , gestoreTest.recensione(0, voto, "Bello", libroTest));
	}
	
	@Test
	public void testRecensioneVoto() throws IOException {
		Integer voto = 5;
		gestoreTest.recensione(0, voto, "Bello", libroTest);
		assertEquals("Test recensione controllo voto", voto , gestoreTest.getRecensioni().get(0).getVoto());
	}
	
	@Test
	public void testRecensioneDescrizione() throws IOException {
		Integer voto = 5;
		gestoreTest.recensione(0, voto, "Bello", libroTest);
		assertEquals("Test recensione controllo descrizione", "Bello" , gestoreTest.getRecensioni().get(0).getDescrizione());
	}
	
	@Test
	public void testRecensioneLibro() throws IOException {
		Integer voto = 5;
		gestoreTest.recensione(0, voto, "Bello", libroTest);
		assertEquals("Test recensione controllo libro", libroTest , gestoreTest.getRecensioni().get(0).getLibro());
	}
	
	@Test
	public void testRecensioneLoginEsitoPositivo() throws IOException {
		Integer voto = 5;
		assertEquals("Test recensione controllo esito", true , gestoreTest.recensionelogin(0, voto, "Bello", libroTest , utenteTest));
	}
	
	@Test
	public void testRecensioneLoginEsitoNegativoValoreSottoRange() throws IOException {
		Integer voto = 0;
		assertEquals("Test recensione controllo esito", false , gestoreTest.recensionelogin(0, voto, "Bello", libroTest , utenteTest));
	}
	
	@Test
	public void testRecensioneLoginEsitoNegativoValoreSopraRange() throws IOException {
		Integer voto = 6;
		assertEquals("Test recensione controllo esito", false , gestoreTest.recensionelogin(0, voto, "Bello", libroTest  , utenteTest));
	}
	
	@Test
	public void testRecensioneLoginVoto() throws IOException {
		Integer voto = 5;
		gestoreTest.recensionelogin(0, voto, "Bello", libroTest,utenteTest);
		assertEquals("Test recensione controllo voto", voto , gestoreTest.getRecensioni().get(0).getVoto());
	}
	
	@Test
	public void testRecensioneLoginDescrizione() throws IOException {
		Integer voto = 5;
		gestoreTest.recensionelogin(0, voto, "Bello", libroTest,utenteTest);
		assertEquals("Test recensione controllo descrizione", "Bello" , gestoreTest.getRecensioni().get(0).getDescrizione());
	}
	
	@Test
	public void testRecensioneLoginLibro() throws IOException {
		Integer voto = 5;
		gestoreTest.recensionelogin(0, voto, "Bello", libroTest,utenteTest);
		assertEquals("Test recensione controllo libro", libroTest , gestoreTest.getRecensioni().get(0).getLibro());
	}
	
	@Test
	public void testRecensioneLoginUtente() throws IOException {
		Integer voto = 5;
		gestoreTest.recensionelogin(0, voto, "Bello", libroTest,utenteTest);
		assertEquals("Test recensione controllo libro", utenteTest , gestoreTest.getRecensioni().get(0).getUtenteRegistrato());
	}
	
	@Test
	public void testSingolaConsultazioneUtente() throws IOException {
		gestoreTest.singolaConsultazione(utenteTest, libroTest);
		assertEquals("Test singola consultazione utente" , utenteTest , gestoreTest.getConsultazioni().get(0).getUtenteRegistrato());
	}
	
	@Test
	public void testSingolaConsultazioneLibro() throws IOException {
		gestoreTest.singolaConsultazione(utenteTest, libroTest);
		assertEquals("Test singola consultazione libro" , libroTest , gestoreTest.getConsultazioni().get(0).getLibro());
	}
	
	@Test
	public void testSingolaConsultazionePagato() throws IOException {
		gestoreTest.singolaConsultazione(utenteTest, libroTest);
		assertEquals("Test singola consultazione pagato" , true , gestoreTest.getConsultazioni().get(0).isPagato());
	}
	
	@Test
	public void testCheckUsernameErrato() {
		String usernameErrato = "Mik";
		assertEquals("Test check username controllo valore errato" , false , gestoreTest.checkUsername(usernameErrato));
		
	}
	
	@Test
	public void testCheckUsernameCorrettoPresente() {
		gestoreTest.addUtenteRegistrato(utenteTest);
		assertEquals("Test check username corretto e presente" , false , gestoreTest.checkUsername(utenteTest.getUsername()));
		
	}
	
	@Test
	public void testCheckUsernameCorrettoNonPresente() {
		assertEquals("Test check username corretto e non presente" , true , gestoreTest.checkUsername(utenteTest.getUsername()));
		
	}
	
	@Test
	public void testCheckUsernameLoginNonPresente() {
		assertEquals("Test check username login corretto e non presente" , false , gestoreTest.checkUsernameLogin(utenteTest.getUsername()));
		
	}
	
	@Test
	public void testCheckUsernameLoginPresente() {
		gestoreTest.addUtenteRegistrato(utenteTest);
		assertEquals("Test check username corretto login e non presente" , true , gestoreTest.checkUsernameLogin(utenteTest.getUsername()));
	}
	
	@Test
	public void testCheckPasswordErrataCorta() {
		assertEquals("Test password non corretta controllo lunghezza" , false , gestoreTest.checkPassword("Mauro.8"));
	}
	
	@Test
	public void testCheckPasswordErrataNoMaiuscole() {
		assertEquals("Test password non corretta controllo maiuscole" , false , gestoreTest.checkPassword("mauro.88"));
	}
	
	@Test
	public void testCheckPasswordErrataNoPunteggiatura() {
		assertEquals("Test password non corretta controllo punteggiatura" , false , gestoreTest.checkPassword("Mauro888"));
	}
	
	@Test
	public void testCheckPasswordErrataNoNumeri() {
		assertEquals("Test password non corretta controllo numeri" , false , gestoreTest.checkPassword("Mauro.oo"));
	}
	
	@Test
	public void testCheckPasswordErrataSpazi() {
		assertEquals("Test password non corretta controllo spazi" , false , gestoreTest.checkPassword("Mauro.88 "));
	}
	
	@Test
	public void testCheckPasswordLoginPresente() {
		gestoreTest.setIdUtenteLogin(0);
		gestoreTest.addUtenteRegistrato(utenteTest);
		assertEquals("Test password utente login presente" , true , gestoreTest.checkPasswordLogin(utenteTest.getPassword()));
	}
	
	@Test
	public void testCheckPasswordLoginNonPresente() {
		gestoreTest.setIdUtenteLogin(0);
		gestoreTest.addUtenteRegistrato(utenteTest);
		assertEquals("Test password utente login presente" , false , gestoreTest.checkPasswordLogin("PasswordErrata"));
	}
	
	@Test
	public void testCheckEtaCorretta() {
		assertEquals("Test check eta corretta" , true , gestoreTest.checkEta("13"));
	}
	
	@Test
	public void testCheckEtaNonCorretta() {
		assertEquals("Test check eta non corretta < 13" , false , gestoreTest.checkEta("12"));
	}
	
	@Test
	public void testCheckEtaErroreDigitazione() {
		assertEquals("Test check eta corretta" , false , gestoreTest.checkEta("1�"));
	}
	
	@Test
	public void testSuggerisciLibro() throws IOException {
		gestoreTest.suggerisciAcquisto(libroTest);
		assertEquals("Test libro suggerito corretto" , libroTest , gestoreTest.getLibroSuggerito());
	}
	
}
