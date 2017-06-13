/*
 * Biblioteca
 */
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
	Biblioteca biblioteca = new Biblioteca();
	/**
	 * Costruttore di default
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
		System.out.println("Nome: " + biblioteca.getNome());
		System.out.println("Indirizzo: " + biblioteca.getIndirizzo());
		System.out.println("Telefono: " + biblioteca.getTelefono());
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
}

