package Biblioteca;

/**
 * Classe che memorizza tutti i dati necessari per un libro:
 * 	ISBN, Titolo, Autore, Casa Editrice, Anno Edizione 
 *  e infine la disponibilità al prestito e/o consultazione
 * @author Mauro
 *
 */
public class Libro {
	
	boolean Disponibile;
	String ISBN;
	String Titolo;
	String Autore;
	String CasaEditrice;
	int AnnoEdizione;
	/**
	 * Costruttore di default
	 */
	public Libro(){
		Disponibile = false;
		ISBN = null;
		Titolo = null;
		Autore = null;
		CasaEditrice = null;
		AnnoEdizione = 0;
	}
	/**
	 * Costruttore con parametri
	 * @param disponibile Variabile booleana che indica se il libro è disponibile al prestito
	 * @param iSBN Codice univoco internazionale di identificazione di un libro
	 * @param titolo Titolo del libro
	 * @param autore Nome dell'autore del libro
	 * @param casaEditrice Casa editrice del libro
	 * @param annoEdizione Anno in cuiè stato stampato il libro
	 */
	public Libro(boolean disponibile, String iSBN, String titolo, String autore, String casaEditrice, int annoEdizione) {
		super();
		Disponibile = disponibile;
		ISBN = iSBN;
		Titolo = titolo;
		Autore = autore;
		CasaEditrice = casaEditrice;
		AnnoEdizione = annoEdizione;
	}
	/**
	 * Metodo che ritorna vero se il libro è disponibile al prestito/consultazione viceversa falso
	 * @return	Variabile booleana che indica se il libro è disponibile al prestito
	 */
	public boolean isDisponibile() {
		return Disponibile;
	}
	/**
	 *  Metodo che permette di settare vero se il libro è disponibile al prestito/consultazione viceversa falso
	 * @param disponibile Variabile booleana che indica se il libro è disponibile al prestito
	 */
	public void setDisponibile(boolean disponibile) {
		Disponibile = disponibile;
	}
	/**
	 * Metodo che restituisce l'ISBN del libro
	 * @return ISBN del libro
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * Metodo che permette di settare l'ISBN del libro
	 * @param iSBN ISBN del libro
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	/**
	 * Metodo che restituisce Titolo del libro
	 * @return TItolo del libro
	 */
	public String getTitolo() {
		return Titolo;
	}
	/**
	 * Metodo che permette di settare Titolo del libro
	 * @param titolo Titolo del libro
	 */
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	/**
	 * Metodo che restituisce Autore del libro
	 * @return Autore del libro
	 */
	public String getAutore() {
		return Autore;
	}
	/**
	 * Metodo che permette di settare Autore del libro
	 * @param autore Autore del libro
	 */
	public void setAutore(String autore) {
		Autore = autore;
	}
	/**
	 * Metodo che restituisce la casa editrice del libro
	 * @return Casa editrice del libro
	 */
	public String getCasaEditrice() {
		return CasaEditrice;
	
	}
	/**
	 * Metodo che permette di settare la casa editrice del libro
	 * @param casaEditrice Casa editrice del libro
	 */
	public void setCasaEditrice(String casaEditrice) {
		CasaEditrice = casaEditrice;
	
	}
	/**
	 * Metodo che restituisce l'anno edizione del libro
	 * @return Anno edizione del libro
	 */
	public int getAnnoEdizione() {
		return AnnoEdizione;
	}
	/**
	 * Metodo che permette di settare l'anno edizione del libro
	 * @param annoEdizione Anno edizione del libro
	 */
	public void setAnnoEdizione(int annoEdizione) {
		AnnoEdizione = annoEdizione;
	}
	/**
	 * Metodo che stampa a video i dati del libro
	 */

	public void stampaLibro(){
		System.out.println();
		System.out.println("Dati libro");
		System.out.println();
		System.out.println("Disponibile: " + Disponibile);
		System.out.println("ISBN: " + ISBN);
		System.out.println("Titolo: " + Titolo);
		System.out.println("Autore: " + Autore);
		System.out.println("CasaEditrice: " + CasaEditrice);
		System.out.println("AnnoEdizione: " + AnnoEdizione);
	}

	
}
