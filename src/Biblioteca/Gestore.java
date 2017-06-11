package Biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Classe principale che si occupa di gestire l'intero sistema bibliotecario.
 * Infatti memorizza i dati relativi alle biblioteche, ai libri e loro collocazioni,
 * inoltre consente a tutti gli utenti di effettuare ricerche, recensioni e consigliare l'acquisto di libri.
 * Invece per i soli utenti registrati consente il prestito, l'abbonamento alla consultazione di libri speciali
 * e la singola consultazione degli stessi
 * @author Mauro
 *
 */
public class Gestore {

	
	private static UtenteRegistrato utentelogin;
	private static boolean Login;
	private Integer IdUtenteLogin;
	private ArrayList<Libro> libriRicerca = new ArrayList<Libro>();
	private ArrayList<Collocazione> collocazioniRicerca= new ArrayList<Collocazione>();
	private Libro libroSuggerito = new Libro();
	private ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
	private Catalogo catalogo = new Catalogo();
	private ArrayList<Consultazione> consultazioni = new ArrayList<Consultazione>();
	private ArrayList<Abbonamento> abbonamenti = new ArrayList<Abbonamento>();
	private ArrayList<UtenteRegistrato> utentiRegistrati = new ArrayList<UtenteRegistrato>();
	private ArrayList<Prestito> prestiti = new ArrayList<Prestito>();
	/**
	 * Costruttore di default
	 */
	public Gestore() {
		super();
		// TODO Auto-generated constructor stub
		utentelogin = null;
		Login = false;
	}
	/**
	 * Costruttore con parametri
	 * @param idUtenteLogin Id utente login
	 * @param libroSuggerito Libro suggerito all'acquisto
	 * @param recensioni Collezione recensione
	 * @param catalogo Catalogo libri
	 * @param consultazioni Collezione di consultazioni
	 * @param abbonamenti Collezione di abbonamenti
	 * @param utentiRegistrati Collezione di utenti registrati
	 * @param prestiti Collezione di prestiti effettuati
	 */
	public Gestore(Integer idUtenteLogin, Libro libroSuggerito, ArrayList<Recensione> recensioni, Catalogo catalogo,
			ArrayList<Consultazione> consultazioni, ArrayList<Abbonamento> abbonamenti,
			ArrayList<UtenteRegistrato> utentiRegistrati, ArrayList<Prestito> prestiti) {
		super();
		IdUtenteLogin = idUtenteLogin;
		this.libroSuggerito = libroSuggerito;
		this.recensioni = recensioni;
		this.catalogo = catalogo;
		this.consultazioni = consultazioni;
		this.abbonamenti = abbonamenti;
		this.utentiRegistrati = utentiRegistrati;
		this.prestiti = prestiti;
	}
	/**
	 * Permette di aggiungere una recensione 
	 * @param r Recensione da aggiungere
	 */
	public void addRecensione(Recensione r) {
		recensioni.add(r);
	}
	/**
	 * Permettere di aggiungere un abbonamento
	 * @param a Abbonamento da aggiungere
	 */
	public void addAbbonamenti(Abbonamento a) {
		abbonamenti.add(a);
	}
	/**
	 * Permette di aggiungere un utente registrato alla lista di utenti
	 * @param u Nuovo utente registrato
	 */
	public void addUtenteRegistrato(UtenteRegistrato u) {
		utentiRegistrati.add(u);
	}
	/**
	 * Permette di aggiungere un prestito alla lista di prestiti
	 * @param p Nuovo prestito
	 */
	public void addPrestito(Prestito p) {
		prestiti.add(p);
	}
	/**
	 * Metodo che consente a un utente non iscritto di iscriversi
	 * immettendo le sue generalità tramite un opportuno menu che si 
	 * limita a raccogliere i dati
	 * @throws IOException _
	 */
	public void menuIscrivi() throws IOException {
		UtenteRegistrato u = new UtenteRegistrato();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String text = null;
		System.out.println("Iscriviti come utente registrato:");
		System.out.println("Compila tutti i campi obbligatori*");
		System.out.print("Nome:		");
		text = stdin.readLine(); 
		u.setNome(text);
		System.out.print("Cognome:	");
		text = stdin.readLine(); 
		u.setCognome(text);
		System.out.print("Età:		");
		text = stdin.readLine(); 
		u.setEtà(text);
		System.out.print("Indirizzo:	");
		text = stdin.readLine(); 
		u.setIndirizzo(text);
		System.out.print("Email:		");
		text = stdin.readLine(); 
		u.setEmail(text);
		System.out.print("Telefono:	");
		text = stdin.readLine();
		u.setTelefono(text);
		System.out.print("Username:	");
		text = stdin.readLine(); 
		u.setUsername(text);
		System.out.print("Password:	");
		text = stdin.readLine();
		u.setPassword(text);
		iscrivi(u);
	}
	
