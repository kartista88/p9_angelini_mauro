# p9_angelini_mauro
Guida al progetto

Una volta importato il progetto java su eclipse è possibile leggere la documentazione relativa ai dettagli implementativi nella cartella /doc dove sono presenti i file javadoc, per vedere tutta la documentazione completa si consiglia di aprire il file index.html
A questo punto è possibile eseguire il progetto java su eclipse dove si aprira la console di eclipse con il menu principale: 

Benvenuto/a nel sistema di gestione delle Biblioteche

-------------------------MENU----------------------

1-	Login
2-	Iscriviti
3-	Ricerca
4-	Suggerisci acquisto prodotto
5- 	Esci
Inserisci un numero da 1 a 5 e premi INVIO -> __

E siccome nel sistema sono già stati caricati dei dati da file è possibile effettuare il log in ( premendo 1 ) inserendo come credenziali:

Username:	mauro
Password:	Mauro.88

Oppure è possibile iscriversi ( premendo 2 ) inserendo i propri dati badando di ricordarsi i propri dati, il sistema per questo task ha le seguenti caratteristiche:
- è in grado di bloccare un'iscrizione se l'utente ha un'età minore di 13 anni
- è in grado di verificare che lo username non sia già presente tra gli utenti iscritti
- controlla che la password inserita abbia le seguenti caratteristiche -> 1 . Deve contenere almeno 8 caratteri; 2 . Deve avere almeno un segno di punteggiatura; 3 . Deve contenere almeno un numero.

Iscriviti come utente registrato:
Compila tutti i campi obbligatori*
Nome:		Nome
Cognome:	Cognome
Età:		13
Indirizzo:	Indirizzo
Email:		Email
Telefono:	010
Username:	Username
Password:	Passw0rd!

Per effettuare la ricerca di libri ( premere 3 ) e apparirà inizialmente:

Pannello di ricerca libri, qui puoi cercare i libri inserendo da uno a tutti i campi disponibili:
ISBN:

Infatti la ricerca è pensata per permettere di poter inserire se si ritiene un campo alla volta, in modo da poter impostare la ricerca da 0 a 4 campi di disponibili per cercare un libro. Per esempio se si vuole cercare solo per ISBN si inserisce il valore e si preme invio e si lasciano vuoti gli altri campi premendo semplicemente invio. I risultati della ricerca possono portare a uno o piu libri:

ISBN:	
Titolo:	
Autore:	NationalGeografic
Casa editrice:	
Anno edizione:	
Elenco risultati:

Catalogo :Librario

Dati libro

Disponibile: true
ISBN: ISBN978-88-540-3044-2
Titolo: Alaska
Autore: NationalGeografic
CasaEditrice: EdizioniWhiteStar
AnnoEdizione: 2016

Collocazione libro

Sezione: Turismo
Scaffale: 4
NumeroSeriale: AL1
Dati Biblioteca:
Nome: Biblioteca Centrale
Indirizzo: CorsoMarche34R
Telefono: 01854465254



Catalogo :Librario

Dati libro

Disponibile: false
ISBN: ISBN978-88-540-3041-1
Titolo: Granbretagna
Autore: NationalGeografic
CasaEditrice: EdizioniWhiteStar
AnnoEdizione: 2016

Collocazione libro

Sezione: Turismo
Scaffale: 4
NumeroSeriale: GR2
Dati Biblioteca:
Nome: Biblioteca Centrale
Indirizzo: CorsoMarche34R
Telefono: 01854465254

Effettuata la ricerca appare questo sotto menu se non si ha effettuato la log in

Benvenuto/a nel sistema di gestione delle Biblioteche
-------------------------MENU----------------------
1-	Torna a menu
2-	Recensisci
Inserisci un numero tra 1 e 2 e premi INVIO -> __

Si può recensire il libro o i libri trovati ( premendo 2 ) o tornare indietro al menu principale ( premendo 1 )

Quale libro vuoi recensire?
1) Alaska
2) Granbretagna
Inserisci un numero da 1 a 3 e premi INVIO -> __2
Recensisci Granbretagna:
Esprimi un voto da 1 a 5 -> 5
Esprimi una descrizione -> Consigliatissimo

