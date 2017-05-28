package Biblioteca;

import java.util.*;
/**
 * Classe che permette di memorizzare i dati di un catalogo
 * il quale assoccia a tutti i libri una collocazione univoca.
 * Ovvero è composto di una lista di libri e di una lista di 
 * collocazioni di uguale dimensione e l'associazione è data dall'indice
 * univoco e coincidente per entrambe le liste
 * @author Mauro
 */
public class Catalogo {
	
	String tipo;
	ArrayList<Libro> libri = new ArrayList<Libro>();
	ArrayList<Collocazione> collocazioni = new ArrayList<Collocazione>();
	/**
	 * Costruttore di default
	 */
	public Catalogo(){
		tipo = null;
		libri = null;
	}
	/**
	 * Costruttore con parametri 
	 * @param t specifica il contenuto del catalogo (es. librario) 
	 * @param l libro da inserire
	 */
	public Catalogo(String t, Libro l){
		tipo = t;
		libri.add(l);
	}
	/**
	 * Costruttore con parametri
	 * @param t specifica il contenuto del catalogo (es. librario) 
	 */
	public Catalogo(String t){
		tipo = t;
		libri = null;
	}
	/**
	 * Restituisce il tipo di catalogo
	 * @return specifica il contenuto del catalogo (es. librario) 
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Permette di impostare il tipo di catalogo
	 * @param tipo specifica il contenuto del catalogo (es. librario) 
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Stampa a video i dati relativi al catalogo
	 * Mostrando l'associazione di ciascun libro 
	 * nel catalogo con la sua univoca posizione
	 */
	public void stampaCatalogo(){
		System.out.println();
		System.out.println("Catalogo :" + tipo);
		for(int i=0;i<libri.size();i++){
			System.out.println();
			libri.get(i).stampaLibro();
			System.out.println();
			collocazioni.get(i).stampaCollocazione();
		}
		System.out.println();
	}
	/**
	 * Stampa a video uno specifico libro del catalogo
	 * e relativa posizione
	 * @param i indice che identifica il libro nell'elenco del catalogo
	 */
	public void stampaLibriCatalogo(int i){
		System.out.println();
		System.out.println("Catalogo :" + tipo);
		libri.get(i).stampaLibro();	
		collocazioni.get(i).stampaCollocazione();
		System.out.println();
	}
	/**
	 * Restituisce l'intera collezione di libri senza la loro collocazione
	 * @return Collezione di libri presenti nel catalogo
	 */
	public ArrayList<Libro> getLibri() {
		return libri;
	}
	/**
	 * Permette di inserire una collezione di libri senza collocazione
	 * nel catalogo
	 * @param libri Collezione di libri
	 */
	public void setLibri(ArrayList<Libro> libri) {
		this.libri = libri;
	}
	/**
	 * Permette di impostare un tipo al catalogo
	 * @param s tipo di catalogo
	 */
	public void addTipo(String s){
		tipo = s;
	}
	/**
	 * Permette di aggiungere un singolo libro alla
	 * collezione del catalogo
	 * @param l Libro da aggiungere
	 */
	public void addLibro(Libro l){
		libri.add(l);
	}
	/**
	 * Permette di aggiungere una singola collocazione al catalogo
	 * @param c Collocazione da aggiungere
	 */
	public void addCollocazione(Collocazione c){
		collocazioni.add(c);
	}
	/**
	 * Restitiusce l'intera lista di collocazioni
	 * @return	Lista di collocazioni
	 */
	public ArrayList<Collocazione> getCollocazioni() {
		return collocazioni;
	}
	/**
	 * Permette di aggiungere un collezione di collocazioni
	 * @param collocazioni Collezione di collocazioni
	 */
	public void setCollocazioni(ArrayList<Collocazione> collocazioni) {
		this.collocazioni = collocazioni;
	}
}