	/**
	 * Funzione che consente di iscrivere un'utente nel sistema
	 * andando a verificare i 3 parametri principali per il sistema:
	 * ovvero l'età, lo username e la password. Quando queste tre 
	 * proprietà dell'utente rispettano i vincoli la funzione inserisce
	 * il nuovo utente registrato
	 * @param u Dati utente da verificare per completare la registrazione
	 * @throws IOException
	 */
	public void iscrivi(UtenteRegistrato u) throws IOException {
		boolean usn = false, psw = false, età = false;
		if(checkEtà(u.getEtà()) == true) {
			età=true;
		} else {
			età=false;
		} 
		if(checkUsername(u.getUsername())==true) {
			usn=true;
		} else {
			usn=false;
		}
		if(checkPassword(u.getPassword()) == true) {
			psw=true;
		} else	{
			psw=false;
		}
		if(età==false)	{
			System.out.println("Età non corretta");
		}
		if(usn==false)	{
			System.out.println("Username errato o utente già esistente");
		}
		if(psw==false)	{
			System.out.println("Password non corretta");
		}
		if((età==true) && (usn==true) && (psw==true))	{
			addUtenteRegistrato(u);
		}
	}
	
	/**
	 * Metodo che consente ai soli utenti registrati di effettuare 
	 * il login mediante un menu dove possono inserire le loro credenziali
	 * che verrano poi verificate e se corrette il login andrà a buon fine
	 * @throws IOException _
	 */
	public void menuLogIn() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String usn = null , psw = null;

