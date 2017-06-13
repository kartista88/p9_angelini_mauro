package Biblioteca;

/**
 * Classe che permette di memorizzare i dati dell'utente dalle sue generalit� alle credenziale per
 * accedere alle funzioni speciali
 * @author Mauro
 *
 */
public class UtenteRegistrato {
	
	String Nome;
	String Cognome;
	String Eta;
	String Indirizzo;
	String Email;
	String Telefono;
	String Username;
	String Password;
	/**
	 * Costruttore di default
	 */
	public UtenteRegistrato(){
		Nome = "";
		Cognome = null;
		Eta = null;
		Indirizzo = null;
		Email = null;
		Telefono = null;
		Username = null;
		Password = null;
	}
	/**
	 * Costruttore con parametri
	 * @param nome Nome Utente
	 * @param cognome Cognoome Utente
	 * @param et� Et� Utente
	 * @param indirizzo Indirizzo Utente
	 * @param email Email Utente
	 * @param telefono Telefono Utente
	 * @param username Username Utente
	 * @param password Password Utente
	 */
	public UtenteRegistrato(String nome, String cognome, String eta, String indirizzo, String email, String telefono,
			String username, String password) {
		super();
		Nome = nome;
		Cognome = cognome;
		Eta = eta;
		Indirizzo = indirizzo;
		Email = email;
		Telefono = telefono;
		Username = username;
		Password = password;
	}
	/**
	 * Restituisce il nome dell'utente registrato
	 * @return Nome utente
	 */
	public String getNome() {
		return Nome;
	}
	/**
	 * Permette di settare il nome dell'utente registrato
	 * @param nome Nome utente
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
	/**
	 * Restituisce il cognnome dell'utente registrato
	 * @return Cognome utente
	 */
	public String getCognome() {
		return Cognome;
	}
	/**
	 * Permette di settare il cognome dell'utente registrato
	 * @param cognome Cognome utente
	 */
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	/**
	 * Restituisce l'et� dell'utente registrato
	 * @return Et� utente
	 */
	public String getEta() {
		return Eta;
	}
	/**
	 * Permette di settare l'et� dell'utente registrato
	 * @param et� Et� utente
	 */
	public void setEta(String eta) {
		Eta = eta;
	}
	/**
	 * Restituisce l'indirizzo dell'utente registrato
	 * @return Indirizzo utente
	 */
	public String getIndirizzo() {
		return Indirizzo;
	}
	/**
	 * Permette di settare l'indirizzo dell'utente registrato
	 * @param indirizzo Indirizzo utente
	 */
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	/**
	 * Restituisce l'email dell'utente registrato
	 * @return Email utente
	 */
	public String getEmail() {
		return Email;
	}
	/**
	 * Permette di settare l'email dell'utente registrato
	 * @param email Email utente
	 */
	public void setEmail(String email) {
		Email = email;
	}
	/**
	 * Restituisce il telefono dell'utente registrato
	 * @return Telefono utente
	 */
	public String getTelefono() {
		return Telefono;
	}
	/**
	 * Permette di settare il telefono dell'utente registrato
	 * @param telefono Telefono utente
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	/**
	 * Restituisce lo username dell'utente registrato
	 * @return Username utente
	 */
	public String getUsername() {
		return Username;
	}
	/**
	 * Permette di settare lo username dell'utente registrato
	 * @param username Username utente
	 */
	public void setUsername(String username) {
		Username = username;
	}
	/**
	 * Restituisce la password dell'utente registrato
	 * @return Password utente
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * Permette di settare la password dell'utente registrato
	 * @param password Password utente
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * Stampa a video i dati dell'utente
	 */
	public void stampaUtenteRegistrato(){
		System.out.println("Utente registrato:");
		System.out.println("Nome:		" + Nome);
		System.out.println("Cognome:	" + Cognome);
		System.out.println("Eta:		" + Eta);
		System.out.println("Indirizzo:	" + Indirizzo);
		System.out.println("Email:		" + Email);
		System.out.println("Telefono:	" + Telefono);
		System.out.println("Username:	" + Username);
		System.out.println("Password:	" + Password);
	}
}
