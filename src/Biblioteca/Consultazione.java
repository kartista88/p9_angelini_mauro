package Biblioteca;

import java.time.*;
/**
 * Classe che consente di memorizzare la consultazione singola di un utente registrato
 * @author Mauro
 *
 */
public class Consultazione {
	private boolean pagato = false;
	private LocalDateTime DataOraRitiro;
	private LocalDateTime DataOraConsegna;
	private Libro libro = new Libro();
	private UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
	/**
	 * Costruttore di default
	 */
	public Consultazione(){
		DataOraRitiro = null;
		DataOraConsegna = null;
		libro = null;
		utenteRegistrato = null;
	}
	/**
	 * Costruttore con parametri
	 * @param dr Data di ritiro libro
	 * @param dc Data di consegna libro
	 * @param l Dati del libro
	 * @param u Utente che effettua la consultazione
	 */
	public Consultazione(LocalDateTime dr, LocalDateTime dc, Libro l, UtenteRegistrato u){
		DataOraRitiro = dr;
		DataOraConsegna = dc;
		libro = l;
		utenteRegistrato = u;
	}
	/**
	 * Restituisce la data di ritiro
	 * @return Data di ritiro per l'utente
	 */
	public LocalDateTime getDataOraRitiro() {
		return DataOraRitiro;
	}
	/**
	 * Permette di impostare la data di ritiro
	 * @param dataOraRitiro Data di ritiro per l'utente
	 */
	public void setDataOraRitiro(LocalDateTime dataOraRitiro) {
		DataOraRitiro = dataOraRitiro;
	}
	
	/**
	 * Restituisce da di consegna
	 * @return Data di consegna per l'utente 
	 */
	public LocalDateTime getDataOraConsegna() {
		return DataOraConsegna;
	}
	/**
	 * Permette di impostare la data di consegna
	 * @param dataOraConsegna Data di consegna per l'utente 
	 */
	public void setDataOraConsegna(LocalDateTime dataOraConsegna) {
		DataOraConsegna = dataOraConsegna;
	}
	/**
	 * Restituisce il libro che l'utente vuole consultare
	 * @return Libro da consultare
	 */
	public Libro getLibro() {
		return libro;
	}
	/**
	 * Permette di impostare il libro che l'utente vuole consultare
	 * @param libro Libro da consultare
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	/**
	 * Restituisce i dati dell'utente che fa la consultazione
	 * @return Dati di utente che fa la consultazione
	 */
	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}
	/**
	 * Permette di impostare l'utente che fa la consultazione
	 * @param utenteRegistrato Dati di utente che fa la consultazione
	 */
	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}
	/**
	 * Restituisce lo stato di pagamento della singola consultazione
	 * @return Stato pagamento singola consultazione
	 */
	public boolean isPagato() {
		return pagato;
	}
	/**
	 * Permette di impostare lo stato di pagamento della singola consultazione
	 * @param pagato Stato pagamento della singola consultazione
	 */
	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}

}

