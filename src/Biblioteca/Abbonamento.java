/*
 * Abbonamento
 */
package Biblioteca;

import java.time.*;

/**
 * Classe dove vengono memorizzati i dati relativi all'abbonamento
 * @author Mauro
 */
public class Abbonamento {

	





	private LocalDate DataInizio;
	private LocalDate DataFine;
	private Boolean Pagato;
	private UtenteRegistrato UtenteRegistrato = new UtenteRegistrato();

	
	/**
	 * Costruttore di default
	 */
	public Abbonamento(){
		DataInizio = null;
		DataFine = null;
		Pagato = false;
		UtenteRegistrato = null;
	}
	
	/**
	 * Costruttore con parametri
	 * @param dataInizio Data di inizio abbonamento
	 * @param dataFine Data di fine abbonamento
	 * @param pagato Variabile booleana che verifica lo stato di pagamento dell'abbonamento
	 * @param utenteRegistrato Utente a cui � intestato l'abbonamento
	 */
	public Abbonamento(LocalDate dataInizio, LocalDate dataFine, Boolean pagato,
			UtenteRegistrato utenteRegistrato) {
		super();
		DataInizio = dataInizio;
		DataFine = dataFine;
		Pagato = pagato;
		UtenteRegistrato = utenteRegistrato;
	}
	





	/**
	 * Restituisce la data di inizio abbonamento
	 * @return the dataInizio Data di inizio abbonamento
	 */
	public LocalDate getDataInizio() {
		return DataInizio;
	}






	/**
	 * Imposta la data di inizio abbonamento
	 * @param dataInizio the dataInizio to set Data di inizio abbonamento
	 */
	public void setDataInizio(LocalDate dataInizio) {
		DataInizio = dataInizio;
	}






	/**
	 * Restituisce la data di fine abbonamento
	 * @return the dataFine Data di fine abbonamento
	 */
	public LocalDate getDataFine() {
		return DataFine;
	}






	/**
	 * Imposta la data di fine abbonamento
	 * @param dataFine the dataFine to set Data di fine abbonamento
	 */
	public void setDataFine(LocalDate dataFine) {
		DataFine = dataFine;
	}






	/**
	 * Restituisce lo stato di pagamento dell'abbonamento
	 * @return the pagato Stato del pagamento dell'abbonamento
	 */
	public Boolean getPagato() {
		return Pagato;
	}






	/**
	 * Imposta lo stato di pagamento dell'abbonamento
	 * @param pagato the pagato to set Stato di pagamento dell'abbonamento
	 */
	public void setPagato(Boolean pagato) {
		Pagato = pagato;
	}






	/**
	 * Restituisce i dati dell'utente che ha effettuato l'abbonamento
	 * @return the utenteRegistrato Utente che ha effettuato l'abbonamento
	 */
	public UtenteRegistrato getUtenteRegistrato() {
		return UtenteRegistrato;
	}






	/**
	 * Imposta i dati dell'utente che ha effettuato abbonamento
	 * @param utenteRegistrato the utenteRegistrato to set Utente che ha effettuato l'abbonamento
	 */
	public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
		UtenteRegistrato = utenteRegistrato;
	}
	
	
	
	
	
	/**
	 * Stampa a video i dati relativi all'abbonamento
	 */
	public void stampaAbbonamento(){
		System.out.println("Abbonamento :");
		System.out.println("Data di inizio:"+" " +DataInizio);
		System.out.println("Data di fine:" + " " + DataFine);
		System.out.println("Pagato: "+Pagato);
		UtenteRegistrato.stampaUtenteRegistrato();
	}

	

	
	
}
