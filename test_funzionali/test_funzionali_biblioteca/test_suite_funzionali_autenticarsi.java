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

public class test_suite_funzionali_autenticarsi {
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
		u.setEtà(line);
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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginCorrettoControlloValore() throws IOException {
		gestoreTest.logIn("mauro" , "Mauro.88");
		assertEquals("Test log in corretto controllo valore log in" , true , gestoreTest.isLogin());
	}
	
	@Test
	public void testLoginCorrettoControlloUsername() throws IOException {
		gestoreTest.logIn("mauro" , "Mauro.88");
		assertEquals("Test log in corretto controllo username" , "mauro" , gestoreTest.getUtentelogin().getUsername());
	}
	
	@Test
	public void testLoginCorrettoControlloPassword() throws IOException {
		gestoreTest.logIn("mauro" , "Mauro.88");
		assertEquals("Test log in corretto controllo password" , "Mauro.88" , gestoreTest.getUtentelogin().getPassword());
	}
	
	@Test
	public void testLoginErratoUsernameControlloValore() throws IOException {
		gestoreTest.logIn("maro" , "Mauro.88");
		assertEquals("Test log in corretto controllo valore log in" , false , gestoreTest.isLogin());
	}
	
	@Test
	public void testLoginErratoUsernameControlloLogin() throws IOException {
		gestoreTest.logIn("maro" , "Mauro.88");
		assertEquals("Test log in corretto controllo username" , null , gestoreTest.getUtentelogin());
	}
	
	@Test
	public void testLoginErrataPasswordControlloValore() throws IOException {
		gestoreTest.logIn("maro" , "Mauro88");
		assertEquals("Test log in corretto controllo valore log in" , false , gestoreTest.isLogin());
	}
	
	@Test
	public void testLoginErrataPasswordControlloLogin() throws IOException {
		gestoreTest.logIn("mauro" , "Mauro88");
		assertEquals("Test log in corretto controllo username" , null , gestoreTest.getUtentelogin());
	}
	

}
