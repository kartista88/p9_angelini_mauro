/*
 * Biblioteca
 */
package Biblioteca;
/**
 * Classe che memorizza i dati relativi a una biblioteca
 * @author Mauro
 *
 */

public class Biblioteca {
	String Nome;
	String Indirizzo;
	String Telefono;
	/**
	 * Costruttore di default
	 */
	public Biblioteca(){
		Nome = null;
		Indirizzo = null;
		Telefono = null;
	}
	/**
	 * Costruttore con parametri
	 * @param n nome biblioteca
	 * @param i indirizzo biblioteca
	 * @param t numero di telefono biblioteca
	 */
	public Biblioteca(String n, String i, String t){
		Nome = n;
		Indirizzo = i;
		Telefono = t;
	}
	/**
	 * Restituisce il nome della biblioteca
	 * @return il nome della biblioteca
	 */
	public String getNome() {
		return Nome;
	}
	/**
	 * Permette di impostare il nome della Biblioteca
	 * @param nome nome biblioteca
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
	/**
	 * Restituisce l'indirizzo della biblioteca
	 * @return indirizzo della biblioteca
	 */
	public String getIndirizzo() {
		return Indirizzo;
	}
	/**
	 * Permette di impostare l'indirizzo della biblioteca
	 * @param indirizzo indirizzo biblioteca
	 */
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	/**
	 * Restituisce il telefono della biblioteca
	 * @return Numero di telefono della biblioteca
	 */
	public String getTelefono() {
		return Telefono;
	}
	/**
	 * Permette di impostare il numero di telefono della biblioteca
	 * @param telefono numero di telefono della biblioteca
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	/**
	 * Stampa a video i dati relativi alla biblioteca
	 */
	public void stampaBiblioteca(){
		System.out.println("Dati Biblioteca");
		System.out.println("Nome: " + Nome);
		System.out.println("Indirizzo: " + Indirizzo);
		System.out.println("Telefono: " + Telefono);
	}

}
