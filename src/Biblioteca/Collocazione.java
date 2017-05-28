package Biblioteca;

/**
 * Classe che memorizza i dati della collocazione di un libro
 * in modo che sia univoca e permetta la completa tracciabilità 
 * del libro
 * @author Mauro
 *
 */
public class Collocazione {
	String Sezione;
	String Scaffale;
	String NumeroSeriale;
	String Nome;
	String Indirizzo;
	String Telefono;
	Biblioteca biblioteca = new Biblioteca();
	/**
	 * Costruttre di default
	 */
	public Collocazione(){
		Sezione = null;
		Scaffale = null;
		NumeroSeriale = null;
		biblioteca = null;
	}
	/**
	 * Costruttore con parametri
	 * @param se sezione in cui è posizionato il libro
	 * @param sc scaffale in cui è posizionato il libro
	 * @param n numero seriale del libro
	 * @param b Biblioteca in cui è contenuto
	 */
	public Collocazione(String se, String sc, String n, Biblioteca b){
		Sezione = se;
		Scaffale = sc;
		NumeroSeriale = n;
		biblioteca = b;
	}
	/**
	 * Restituisce la sezione in cui è contenuto il libro
	 * @return Sezione in cui è contenuto il libro
	 */
	public String getSezione() {
		return Sezione;
	}
	/**
	 * Permette di impostare la sezione in cui è contenuti il libro
	 * @param sezione Sezione in cui è contenuto il libro
	 */
	public void setSezione(String sezione) {
		Sezione = sezione;
	}
	/**
	 * Restituisce lo scaffale in cui è contenuto il libro
	 * @return Scaffale in cui è contenuto il libro
	 */
	public String getScaffale() {
		return Scaffale;
	}
	/**
	 * Permette di impostare lo scaffale in cui è contenuto il libro
	 * @param scaffale Scaffale in cui è contenuto il libro
	 */
	public void setScaffale(String scaffale) {
		Scaffale = scaffale;
	}
	/**
	 * Restituisce il numero in cui è contenuto il libro
	 * @return Scaffale in cui è contenuto il libro
	 */
	public String getNumeroSeriale() {
		return NumeroSeriale;
	}
	/**
	 * Permette di impostare il numero seriale in cui è contenuto il libro
	 * @param numeroSeriale Numero seriale in cui è contenuto il libro
	 */
	public void setNumeroSeriale(String numeroSeriale) {
		NumeroSeriale = numeroSeriale;
	}
	
	/**
	 * Stampa a video tutti i dati relativi alla collocazione di un libro
	 */
	public void stampaCollocazione(){
		System.out.println();
		System.out.println("Collocazione libro");
		System.out.println();
		System.out.println("Sezione: " + Sezione);
		System.out.println("Scaffale: " + Scaffale);
		System.out.println("NumeroSeriale: " + NumeroSeriale);
		System.out.println("Dati Biblioteca:");
		System.out.println("Nome: " + Nome);
		System.out.println("Indirizzo: " + Indirizzo);
		System.out.println("Telefono: " + Telefono);
		System.out.println();
	}
	/**
	 * Restituisce i dati relativi alla biblioteca in cui è contenuto il libro
	 * @return Biblioteca in cui è contenuto il libro
	 */
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	/**
	 * Permette di associare una biblioteca alla collocazione
	 * @param biblioteca Biblioteca in cui è contenuto il libro
	 */
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	/**
	 * Restituisce il nome della biblioteca
	 * @return Nome biblioteca
	 */
	public String getNome() {
		return Nome;
	}
	/**
	 * Permette di inserire il nome della biblioteca
	 * @param nome Nome di biblioteca
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
	/**
	 * Restituisce l'indirizzo della biblioteca
	 * @return Indirizzo biblioteca
	 */
	public String getIndirizzo() {
		return Indirizzo;
	}
	/**
	 * Permette di impostare l'indirizzo della biblioteca
	 * @param indirizzo Indirizzo della biblioteca
	 */
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	/**
	 * Restituisce il numero di telefono della biblioteca
	 * @return Numero di telefono della biblioteca
	 */
	public String getTelefono() {
		return Telefono;
	}
	/**
	 * Permette di impostare il numero di telefono della biblioteca
	 * @param telefono Numero di telefono
	 */ 
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
}