Tornando al menu principale è possibile suggerire l'acquisto di un libro ( premendo 4 ) e appare analogamente alla ricerca la possibilità di inserire da 1 a 4 campi dove l'utente può o scrivere ( scrivendo e premendo invio ) o lasciare vuoto ( premendo solo invio )

Inserisci qui i dati del libro di cui vuoi suggerire l'acquisto:
ISBN:	
Titolo:	Africa
Autore:	NationalGeografic
Casa editrice:	
Anno edizione:	
Elenco risultati:

Richiesta inserita correttamente


Dati libro

Disponibile: false
ISBN: null
Titolo: Africa
Autore: NationalGeografic
CasaEditrice: null
AnnoEdizione: 0

Ora passiamo a parlare del menu da utente registrato che ha effettuato il log in:

Benvenuto/a Mauro nel sistema di gestione delle Biblioteche
-------------------------MENU----------------------
1-	Ricerca
2- 	Abbonati
3-	Suggerisci acquisto prodotto
4- 	Logout
5- 	Esci
Inserisci un numero da 1 a 5 e premi INVIO -> __

In questo menu se si effettua una ricerca il sotto menu corrispondente differisce da prima:

Benvenuto/aMauronel sistema di gestione delle Biblioteche
-------------------------MENU----------------------
1-	Torna a menu
2-	Recensisci
3-	Prenota
4-	Consulta
Inserisci un numero da 1 a 4 e premi INVIO -> __

Consente la prenotazione ( premendo 3 )

Libro disponibile
Dati prestito:

Dati libro

Disponibile: false
ISBN: ISBN978-88-540-3091-4
Titolo: Cina
Autore: NationalGeografic
CasaEditrice: EdizioniWhiteStar
AnnoEdizione: 2016
Utente registrato:
Nome:		Mauro
Cognome:	Angelini
Età:		25
Indirizzo:	Via Piantelli 2A / 24
Email:		mauro91ge@gmail.com
Telefono:	3207065215
Username:	mauro
Password:	Mauro.88
Data di ritiro: 2017-05-26
Data di consegna: 2017-06-09

E il sistema consente il prestito se il libro è disponibile riportando la collocazione, la data di ritiro e la data di consegna

Consente la consultazione ( premendo 4 )

Il libro scelto è disponibile alla consultazione


Non possiede un abbonamento alla consultazione

Puoi comunque consultare il libro grazie al servizio a pagamento di singola consultatione
Vuoi procedere con il pagamento?
1 - PAGA	2 - ANNULLA -->

In questo caso l'utente non è abbonato ma può procedere a pagare la singola consultazione
Immette quindi numero di carta e codice di 3 cifre riportato sul retro

Immettere il codice della carta -> 
5338750189965335
Immettere il codice di sicurezza -> 
895
Puoi ritirare il libro dalle 17:45:40.703 e consegnarlo in data odierna alle 18:00

Conferma il pagamento l'utente ha un mese di abbonamento il sistema apre la consultazione che inizia dall'ora del pagamento fino alla chiusura della biblioteca quindi alle 18 : 00

Tornando al menu principale vado spiegare l'abbonamento mensile alla consultazione ( premendo 2 )

Qui potrai abbonarti al servizio di consultazione, ti offriamo un abbonamento mensile
Vuoi procedere con il pagamento?
1 - CONFERMA	2 - RIFIUTA -->1
Immettere il codice della carta -> 
53387501189891
Immettere il codice di sicurezza -> 
253
Abbonamento :
Data di inizio: 2017-05-26
Data di fine: 2017-06-26
Pagato: true
Utente registrato:
Nome:		Mauro
Cognome:	Angelini
Età:		25
Indirizzo:	Via Piantelli 2A / 24
Email:		mauro91ge@gmail.com
Telefono:	3207065215
Username:	mauro
Password:	Mauro.88

Il sistema chiede i dati della carta di credito (unico metodo di pagamento) e una volta confermato indica la data di inizio e fine abbonamento all'utente

Infine tratto le ultime due ozpioni del menu principale:
- Log out , fa tornare al menu principale da utente non loggato ( premendo 4 )
- Esci , fa uscire dalla console ( premendo 5 )
