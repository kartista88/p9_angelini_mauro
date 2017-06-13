package test_funzionali_biblioteca;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Biblioteca.Gestore;
import Biblioteca.UtenteRegistrato;

public class test_suite_funzionali_iscriversi {
	Gestore gestoreTest = new Gestore();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		FileReader fileUser;
		String line = null;
		fileUser = new FileReader("User.txt");

		BufferedReader bufferUser;
		bufferUser = new BufferedReader(fileUser);
		UtenteRegistrato u = new UtenteRegistrato();
		line = bufferUser.readLine();
		u.setNome(line);
		line = bufferUser.readLine();
		u.setCognome(line);
		line = bufferUser.readLine();
		u.setEta(line);
		line = bufferUser.readLine();
		u.setIndirizzo(line);
		line = bufferUser.readLine();
		u.setEmail(line);
		line = bufferUser.readLine();
		u.setTelefono(line);
		line = bufferUser.readLine();
		u.setUsername(line);
		line = bufferUser.readLine();
		u.setPassword(line);
		gestoreTest.addUtenteRegistrato(u);
		bufferUser.close();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIscrizioneSuccesso() throws IOException {
		UtenteRegistrato utenteCorretto= new UtenteRegistrato("Paolo" , "Angelini" , "57" , "Via piantelli 2A" , "paolo88ge@gmail.com" , "356888569852" , "paolo" , "Paolo.88");
		gestoreTest.iscrivi(utenteCorretto);
		assertEquals("Test iscrizione corretto" , utenteCorretto , gestoreTest.getUtentiRegistrati().get(1));
	}
	
	@Test
	public void testIscrizioneErrataEta() throws IOException {
		UtenteRegistrato utenteEtaErrata= new UtenteRegistrato("Paolo" , "Angelini" , "12" , "Via piantelli 2A" , "paolo88ge@gmail.com" , "356888569852" , "paolo" , "Paolo.88");
		gestoreTest.iscrivi(utenteEtaErrata);
		assertEquals("Test iscrizione et� errata" , 1 , gestoreTest.getUtentiRegistrati().size());
	}
	
	@Test
	public void testIscrizioneErrataUsername() throws IOException {
		UtenteRegistrato utenteUserNameErrato= new UtenteRegistrato("Paolo" , "Angelini" , "57" , "Via piantelli 2A" , "paolo88ge@gmail.com" , "356888569852" , "mauro" , "Paolo.88");
		gestoreTest.iscrivi(utenteUserNameErrato);
		assertEquals("Test iscrizione username errata" , 1 , gestoreTest.getUtentiRegistrati().size());
	}
	
	@Test
	public void testIscrizioneErrataPassword() throws IOException {
		UtenteRegistrato utentePasswordErrata= new UtenteRegistrato("Paolo" , "Angelini" , "57" , "Via piantelli 2A" , "paolo88ge@gmail.com" , "356888569852" , "paolo" , "Paolo88");
		gestoreTest.iscrivi(utentePasswordErrata);
		assertEquals("Test iscrizione password errata" , 1 , gestoreTest.getUtentiRegistrati().size());
	}

}
