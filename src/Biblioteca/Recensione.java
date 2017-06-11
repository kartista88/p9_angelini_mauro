package Biblioteca;

/**
 * Classe che memorizza i dati di una recensione ovvero voto e giudizio personale 
 * @author Mauro
 *
 */
public class Recensione {
	
	Integer Voto;
	String Descrizione;
	private Libro libro = new Libro();
	private UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
	/**
	 * Costruttore di default
	 */
	public Recensione(){
		Voto = 0;
		Descrizione = null;
		libro = null;
		utenteRegistrato = null;
	}
	/**
	 * Costruttore con parametri
	 * @param voto Voto utente
	 * @param descrizione Descrizione utente
	 * @param libro Libro di cui l'utente fa la recensione
	 * @param utenteRegistrato Utente che fa la recensione
	 */
	public Recensione(Integer voto, String descrizione, Libro libro, UtenteRegistrato utenteRegistrato) {
		super();
		Voto = voto;
		Descrizione = descrizione;
		this.libro = libro;
		this.utenteRegistrato = utenteRegistrato;
	}
	/**
	 * Restituisce il voto della recensione
	 * @return Voto della recensione
	 */
	public Integer getVoto() {
		return Voto;
	}
	/**
	 * Permette di settare il voto della recensione
	 * @param voto Voto della recensione
	 */
	public void setVoto(Integer voto) {
		Voto = voto;
	}
	/**
	 * Restituisce la descrizione della recensione
	 * @return Descrizione della recensione
	 */
	public String getDescrizione() {
		return Descrizione;
	}
	/**
	 * Permette di settare la descrizione della recensione
	 * @param descrizione Descrizione della recensione
	 */
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	/**
	 * Restituisce il  libro della recensione
	 * @return Libro della recensione
	 */
	public Libro getLibro() {
		return libro;
	}
	/**
	 * Permette di settare il Libro della recensione
	 * @param libro Libro della recensione
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	/**
	 * Restituisce l'utente della recensione
	 * @return Utente della recensione
	 */
	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}
	/**
	 * Permette di settare l'utente della recension
	 * @param utenteRegistrato Utente della recensione
	 */
	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}
	
}