		System.out.println();
		System.out.println("Inserisci le tue credenziali");
		System.out.print("Username:	");
		usn = stdin.readLine(); 
		System.out.print("Password:	");
		psw = stdin.readLine();
		logIn(usn,psw);
		
	}
	
	/**
	 * Funzione che verifica le credenziali e se corrette completa il login
	 * @param u	UserName da verificare
	 * @param p Password da verificare
	 * @throws IOException
	 */
	public void logIn(String u , String p) throws IOException{
		boolean usn = false, psw = false;
		if( checkUsernameLogin(u) == true ) {
			usn = true;
			if( checkPasswordLogin(p) == true ) {
				psw = true;
			}
		}
		if ( usn == true && psw == true ) {
			utentelogin.setNome(utentiRegistrati.get(IdUtenteLogin).getNome());
			utentelogin.setPassword(p);
			Login = true;
		}
		
		if(usn == false)	{
			System.out.println("Username errato o non esistente");
			utentelogin = null;
		}
		if(psw == false)	{
			System.out.print("Password errata");
			utentelogin = null;
		}
		
		
	}
	
	/**
	 * Metodo che consente a un'utente registrato e che 
	 * ha effettuato il log in di uscire dal pannello a se dedicato
	 */
	public void logOut(){
		utentelogin = null;
		Login = false;
	}
	/**
	 * Metodo che permette sia a utenti registrati che non di effettuare la 
	 * ricerca di un libro tramite un menu dove immette i dati del libro che vuole 
	 * cercare
	 * @throws IOException _
	 */
	public void preMenuRicerca() throws IOException{
		
		System.out.println("Pannello di ricerca libri, qui puoi cercare i libri inserendo da uno a tutti i campi disponibili:");
		Libro l = new Libro();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String text = null;
		System.out.print("ISBN:	");
		text = stdin.readLine();
		l.setISBN(text);
		System.out.print("Titolo:	");
		text = stdin.readLine();
		l.setTitolo(text);
		System.out.print("Autore:	");
		text = stdin.readLine();
		l.setAutore(text);
		System.out.print("Casa editrice:	");
		text = stdin.readLine(); 
		l.setCasaEditrice(text);
		ricerca(l);
		postMenuRicerca();

	
	}
	/**
	 * Funzione che presi i dati del libro in esame cerca se è presente
	 * nel catalogo della biblioteca
	 * @param l Dati libro da cercare
	 * @throws IOException
	 */
	public void ricerca(Libro l) throws IOException{
		boolean noISBN = false, noTit = false, noAut = false, noCed = false, noAed = false;
		if ( l.getISBN().equals("") )	{
			noISBN = true;
		}
		if ( l.getTitolo().equals("") )	{
			noTit = true;
		}
		if ( l.getAutore().equals("") )	{
			noAut = true;
		}
		if ( l.getCasaEditrice().equals("") )	{
			noCed=true;
		} 
		System.out.println("Elenco risultati:");
		if ((noISBN == true) && (noTit == true) && (noAut == true) && (noCed == true) ) { //non sono stati inseriti i campi
			System.out.println("Elemento non trovato");
		} else {
			if ((noISBN == true) && (noTit == true)
						&& (noAut == true) && (noCed == false) ){ //ricerca per casaEd
				for (int i = 0; i < catalogo.getLibri().size(); i++) {
					if (l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}
			}
			if ( (noISBN == true) && (noTit == true) 
						&& (noAut == false) && (noCed == true) ) { // ricerca per autore
				for (int i = 0; i < catalogo.getLibri().size(); i++) {
					if (l.getAutore().equals(catalogo.getLibri().get(i).getAutore())) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}
			}
			if ((noISBN == true) && (noTit == true) 
						&& (noAut == false) && (noCed == false) ) { //ricerca per caseEd e autore
				for (int i = 0; i < catalogo.getLibri().size(); i++) {
					if (l.getAutore().equals(catalogo.getLibri().get(i).getAutore()) 
								&& l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}
			}
			if ( (noISBN == true) && (noTit == false) 
						&& (noAut == true) && (noCed == true) ) { //ricerca per titolo
				for ( int i = 0; i < catalogo.getLibri().size(); i++) {
					if (l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo())) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}
			}
			if ( (noISBN == true) && (noTit == false) && (noAut == true) && (noCed == false) ){ //ricerca per titolo e casa editrice
				for ( int i = 0; i < catalogo.getLibri().size(); i++) {
					if ( l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo()) 
								&& l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if ( (noISBN == true) && (noTit == false)
					&& (noAut == false) && (noCed == true) ){ //ricerca per titolo e autore
				for ( int i = 0; i < catalogo.getLibri().size(); i++) {
					if ( l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo()) 
							&& l.getAutore().equals(catalogo.getLibri().get(i).getAutore())) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if ( (noISBN == true) && (noTit == false) 
						&& (noAut == false) && (noCed == false) ) { // ricerca per titolo, autore e casa editrice
				for ( int i = 0; i < catalogo.getLibri().size(); i++) {
					if ( l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo())
							&& l.getAutore().equals(catalogo.getLibri().get(i).getAutore()) 
							&& l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())){
						catalogo.stampaLibriCatalogo(i);
							
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if ( (noISBN == false) && (noTit == true) && (noAut == true) && (noCed == true) ) { // ricerca per ISBN
				for (int i = 0; i < catalogo.getLibri().size(); i++) {
					if ( l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) ) {
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if( noISBN==false && noTit==true && noAut==true && noCed==false ){ //ricerca per ISBN e casaEd
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) 
							&& l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if(noISBN==false && noTit==true && noAut==false && noCed==true ){ //ricerca per ISBN e autore
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) && l.getAutore().equals(catalogo.getLibri().get(i).getAutore())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if(noISBN==false && noTit==true && noAut==false && noCed==false ){ //ricerca per ISBN, autore e casaEd
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) && l.getAutore().equals(catalogo.getLibri().get(i).getAutore()) && l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}
			}
			if(noISBN==false && noTit==false && noAut==true && noCed==true ){ //ricerca per ISBN e titolo
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) && l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if(noISBN==false && noTit==false && noAut==true && noCed==false ){ //ricerca per ISBN titolo e casaEd
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) && l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo()) && l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}	
			}
			if(noISBN==false && noTit==false && noAut==false && noCed==true ){ //ricerca per ISBN titolo e autore
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) && l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo()) && l.getAutore().equals(catalogo.getLibri().get(i).getAutore())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
				}
			}
			if(noISBN==false && noTit==false && noAut==false && noCed==false ){ //ricerca per ISBN, titolo, autore e casaEd
				for(int i=0; i<catalogo.getLibri().size();i++){
					if(l.getISBN().equals(catalogo.getLibri().get(i).getISBN()) && l.getTitolo().equals(catalogo.getLibri().get(i).getTitolo()) && l.getAutore().equals(catalogo.getLibri().get(i).getAutore()) && l.getCasaEditrice().equals(catalogo.getLibri().get(i).getCasaEditrice())){
						catalogo.stampaLibriCatalogo(i);
						libriRicerca.add(catalogo.getLibri().get(i));
						collocazioniRicerca.add(catalogo.getCollocazioni().get(i));
					}
					
				}	
			}
			
			/*if( libriRicerca.isEmpty() && collocazioniRicerca.isEmpty() ) {
				System.out.println("Elemento non trovato");
			}*/
		}
	}
	/**
	 * Menu che consente all'utente non registrato di effettuare una recensione 
	 * sulla base dei risultati della ricerca, mentre consente a un utente registrato
	 * di consultare prenotare e recensire sulla base dei risultati della ricerca
	 * @throws IOException
	 */
	public void postMenuRicerca() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		if( !libriRicerca.isEmpty() && !collocazioniRicerca.isEmpty() ) {
			int scelta=0;
			while(scelta!=1){
				scelta=menuRicerca();
				switch(scelta){
				case 1:
					libriRicerca.clear();
					collocazioniRicerca.clear();
					break;
				case 2:
					Libro rec = new Libro();
					if( libriRicerca.size() == 0 ) {
						System.out.println("Elemento non trovato");
						break;
					}
					if(libriRicerca.size()>1){
						boolean error=true;
						while(error==true){
							System.out.println("Quale libro vuoi recensire?");
							for(int i=0;i<libriRicerca.size();i++){
								System.out.println((i+1) + ") " + libriRicerca.get(i).getTitolo());
							}
							System.out.print("Inserisci un numero da 1 a " + (libriRicerca.size()) + " e premi INVIO -> __");
							String choice = stdin.readLine();
							int c=0;
							try {  
								c = Integer.parseInt(choice);
							} catch (NumberFormatException ec) {
								System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
								error=true;
							}
							if(c>=1 && c<=libriRicerca.size()){
								rec=libriRicerca.get((c-1));
								//cod recensione
								System.out.println("Recensisci " + rec.getTitolo() + ":");
								System.out.print("Esprimi un voto da 1 a 5 -> ");
								BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
								String stream = std.readLine();  
								int v=0;
								try {  
									v = Integer.parseInt(stream);
								} catch (NumberFormatException ec) {
									System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
									
								}
								System.out.print("Esprimi una descrizione -> ");
								stream = std.readLine();  
								
								if(Login==true)	{
									recensionelogin((c-1),v,stream,rec,utentelogin);
									System.out.println("Recensione effettuata con successo");
								}
								else {
									recensione((c-1),v,stream,rec);
									System.out.println("Recensione effettuata con successo");
								}
								error=false;
							}
							else	error=true;
						}
						
					}
					else{
						System.out.println("Recensisci " + rec.getTitolo() + ":");
						System.out.print("Esprimi un voto da 1 a 5 -> ");
						BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
						String stream = std.readLine();  
						int v=0;
						try {  
							v = Integer.parseInt(stream);
						} catch (NumberFormatException ec) {
							System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
							
						}
						System.out.print("Esprimi una descrizione -> ");
						stream = std.readLine(); 
						rec=libriRicerca.get(0);
						if(Login==true)	{
							
							recensionelogin(0,v,stream,rec,utentelogin);
						}
						else {
							recensione(0,v,stream,rec);
						}
					}
					break;
				case 3:
					if( libriRicerca.size() == 0 ) {
						System.out.println("Elemento non trovato");
						break;
					}
					if(libriRicerca.size()>1){
						boolean error=true;
						while(error==true){
							System.out.println("Quale libro vuoi prenotare?");
							for(int i=0;i<libriRicerca.size();i++){
								System.out.println((i+1) + ") " + libriRicerca.get(i).getTitolo());
							}
							System.out.print("Inserisci un numero da 1 a " + (libriRicerca.size()) + " e premi INVIO -> __");
							String choice = stdin.readLine();
							int c=0;
							try {  
								c = Integer.parseInt(choice);
							} catch (NumberFormatException ec) {
								System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
								error=true;
							}
							if(c>=1 && c<=libriRicerca.size()){
								/*rec=libriRicerca.get((c-1));
								prestito(utentelogin, rec);*/
								for(int i=0 ; i<catalogo.getLibri().size() ; i++) {
									if ( libriRicerca.get(c-1)==catalogo.getLibri().get(i) ) {
										rec=catalogo.getLibri().get(i);
										prestito(utentelogin, rec);
										catalogo.getLibri().get(i).setDisponibile(false);
										break;
									}
								}
								error=false;
							}
							else	error=true;
						}
						
					}
					else{
						for(int i=0 ; i<catalogo.getLibri().size() ; i++) {
							if ( libriRicerca.get(0)==catalogo.getLibri().get(i) ) {
								rec=catalogo.getLibri().get(i);
								prestito(utentelogin, rec);
								catalogo.getLibri().get(i).setDisponibile(false);
								break;
							}
						}
						//rec=libriRicerca.get(0);					
						//prestito(utentelogin, rec);
					}
					break;
				case 4:
					if( libriRicerca.size() == 0 ) {
						System.out.println("Elemento non trovato");
						break;
					}
					if(libriRicerca.size()>1){
						boolean error=true;
						while(error==true){
							System.out.println("Quale libro vuoi consultare?");
							for(int i=0;i<libriRicerca.size();i++){
								System.out.println((i+1) + ") " + libriRicerca.get(i).getTitolo());
							}
							System.out.print("Inserisci un numero da 1 a " + (libriRicerca.size()) + " e premi INVIO -> __");
							String choice = stdin.readLine();
							int c=0;
							try {  
								c = Integer.parseInt(choice);
							} catch (NumberFormatException ec) {
								System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
								error=true;
							}
							if(c>=1 && c<=libriRicerca.size()){
								for(int i=0 ; i<catalogo.getLibri().size() ; i++) {
									if ( libriRicerca.get(c-1)==catalogo.getLibri().get(i) ) {
										rec=catalogo.getLibri().get(i);
										if(rec.isDisponibile()){
											System.out.println();
											System.out.println("Il libro scelto è disponibile alla consultazione"); 
											System.out.println();
											boolean abbonato = false;
											for( int j=0 ; j<abbonamenti.size() ; j++){
												if(abbonamenti.get(j).getPagato()){
													abbonato=true;
													break;
												}
											}
											if(abbonato){
												System.out.println();
												System.out.println("Possiedi un abbonamento alla consultazione");
												System.out.println("Puoi ritirare il libro dalle " + LocalTime.now() + " e consegnarlo in data odierna alle " + LocalTime.of(18, 00)); 
												System.out.println();
												singolaConsultazione(utentelogin, rec);
												catalogo.getLibri().get(i).setDisponibile(false);
											}else {
												System.out.println();
												System.out.println("Non possiede un abbonamento alla consultazione"); 
												System.out.println();
												String text = null;
												int opzione = 0;
												do{
													System.out.println("Puoi comunque consultare il libro grazie al servizio a pagamento di singola consultatione");
													System.out.println("Vuoi procedere con il pagamento?");
													System.out.print("1 - PAGA	2 - ANNULLA -->");
													BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
													text = std.readLine(); 
													
													try {  
														opzione = Integer.parseInt(text);
													} catch (NumberFormatException ec) {
														System.out.println("Stringa errata inserire un valore numerico per indicare l'anno di edizione"); 
													}
													if(opzione==2){
														break;
													}
												}while(opzione!=1);
												if(opzione==1){
													System.out.println("Immettere il codice della carta -> ");
													BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
													text = std.readLine(); 
													System.out.println("Immettere il codice di sicurezza -> ");
													text = std.readLine(); 
													System.out.println("Puoi ritirare il libro dalle " + LocalTime.now() + " e consegnarlo in data odierna alle " + LocalTime.of(18, 00)); 
													System.out.println();
													singolaConsultazione(utentelogin, rec);
													catalogo.getLibri().get(i).setDisponibile(false);
												}
											}
										} else {
											System.out.println("Libro non disponibile alla consultazione");
										}
										
										break;
									}
								}
								error=false;
							}
							else	error=true;
						}
						
					} else{
						for(int i=0 ; i<catalogo.getLibri().size() ; i++) {
							if ( libriRicerca.get(0)==catalogo.getLibri().get(i) ) {
								rec=catalogo.getLibri().get(i);
								if(rec.isDisponibile()){
									System.out.println();
									System.out.println("Il libro scelto è disponibile alla consultazione"); 
									System.out.println();
									boolean abbonato = false;
									for( int j=0 ; j<abbonamenti.size() ; j++){
										if(abbonamenti.get(j).getPagato()){
											abbonato=true;
											break;
										}
									}
									if(abbonato){
										System.out.println();
										System.out.println("Possiedi un abbonamento alla consultazione");
										System.out.println("Puoi ritirare il libro dalle " + LocalTime.now() + " e consegnarlo in data odierna alle " + LocalTime.of(18, 00)); 
										System.out.println();
										singolaConsultazione(utentelogin, rec);
										catalogo.getLibri().get(i).setDisponibile(false);
										break;
									}else {
										System.out.println();
										System.out.println("Non possiede un abbonamento alla consultazione"); 
										System.out.println();
										String text = null;
										int opzione = 0;
										do{
											System.out.println("Puoi comunque consultare il libro grazie al servizio a pagamento di singola consultatione");
											System.out.println("Vuoi procedere con il pagamento?");
											System.out.print("1 - PAGA	2 - ANNULLA -->");
											BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
											text = std.readLine(); 
											
											try {  
												opzione = Integer.parseInt(text);
											} catch (NumberFormatException ec) {
												System.out.println("Stringa errata inserire un valore numerico per indicare l'anno di edizione"); 
											}
											if(opzione==2){
												break;
											}
										}while(opzione!=1);
										if(opzione==1){
											System.out.println("Immettere il codice della carta -> ");
											BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
											text = std.readLine(); 
											System.out.println("Immettere il codice di sicurezza -> ");
											text = std.readLine(); 
											System.out.println("Puoi ritirare il libro dalle " + LocalTime.now() + " e consegnarlo in data odierna alle " + LocalTime.of(18, 00)); 
											System.out.println();
											singolaConsultazione(utentelogin, rec);
											catalogo.getLibri().get(i).setDisponibile(false);
											break;
										}
									}
								} else {
									System.out.println("Libro non disponibile alla consultazione");
								}
							}
						}
						
					}
					
					
				
					break;
				}
			}
			
		}
		
	
	}

	
	/**
	 * Metodo che consente di creare un prestito associando un utente
	 * a un libro
	 * @param u Utente registrato che effettua il prestito
	 * @param l Libro da prestare
	 */
	public void prestito(UtenteRegistrato u, Libro l){
		Prestito p = new Prestito();
		p.setUtenteRegistrato(u);
		if (l.isDisponibile()){
			LocalDate dr = LocalDate.now();
			LocalDate dc = dr.plusDays(14);
			p.setDataRitiro(dr);
			p.setDataConsegna(dc);
			p.setLibri(l);
			for(int i=0;i<catalogo.getLibri().size();i++){
				if(catalogo.getLibri().get(i)==l){
					catalogo.getLibri().get(i).setDisponibile(false);
					System.out.println("Libro disponibile");
					p.stampaPrestito();
					prestiti.add(p);
				}
			}
		}
		else	System.out.println("Libro non disponibile");
		
		
		
	}
	/**
	 * Metodo che consente di creare un abbonamento mediante un 
	 * menu che consente all'utente di inserire i dati per il 
	 * pagamento dell'abbonamento
	 * @throws IOException _
	 */
	public void menuAbbonamento() throws IOException{
		String text = null;
		int scelta = 0;
		do{
			System.out.println("Qui potrai abbonarti al servizio di consultazione, ti offriamo un abbonamento mensile");
			System.out.println("Vuoi procedere con il pagamento?");
			System.out.print("1 - CONFERMA	2 - RIFIUTA -->");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			text = stdin.readLine(); 
			
			try {  
				scelta = Integer.parseInt(text);
			} catch (NumberFormatException ec) {
				System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
			}
			if(scelta==2){
				break;
			}
		}while(scelta!=1);
		if(scelta==1){
			System.out.println("Immettere il codice della carta -> ");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			text = stdin.readLine(); 
			System.out.println("Immettere il codice di sicurezza -> ");
			text = stdin.readLine(); 
			abbonamento();
			abbonamenti.get(abbonamenti.size()-1).stampaAbbonamento();
		}
		
		
	}
	/**
	 * Metodo che associa all'utente registrato l'abbonamento
	 * una volta effettuato il pagamento
	 * @throws IOException
	 */
	public void abbonamento() throws IOException{ 
		LocalDate di = LocalDate.now();
		LocalDate df = di.plusMonths(1);
		Abbonamento ab = new Abbonamento(di,df,true,utentelogin);
		
		abbonamenti.add(ab);			
	}
	/**
	 * Metodo che permette di inserire una recensionea un utente non registrato sul libro cercato tramite un giudizio
	 * e un commento personale sul libro in questione
	 * @param n Numero di libro da recensire tra quelli cercati
	 * @param l Libro cercato
	 * @throws IOException _
	 */
	public void recensione(int n, int v, String d, Libro l) throws IOException{
		Recensione r = new Recensione();
		r.setVoto(v); 
		r.setDescrizione(d);
		r.setLibro(l);
		recensioni.add(r);
	}
	/**
	 * Metodo che permette di inserire una recensionea un utente registrato sul libro cercato tramite un giudizio
	 * e un commento personale sul libro in questione
	 * @param n Numero di libro da recensire tra quelli cercati
	 * @param l Libro cercato 
	 * @param u Utente che fa la recensione
	 * @throws IOException _
	 */
	public void recensionelogin(int n, int v, String d, Libro l, UtenteRegistrato u) throws IOException{
		Recensione r = new Recensione();
		r.setVoto(v); 
		r.setDescrizione(d);
		r.setLibro(l);
		r.setUtenteRegistrato(u);
		recensioni.add(r);
		
	}
	/**
	 * Metodo che consente all'utente registrato di fare una singola
	 * consultazione di un libro speciae
	 * @param u Utente Registrato 
	 * @param l Libro da consultare
	 * @throws IOException _
	 */
	public void singolaConsultazione(UtenteRegistrato u, Libro l) throws IOException{
		Consultazione con = new Consultazione();
		con.setPagato(true);
		con.setLibro(l);
		con.setUtenteRegistrato(u);
		con.setDataOraRitiro(LocalDateTime.now());
		con.setDataOraRitiro(LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 00)));
		consultazioni.add(con);
			
	}
	/**
	 * Metodo che consente all'utente registrato di richiedere la proroga di un prestito
	 */
	/*public void prorogaPrestito(){
		
	}*/
	/**
	 * Metodo che consente all'utente registrato di controllare i prestiti
	 */
	/*public void controlloPrestiti(){
		
	}*/
	/**
	 * Metodo che consente al sistema di richiamare l'utente che non rispetta
	 * la consegna di un libro
	 */
	/*public void richiamoPrestito(){
		
	}*/
	/**
	 * Metodo che controlla il nome utente di un utente che vuole iscriversi
	 * @param u Stringa username
	 * @return Esito sulla correttezza username
	 */
	public boolean checkUsername(String u){
		if(u.length()<4){	//nome utente non può essere piu piccolo di 4 caratteri
			return false;
		}
		if(utentiRegistrati.size()==0){
			return true;
		}
		for(int i=0;i<utentiRegistrati.size();i++){	//controllo che non esistano altri nomi utenti
			if(utentiRegistrati.get(i).getUsername()==u){
				//System.out.println("Utente non esistente");
				return false;
			}
		}
		return true;
	}
	/**
	 * Metodo che controlla il nome utente di un utente che vuole fare il log in 
	 * @param u Stringa username
	 * @return Esito sulla correttezza username
	 */
	public boolean checkUsernameLogin(String u){
		if(utentiRegistrati.size()==0){
			return false;
		}
		for(int i=0;i<utentiRegistrati.size();i++){	//controllo che non esistano altri nomi utenti
			if(utentiRegistrati.get(i).getUsername().equals(u)){
				IdUtenteLogin = i;
				utentelogin=utentiRegistrati.get(i);
				return true;
			}
		}
		//System.out.println("Utente non esistente");
		return false;
	}
	/**
	 * Metodo che si assicura che la password inserita da un utente che vuole 
	 * iscriversi sia conforme alle regole, ovvero sia minimo di 8 caratteri 
	 * e tra questi ci sia una lettera maiuscola, almeno un segno di punteggiatura
	 * e almeno un numero
	 * @param p Stringa password
	 * @return Esito sulla correttezza password
	 */
	public boolean checkPassword(String p){
		if(p.length()<8){
			//System.out.print("pochi caratteri");
			return false;
		}
		int i=0;
		boolean capital=false, space=false, punctuation=false, number=false;
		while(i != p.length()){
			char c = p.charAt(i);
			int n = (int) c;
			//Controllo maiscola
			if(n >= 65 && n <=90) {
				capital=true;
			}
			//Controllo spazio
			if(n == 32)	{
				space=true;
			}
			//controllo punteggiatura
			if((n>=33 && n<=47) || (n>=58 && n<=64) || (n>=91 && n<=96)) {
				punctuation=true;
			}
			//controllo numeri
			if(n>=48 && n<=57)	{
				number=true;
			}
			i++;
			//( capital != true && space != true && punctuation != true && number != true )
		}
		if( capital == true && space == false && punctuation == true && number == true ){
			//System.out.println("Password corretta");
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Metodo che controlla che la password corrisponda con quella memorizzata
	 * al momento del log in
	 * @param p String password
	 * @return Esito sulla correttezza password
	 */
	public boolean checkPasswordLogin(String p){
		if(utentiRegistrati.get(IdUtenteLogin).getPassword().equals(p)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Metodo che controlla in fase di iscizione se l'utente ha un'età 
	 * minima di 13 anni
	 * @param e Valore età
	 * @return Esito sulla correttezza Età
	 */
	public boolean checkEtà(String e)  {
		int età=0;
		try {  
			età = Integer.parseInt(e);
		} catch (NumberFormatException ec) {
			System.out.println("Stringa errata inserire un valore numerico per indicare l'età"); 
			return false;
		}
		if(età<13){
			return false;
		}
		else{
			return true;
		}
		
	}
	/**
	 * Metodo che consente a un utente registrato e non di 
	 * suggerire un'acquisto di un libro mediante il menu
	 * @throws IOException _
	 */
	public void menuSuggerisciAcquisto() throws IOException{
		boolean noISBN=false, noTit=false, noAut=false, noCed=false, noAed=false;
		System.out.println("Inserisci qui i dati del libro di cui vuoi suggerire l'acquisto:");
		Libro l= new Libro();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String text = null;
		System.out.print("ISBN:	");
		text = stdin.readLine();
		if(text.equals(""))	noISBN=true;
		else	l.setISBN(text);
		System.out.print("Titolo:	");
		text = stdin.readLine();
		if(text.equals(""))	noTit=true;
		else	l.setTitolo(text);
		System.out.print("Autore:	");
		text = stdin.readLine();
		if(text.equals(""))	noAut=true;
		else	l.setAutore(text);
		System.out.print("Casa editrice:	");
		text = stdin.readLine(); 
		if(text.equals(""))	noCed=true;
		else	l.setCasaEditrice(text);
		System.out.print("Anno edizione:	");
		text = stdin.readLine(); 
		if(text.equals(""))	noAed=true;
		else{
			int annoEdizione = 0;
			try {  
				annoEdizione = Integer.parseInt(text);
			} catch (NumberFormatException ec) {
			System.out.println("Stringa errata inserire un valore numerico per indicare l'anno di edizione"); 
			}
			l.setAnnoEdizione(annoEdizione);
		}
		System.out.println("Elenco risultati:");
		if(noISBN==true && noTit==true && noAut==true && noCed==true && noAed==true){ //non sono stati inseriti i campi
			System.out.println();
			System.out.println("Tutti i campi sono vuoti non è possibile inserire l'elemento nella richiesta");
			System.out.println();
		}
		else{
			System.out.println();
			System.out.println("Richiesta inserita correttamente");
			System.out.println();
			suggerisciAcquisto(l);
			libroSuggerito.stampaLibro();
		}
	}
	/**
	 * Metodo che inserisce la richiesta di acquisto
	 * @param l dati libro di cui si suggerisce l'aquisto
	 * @throws IOException
	 */
	public void suggerisciAcquisto(Libro l) throws IOException{
		libroSuggerito=l;
	}
	/**
	 * Metodo che apre il menu una volta che un utente non registrato 
	 * effettua una ricerca permettendo di recensire
	 * @return Opzione scelta dall'utente 
	 * @throws IOException _
	 */
	public static int menuRicerca() throws IOException{
		boolean error = true;
		int c=0;
		if(Login == true){
			while(error==true){
				System.out.println("Benvenuto/a" + " " +utentelogin.Nome + " " +  "nel sistema di gestione delle Biblioteche");
				System.out.println("-------------------------MENU----------------------");
				System.out.println("1-	Torna a menu");
				System.out.println("2-	Recensisci");
				System.out.println("3-	Prenota");
				System.out.println("4-	Consulta");
				BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Inserisci un numero da 1 a 4 e premi INVIO -> __");
				String choice = stdin.readLine();  
			
				try {  
					c = Integer.parseInt(choice);
				} catch (NumberFormatException ec) {
					System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
					error=true;
				}
				if(c>=1 && c<=4){
					error=false;
				}
				else	error=true;
			}
			return c;
		}
		else{
			while(error==true){
				System.out.println("Benvenuto/a nel sistema di gestione delle Biblioteche");
				System.out.println("-------------------------MENU----------------------");
				System.out.println("1-	Torna a menu");
				System.out.println("2-	Recensisci");
				BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Inserisci un numero tra 1 e 2 e premi INVIO -> __");
				String choice = stdin.readLine();  
			
				try {  
					c = Integer.parseInt(choice);
				} catch (NumberFormatException ec) {
					System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
					error=true;
				}
				if(c>=1 && c<=2){
					error=false;
				}
				else	error=true;
			}
			return c;
			
		}
		
		
	}
	/**
	 * Restituisce il catalogo del sistema
	 * @return Catalogo
	 */
	public Catalogo getCatalogo() {
		return catalogo;
	}
	/**
	 * Permette di impostare i dati relativi al catalogo
	 * @param catalogo Dati relativi al catalogo
	 */
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
	/**
	 * Restituisce i dati dell'utente collegato al momento
	 * @return Dati utente collegato
	 */
	public UtenteRegistrato getUtentelogin() {
		return utentelogin;
	}
	/**
	 * Permette di settare i dati dell'utente collegato al momento
	 * @param utentelogin Dati utente collegato
	 */
	public void setUtentelogin(UtenteRegistrato utentelogin) {
		this.utentelogin = utentelogin;
	}
	/**
	 * Metodo che controlla se c'è un utente collegato al momento
	 * @return Esito utente collegato
	 */
	public boolean isLogin() {
		if(Login == true)	return true;
		else	return false;
	}
	/**
	 * Permette di impostare la variabile booleana che verifica se un'utente è registrato
	 * @param login Dati variabile booleana 
	 */
	public void setLogin(boolean login) {
		this.Login = login;
	}

	/**
	 * Restituisce Id dell'utente che ha effettuato il login
	 * @return the idUtenteLogin
	 */
	public Integer getIdUtenteLogin() {
		return IdUtenteLogin;
	}
	/**
	 * Imposta Id dell'utente che ha effettuato il login
	 * @param idUtenteLogin the idUtenteLogin to set
	 */
	public void setIdUtenteLogin(Integer idUtenteLogin) {
		IdUtenteLogin = idUtenteLogin;
	}
	/**
	 * Restituisce i dati del libro suggerito per l'acquisto
	 * @return the libroSuggerito
	 */
	public Libro getLibroSuggerito() {
		return libroSuggerito;
	}
	/**
	 * Imposta i dati del libro suggerito per l'acquisto
	 * @param libroSuggerito the libroSuggerito to set
	 */
	public void setLibroSuggerito(Libro libroSuggerito) {
		this.libroSuggerito = libroSuggerito;
	}
	/**
	 * Restituisce i dati delle recensioni effettuate
	 * @return the recensioni
	 */
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}
	/**
	 * Imposta i dati delle recensioni
	 * @param recensioni the recensioni to set
	 */
	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	/**
	 * Restituisce le consultazioni effettuate
	 * @return the consultazioni
	 */
	public ArrayList<Consultazione> getConsultazioni() {
		return consultazioni;
	}
	/**
	 * Permette di impostare e consultazioni
	 * @param consultazioni the consultazioni to set
	 */
	public void setConsultazioni(ArrayList<Consultazione> consultazioni) {
		this.consultazioni = consultazioni;
	}
	/**
	 * Restituisce gli abbonamenti effettuati
	 * @return the abbonamenti
	 */
	public ArrayList<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}
	/**
	 * Permette di impostare gli abbonamenti
	 * @param abbonamenti the abbonamenti to set
	 */
	public void setAbbonamenti(ArrayList<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	/**
	 * Restituisce la lista di utenti registrati
	 * @return the utentiRegistrati
	 */
	public ArrayList<UtenteRegistrato> getUtentiRegistrati() {
		return utentiRegistrati;
	}
	/**
	 * Permette di impostare gli utenti registrati
	 * @param utentiRegistrati the utentiRegistrati to set
	 */
	public void setUtentiRegistrati(ArrayList<UtenteRegistrato> utentiRegistrati) {
		this.utentiRegistrati = utentiRegistrati;
	}
	/**
	 * Restituisce i prestiti effettuati
	 * @return the prestiti
	 */
	public ArrayList<Prestito> getPrestiti() {
		return prestiti;
	}
	/**
	 * Permette di impostare i prestiti effettuati
	 * @param prestiti the prestiti to set
	 */
	public void setPrestiti(ArrayList<Prestito> prestiti) {
		this.prestiti = prestiti;
	}
	/**
	 * Restituisce la lista di libri cercati
	 * @return the libriRicerca
	 */
	public ArrayList<Libro> getLibriRicerca() {
		return libriRicerca;
	}
	/**
	 * Permette di impostare i libri di ricerca
	 * @param libriRicerca the libriRicerca to set
	 */
	public void setLibriRicerca(ArrayList<Libro> libriRicerca) {
		this.libriRicerca = libriRicerca;
	}
	/**
	 * Restituisce la lista di collocazioni di ricerca
	 * @return the collocazioniRicerca
	 */
	public ArrayList<Collocazione> getCollocazioniRicerca() {
		return collocazioniRicerca;
	}
	/**
	 * Imposta le collocazioni di ricerca
	 * @param collocazioniRicerca the collocazioniRicerca to set
	 */
	public void setCollocazioniRicerca(ArrayList<Collocazione> collocazioniRicerca) {
		this.collocazioniRicerca = collocazioniRicerca;
	}
}
