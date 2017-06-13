package Biblioteca;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe di interfaccia che si occupa di inizializzare tutti i dati essenziali come
 * i libri, le collocazioni e gli utenti. Inoltre gestisce l'interfaccia utente con la classe gestore infatti
 * mette a disponizione un menu per l'utente non registrato che consente di iscriversi e fare il login accedendo
 * a ulteriori funzioni in un menu dedicato all'utente registrato
 * @author Mauro
 *
 */
public class Main {
	/**
	 * Funzione principale dell'interfaccia dove vengono richiamati il menu 
	 * per l'utente non collegato e il menu per l'utente collegato consentendogli
	 * di passare da un menu all'altro grazie a un'interfaccia intuitiva
	 * @param args _
	 * @throws IOException _
	 */
	public static void main(String[] args) throws IOException{
		Gestore gestoreCentrale = new Gestore();
		//Fase di lettura da file dei dati di Cataloghi, Biblioteche, Libri e Collocazioni:
		FileReader fileCatalog;
		
		
		fileCatalog=new FileReader("catalog.txt");

		BufferedReader bufferCatalog;
		bufferCatalog=new BufferedReader(fileCatalog);
		Catalogo catalog = new Catalogo();
		String line = null;
		while(bufferCatalog.read()!=-1){
	        //do something with line
			line = bufferCatalog.readLine();
			line = bufferCatalog.readLine();
	    	catalog.setTipo(line);
	    }
		
		bufferCatalog.close();
		
		FileReader fileBooks;

		fileBooks=new FileReader("books.txt");

		BufferedReader bufferBooks;
		bufferBooks=new BufferedReader(fileBooks);
		ArrayList<Libro> li = new ArrayList<Libro>();
		while(bufferBooks.read()!=-1){
			Libro l= new Libro();	
			line = bufferBooks.readLine();
			if(line.contains("S")==true){
				l.setDisponibile(true);
			}
			else{
				l.setDisponibile(false);
			}
			line = bufferBooks.readLine();
			l.setISBN(line);
			line = bufferBooks.readLine();
			l.setTitolo(line);
			line = bufferBooks.readLine();
			l.setAutore(line);
			line = bufferBooks.readLine();
			l.setCasaEditrice(line);
			line = bufferBooks.readLine();
			l.setAnnoEdizione(Integer.parseInt(line));
			//l.stampaLibro();
			li.add(l);
			//catalog.addLibro(l);
			line = bufferBooks.readLine();
		}
		
		
	    FileReader fileCollocation;

		fileCollocation=new FileReader("collocation.txt");

		BufferedReader bufferCollocation;
		bufferCollocation=new BufferedReader(fileCollocation);
		ArrayList<Collocazione> co = new ArrayList<Collocazione>();
		while(bufferCollocation.read()!=-1){
			line = bufferCollocation.readLine();
			Collocazione c = new Collocazione();
			line = bufferCollocation.readLine();
			c.setSezione(line);
			line = bufferCollocation.readLine();
			c.setScaffale(line);
			line = bufferCollocation.readLine();
			c.setNumeroSeriale(line);
			Biblioteca b = new Biblioteca();
			line = bufferCollocation.readLine();
			b.setNome(line);
			line = bufferCollocation.readLine();
			b.setIndirizzo(line);
			line = bufferCollocation.readLine();
			b.setTelefono(line);
			c.setBiblioteca(b);
			co.add(c);
		}
		
	
		//Salvo i dati acquisiti nella classe principale
		
		catalog.setLibri(li);
		catalog.setCollocazioni(co);
		gestoreCentrale.setCatalogo(catalog);
		
	    FileReader fileUser;

		fileUser = new FileReader("User.txt");

		BufferedReader bufferUser;
		bufferUser = new BufferedReader(fileUser);
		UtenteRegistrato u = new UtenteRegistrato();
		line = bufferUser.readLine();
		u.setNome(line);
		line = bufferUser.readLine();
		u.setCognome(line);
		line = bufferUser.readLine();
		u.setEta(line);
		line = bufferUser.readLine();
		u.setIndirizzo(line);
		line = bufferUser.readLine();
		u.setEmail(line);
		line = bufferUser.readLine();
		u.setTelefono(line);
		line = bufferUser.readLine();
		u.setUsername(line);
		line = bufferUser.readLine();
		u.setPassword(line);
		gestoreCentrale.addUtenteRegistrato(u);
		
		
		int scelta=1;
		while(scelta!=5){
			scelta=menuPrincipale();
			switch(scelta){
			case 1:
				gestoreCentrale.menuLogIn();
				while(gestoreCentrale.isLogin()){
					int sceltalogin=1;
					while(sceltalogin!=4 && sceltalogin!=5){
						sceltalogin=menuPrincipaleLogin(gestoreCentrale.getUtentelogin().getNome());
						switch(sceltalogin){
						case 1:
							gestoreCentrale.preMenuRicerca();
							break;
						case 2:
							gestoreCentrale.menuAbbonamento();
							break;
						case 3:
							gestoreCentrale.menuSuggerisciAcquisto();
							break;
						case 4:
							gestoreCentrale.logOut();
							break;
						case 5:
							break;
						}
						
					}
				}
				break;
			case 2:
				gestoreCentrale.menuIscrivi();
				break;
			case 3:
				gestoreCentrale.preMenuRicerca();
				break;
			case 4:
				gestoreCentrale.menuSuggerisciAcquisto();
				break;
			case 5:
				break;
			}
		}
		 System.out.println("Grazie per aver scelto la nostra applicazione e torna a trovarci");
		
		
		bufferBooks.close();
		bufferCatalog.close();
		bufferCollocation.close();
		bufferUser.close();
	}
	/**
	 * Metodo che gestisce il menu del generico utente che pu� essere registrato o meno ma che sicuramente non 
	 * ha effetuato il log in
	 * @return Scelta dell'utente nel menu
	 * @throws IOException _
	 */
	public static int menuPrincipale() throws IOException{
		boolean error = true;
		int c=0;
		while(error==true){
			System.out.println("Benvenuto/a nel sistema di gestione delle Biblioteche");
			System.out.println("-------------------------MENU----------------------");
			System.out.println("1-	Login");
			System.out.println("2-	Iscriviti");
			System.out.println("3-	Ricerca");
			System.out.println("4-	Suggerisci acquisto prodotto");
			System.out.println("5- 	Esci");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Inserisci un numero da 1 a 5 e premi INVIO -> __");
			String choice = stdin.readLine();  
			
			try {  
				c = Integer.parseInt(choice);
			} catch (NumberFormatException ec) {
				System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
				error=true;
			}
			if(c>=1 && c<=5){
				error=false;
			}
			else	error=true;
		}
		return c;
	}
	/**
	 * Metodo che gestisce il menu di un utente che ha effettuato il log in 
	 * @param name Nome utente loggato
	 * @return Scelta dell'utente
	 * @throws IOException _
	 */
	public static int menuPrincipaleLogin(String name) throws IOException{
		boolean error = true;
		int c=0;
		while(error==true){
			System.out.println("Benvenuto/a " + name + " nel sistema di gestione delle Biblioteche");
			System.out.println("-------------------------MENU----------------------");
			System.out.println("1-	Ricerca");
			System.out.println("2- 	Abbonati");
			System.out.println("3-	Suggerisci acquisto prodotto");
			System.out.println("4- 	Logout");
			System.out.println("5- 	Esci");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Inserisci un numero da 1 a 5 e premi INVIO -> __");
			String choice = stdin.readLine();  
			
			try {  
				c = Integer.parseInt(choice);
			} catch (NumberFormatException ec) {
				System.out.println("Stringa errata inserire un valore numerico per indicare la scelta"); 
				error=true;
			}
			if(c>=1 && c<=5){
				error=false;
			}
			else	error=true;
		}
		return c;
	}
	
}