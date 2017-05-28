package Biblioteca;

import java.time.*; 
/**
 * Classe che permette di memorizzare di i dati relativi a un prestito
 * ovvero associare un libro a un utente registrato gestendo la data di ritiro
 * e quella di conse
 * @author Mauro
 *
 */
public class Prestito {
	
	LocalDate DataRitiro;
	LocalDate DataConsegna;
	private UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
	private Libro libri = new Libro();
	/**
	 * Costruttore di default
	 */
	public Prestito(){
		DataRitiro = null;
		DataConsegna = null;
		utenteRegistrato = null;
	}
	/**
	 * Costruttore con parametri
	 * @param dataRitiro Data in cui l'utente puo ritirare il libro
	 * @param dataConsegna Data in cui l'utente può consegnare il libro
	 * @param utenteRegistrato Utente registrato che vuole effettuare il prestito
	 * @param libri Libro che l'utente vuole prendere in prestito
	 */
	public Prestito(LocalDate dataRitiro, LocalDate dataConsegna, UtenteRegistrato utenteRegistrato, Libro libri) {
		super();
		DataRitiro = dataRitiro;
		DataConsegna = dataConsegna;
		this.utenteRegistrato = utenteRegistrato;
		this.libri = libri;
	}
	/**
	 * 
	 */
	public void calcolaDataConsegna(){
		
	}
	/**
	 * Restituisce la data di ritiro del libro
	 * @return Data di ritiro
	 */
	public LocalDate getDataRitiro() {
		return DataRitiro;
	}
	/**
	 * Imposta la data di ritiro del libro
	 * @param dataRitiro Data di ritiro
	 */
	public void setDataRitiro(LocalDate dataRitiro) {
		DataRitiro = dataRitiro;
	}
	/**
	 * Restituisce la data di consegna del libro
	 * @return Data di consegna 
	 */
	public LocalDate getDataConsegna() {
		return DataConsegna;
	}
	/**
	 * Imposta la data di consegna del libro
	 * @param dataConsegna Data di consegna
	 */
	public void setDataConsegna(LocalDate dataConsegna) {
		DataConsegna = dataConsegna;
	}
	/**
	 * Restituisce il libro del prestito
	 * @return Libro del prestito
	 */
	public Libro getLibri() {
		return libri;
	}
	/**
	 * Imposta il libro del prestito
	 * @param libri Libro del prestito
	 */
	public void setLibri(Libro libri) {
		this.libri = libri;
	}
	/**
	 * Restituisce l'utente del prestito
	 * @return Utente del prestito
	 */
	public UtenteRegistrato getUtenteRegistrato() {
		return utenteRegistrato;
	}
	/**
	 * Imposta l'utente del prestito
	 * @param utenteRegistrato Utente del prestito
	 */
	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		this.utenteRegistrato = utenteRegistrato;
	}
	/**
	 * Stampa a video i dati del prestito
	 */
	public void stampaPrestito(){
		System.out.println("Dati prestito:");
		libri.stampaLibro();
		utenteRegistrato.stampaUtenteRegistrato();
		System.out.print("Data di ritiro: " + DataRitiro );
		System.out.println();
		System.out.print("Data di consegna: " + DataConsegna );
		System.out.println();
	}

	
}

