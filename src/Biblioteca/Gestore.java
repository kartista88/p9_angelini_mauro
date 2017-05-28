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
	public Gestore(){
		utentelogin = null;
		Login = false;
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
	 * immettendo le sue generalità infine un nome utente che deve essere univoco
	 * e una password
	 * @throws IOException _
	 */
	public void iscrivi() throws IOException {
		UtenteRegistrato u = new UtenteRegistrato();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String text = null;
		boolean usn = false, psw = false, età = false;
		
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
		if(checkEtà(text) == true) {
			età=true;
			u.setEtà(text);
		} else {
			età=false;
		}
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
		if(checkUsername(text)==true) {
			usn=true;
			u.setUsername(text);
		} else {
			usn=false;
		}
		System.out.print("Password:	");
		text = stdin.readLine();
		if(checkPassword(text) == true) {
			psw=true;
			u.setPassword(text);
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
	 * il login e accedere a un maggior numero di funzioni del sistema
	 * come il prestito, la consultazione e l'abbonamento
	 * @throws IOException _
	 */
	public void logIn() throws IOException{
		boolean usn = false, psw = false;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String text = null;

		System.out.println();
		System.out.println("Inserisci le tue credenziali");
		System.out.print("Username:	");
		text = stdin.readLine(); 
		if(checkUsernameLogin(text) == true) {
			usn=true;
			utentelogin.setNome(utentiRegistrati.get(IdUtenteLogin).getNome());
			System.out.print("Password:	");
			text = stdin.readLine();
			if(checkPasswordLogin(text) == true) {
				psw = true;
				utentelogin.setPassword(text);
				Login = true;
			}
		}
			
		if(usn == false)	{
			System.out.println("Username errato o non esistente");
		}
		if(psw == false)	{
			System.out.print("Password errata");
		}
		
		
	}
	/**
	 * Metodo che consente a un'utente registrato e che 
	 * ha effettuato il log in di uscire dal pannello a se dedicato
	 */
	public void logOut(){
		utentelogin = new UtenteRegistrato();
		Login = false;
	}
	/**
	 * Metodo che permette sia a utenti registrati che non di effettuare la 
	 * ricerca di un libro
	 * @throws IOException _
	 */
	public void ricerca() throws IOException{
		boolean noISBN = false, noTit = false, noAut = false, noCed = false, noAed = false;
		System.out.println("Pannello di ricerca libri, qui puoi cercare i libri inserendo da uno a tutti i campi disponibili:");
		Libro l = new Libro();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String text = null;
		System.out.print("ISBN:	");
		text = stdin.readLine();
		if (text.equals(""))	{
			noISBN = true;
		} else {
			l.setISBN(text);
		}
		System.out.print("Titolo:	");
		text = stdin.readLine();
		if (text.equals(""))	{
			noTit = true;
		} else {
			l.setTitolo(text);
		}
		System.out.print("Autore:	");
		text = stdin.readLine();
		if (text.equals(""))	{
			noAut = true;
		} else {
			l.setAutore(text);
		}
		System.out.print("Casa editrice:	");
		text = stdin.readLine(); 
		if (text.equals(""))	{
			noCed=true;
		} else {
			l.setCasaEditrice(text);
		}
		System.out.print("Anno edizione:	");
		text = stdin.readLine(); 
		if (text.equals(""))	{
			noAed=true;
		} else {
			int annoEdizione = 0;
			try {  
				annoEdizione = Integer.parseInt(text);
			} catch (NumberFormatException ec) {
				System.out.println("Stringa errata inserire un valore numerico per indicare l'anno di edizione"); 
			}
			l.setAnnoEdizione(annoEdizione);
		}
		System.out.println("Elenco risultati:");
		if ((noISBN == true) && (noTit == true) && (noAut == true) && (noCed == true) && (noAed == true)) { //non sono stati inseriti i campi
			System.out.println("Elemento non trovato");
		} else {
			ArrayList<Libro> libriRicerca = new ArrayList<Libro>();
			ArrayList<Collocazione> collocazioniRicerca = new ArrayList<Collocazione>();
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

			int scelta=0;
			while(scelta!=1){
				scelta=menuRicerca();
				switch(scelta){
				case 1:
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
								if(Login==true)	recensionelogin((c-1),rec,utentelogin);
								else	recensione((c-1),rec);
								error=false;
							}
							else	error=true;
						}
						
					}
					else{
						rec=libriRicerca.get(0);
						if(Login==true)	recensionelogin(0,rec,utentelogin);
						else	recensione(0,rec);
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
								//rec=libriRicerca.get((c-1));
								//singolaConsultazione(utentelogin, rec);
								for(int i=0 ; i<catalogo.getLibri().size() ; i++) {
									if ( libriRicerca.get(c-1)==catalogo.getLibri().get(i) ) {
										rec=catalogo.getLibri().get(i);
										singolaConsultazione(utentelogin, rec);
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
						//rec=libriRicerca.get(0);
						//singolaConsultazione(utentelogin, rec);
						for(int i=0 ; i<catalogo.getLibri().size() ; i++) {
							if ( libriRicerca.get(0)==catalogo.getLibri().get(i) ) {
								rec=catalogo.getLibri().get(i);
								singolaConsultazione(utentelogin, rec);
								catalogo.getLibri().get(i).setDisponibile(false);
								break;
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
	 * @param u Utente registrato 
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
	 * Metodo che consente di creare un abbonamento associandolo 
	 * all'utente registrato e consentedogli di pagare tramite 
	 * l'inserimento dei dati della propria carta di credito
	 * @throws IOException _
	 */
	public void abbonamento() throws IOException{
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
			LocalDate di = LocalDate.now();
			LocalDate df = di.plusMonths(1);
			Abbonamento ab = new Abbonamento(di,df,true,utentelogin);
			ab.stampaAbbonamento();
			abbonamenti.add(ab);
		}
		
		
	}
	/**
	 * Metodo che permette di inserire una recensionea un utente non registrato sul libro cercato tramite un giudizio
	 * e un commento personale sul libro in questione
	 * @param n Numero di libro da recensire tra quelli cercati
	 * @param l Libro cercato
	 * @throws IOException _
	 */
	public void recensione(int n, Libro l) throws IOException{
		Recensione r = new Recensione();
		r.setLibro(l);
		System.out.println("Recensisci " + l.getTitolo() + ":");
		System.out.print("Esprimi un voto da 1 a 5 -> ");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String choice = stdin.readLine();  
		int v=0;
		try {  
			v = Integer.parseInt(choice);
		} catch (NumberFormatException ec) {
			System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
			
		}
		r.setVoto(v);
		System.out.print("Esprimi una descrizione -> ");
		choice = stdin.readLine();  
		r.setDescrizione(choice);
		System.out.println("Recensione effettuata con successo"); 
		
	}
	/**
	 * Metodo che permette di inserire una recensionea un utente registrato sul libro cercato tramite un giudizio
	 * e un commento personale sul libro in questione
	 * @param n Numero di libro da recensire tra quelli cercati
	 * @param l Libro cercato 
	 * @param u Utente che fa la recensione
	 * @throws IOException _
	 */
	public void recensionelogin(int n, Libro l, UtenteRegistrato u) throws IOException{
		Recensione r = new Recensione();
		r.setLibro(l);
		r.setUtenteRegistrato(u);
		System.out.println("Recensisci " + l.getTitolo() + ":");
		System.out.print("Esprimi un voto da 1 a 5 -> ");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String choice = stdin.readLine();  
		int v=0;
		try {  
			v = Integer.parseInt(choice);
		} catch (NumberFormatException ec) {
			System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
			
		}
		r.setVoto(v);
		System.out.print("Esprimi una descrizione -> ");
		choice = stdin.readLine();  
		r.setDescrizione(choice);
		System.out.println("Recensione effettuata con successo"); 
		
	}
	/**
	 * Metodo che consente all'utente registrato di fare una singola
	 * consultazione di un libro speciae
	 * @param u Utente Registrato 
	 * @param l Libro da consultare
	 * @throws IOException _
	 */
	public void singolaConsultazione(UtenteRegistrato u, Libro l) throws IOException{
		if(l.isDisponibile()){
			System.out.println();
			System.out.println("Il libro scelto è disponibile alla consultazione"); 
			System.out.println();
			boolean abbonato = false;
			for(int i=0;i<abbonamenti.size();i++){
				if(abbonamenti.get(i).getPagato()){
					abbonato=true;
					break;
				}
			}
			if(abbonato){
				System.out.println();
				System.out.println("Possiedi un abbonamento alla consultazione");
				System.out.println("Puoi ritirare il libro dalle " + LocalTime.now() + " e consegnarlo in data odierna alle " + LocalTime.of(18, 00)); 
				System.out.println();
				Consultazione con = new Consultazione();
				con.setPagato(true);
				con.setLibro(l);
				con.setUtenteRegistrato(u);
				con.setDataOraRitiro(LocalDateTime.now());
				con.setDataOraRitiro(LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 00)));
				consultazioni.add(con);
			}else {
				System.out.println();
				System.out.println("Non possiede un abbonamento alla consultazione"); 
				System.out.println();
				String text = null;
				int scelta = 0;
				do{
					System.out.println("Puoi comunque consultare il libro grazie al servizio a pagamento di singola consultatione");
					System.out.println("Vuoi procedere con il pagamento?");
					System.out.print("1 - PAGA	2 - ANNULLA -->");
					BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
					text = stdin.readLine(); 
					
					try {  
						scelta = Integer.parseInt(text);
					} catch (NumberFormatException ec) {
						System.out.println("Stringa errata inserire un valore numerico per indicare l'anno di edizione"); 
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
					System.out.println("Puoi ritirare il libro dalle " + LocalTime.now() + " e consegnarlo in data odierna alle " + LocalTime.of(18, 00)); 
					System.out.println();
					Consultazione con = new Consultazione();
					con.setPagato(true);
					con.setLibro(l);
					con.setUtenteRegistrato(u);
					con.setDataOraRitiro(LocalDateTime.now());
					con.setDataOraRitiro(LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 00)));
					consultazioni.add(con);
				}
			}
		}
	}
	/**
	 * Metodo che consente all'utente registrato di richiedere la proroga di un prestito
	 */
	public void prorogaPrestito(){
		
	}
	/**
	 * Metodo che consente all'utente registrato di controllare i prestiti
	 */
	public void controlloPrestiti(){
		
	}
	/**
	 * Metodo che consente al sistema di richiamare l'utente che non rispetta
	 * la consegna di un libro
	 */
	public void richiamoPrestito(){
		
	}
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
			if(n >= 65 && n <=90)	capital=true;
			//Controllo spazio
			if(n == 32)	space=true;
			//controllo punteggiatura
			if((n>=33 && n<=47) || (n>=58 && n<=64) || (n>=91 && n<=96))	punctuation=true;
			//controllo numeri
			if(n>=48 && n<=57)	number=true;
			i++;
			//( capital != true && space != true && punctuation != true && number != true )
		}
		if( capital == true && space == false && punctuation == true && number == true ){
			//System.out.println("Password corretta");
			return true;
		}
		else{
			/*if(capital==false)	System.out.println("Inserire almeno un lettera maiuscola");
			if(space==true)	System.out.println("Non si possono inserire spazi nella password");
			if(punctuation==false)	System.out.println("Inserire almeno un carattere speciale di punteggiatura");
			if(number==false)	System.out.println("Inserire almeno un numero");
			System.out.print("psw errata");*/
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
		if(utentiRegistrati.get(IdUtenteLogin).getPassword().equals(p))	return true;
		return false;
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
	 * suggerire un'acquisto di un libro
	 * @throws IOException _
	 */
	public void suggerisciAcquisto() throws IOException{
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
			libroSuggerito=l;
			libroSuggerito.stampaLibro();
		}
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
				System.out.println("Benvenuto/a" + utentelogin.Nome +  "nel sistema di gestione delle Biblioteche");
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
	 * Permette di aggiungere un'utente alla lista di utenti registrati
	 * @param u Dati utente da registrare
	 */
	public void setUtente(UtenteRegistrato u){
		utentiRegistrati.add(u);
	}
}
