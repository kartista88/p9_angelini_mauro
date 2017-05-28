
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
	private UtenteRegistrato utentiRegistrato = new UtenteRegistrato();
	/**
	 * Costruttore di default
	 */
	public Abbonamento(){
		DataInizio = null;
		DataFine = null;
		Pagato = false;
		utentiRegistrato = null;
	}
	/**
	 * Costruttore con parametri per inizializzare un abbonamento
	 * @param di Data inizio abbonamento
	 * @param df Data fine abbonamento
	 * @param p Stato del pagamento
	 * @param ur Utente che effettua l'abbonamento
	 */
	public Abbonamento(LocalDate di, LocalDate df, Boolean p, UtenteRegistrato ur){
		DataInizio = di;
		DataFine = df;
		Pagato = p;
		utentiRegistrato = ur;
	}
	/**
	 * Restituisce la data di inizio abbonamento
	 * @return data inizio abbonamento
	 */
	public LocalDate getDataInizio() {
		return DataInizio;
	}
	/**
	 * Permette di impostare la data di inizio abbonamento
	 * @param dataInizio data inizio abbonamento
	 */
	public void setDataInizio(LocalDate dataInizio) {
		DataInizio = dataInizio;
	}
	/**
	 * Restituisce la data di fine abbonamento
	 * @return data fine abbonamento
	 */
	public LocalDate getDataFine() {
		return DataFine;
	}
	/**
	 * Permette di impostare la data di fine abbonamento
	 * @param dataFine data di fine abbonamento
	 */
	public void setDataFine(LocalDate dataFine) {
		DataFine = dataFine;
	}
	/**
	 * Restituisce lo stato del pagamento
	 * @return stato del pagamento
	 */
	public Boolean getPagato() {
		return Pagato;
	}
	/**
	 * Permette di impostare lo stato del pagamento
	 * @param pagato stato pagamento
	 */
	public void setPagato(Boolean pagato) {
		Pagato = pagato;
	}
	/**
	 * Restituisce il cliente che ha effettuato l'abbonamento
	 * @return dati cliente
	 */
	public UtenteRegistrato getUtentiRegistrato() {
		return utentiRegistrato;
	}
	/**
	 * Permette di impostare l'utente che effettua l'abbonamento
	 * @param utentiRegistrato utente che ha effettuato l'abbonamento
	 */
	public void setUtentiRegistrato(UtenteRegistrato utentiRegistrato) {
		this.utentiRegistrato = utentiRegistrato;
	}
	/*
	 * Riporta i dati dell'abbonamento
	 */
	public void stampaAbbonamento(){
		System.out.println("Abbonamento :");
		System.out.println("Data di inizio:"+" " +DataInizio);
		System.out.println("Data di fine:" + " " + DataFine);
		System.out.println("Pagato: "+Pagato);
		utentiRegistrato.stampaUtenteRegistrato();
	}	
	
}
