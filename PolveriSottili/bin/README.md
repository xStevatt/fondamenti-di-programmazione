# Polveri Sottili
Questa applicazione vuole gestire un sistema per l'inserimento, la gestione e l'analisi dei dati delle polveri sottili di una particolare città. 
#### Funzionamento
Avviata l'esercuzione del programma viene presentato a schermo il menù, il quale mostra le varie opzioni che possono essere scelte dall'utente. In modo particolare: 
0. Uscire dal programma
1. Aggiungi una settimana (verranno conisderati i dati anche delle settimane precedenti)
2. Visualizza dati delle settimane consecutive inserite
3. Aggiungi una settimana (senza considerare le precedenti)
4. Visualizza i dati di tutte le settimane inserite

A seconda della pressione dei tasti: 
* Prenmendo il tasto "sentinella" 0, il programma termina immediatamente, fornendo un saluto finale. 
* Premendo il tasto 1, il programma comincia l'aggiunta della settimana, e aggiunge la settimana ad un arraylist, la quale si occupa di conservare tutte le settimane inserite consecutivamente. Inoltre la settimana inserita viene inserita anche all'intero di un altro arraylist, il quale mantiene al suo interno tutte le settimane inserite (anche se non consectutive o inserite singolarmente), in questo modo sarà possibile visualizzare i dati di tutte le settimane inserite. 
* Premendo il tasto 2, il programma permette di visualizzare i dati di tutte le settimane inserite fino a quel momento consecutivamente ed effettuare l'analisi dei dati. L'analisi è la seguente: se la media delle polveri sottili giornaliere supera il 50 (media > 50), allora mostra un allarme a schermo; se il massimo valore rilevato è maggiore di 75 (max > 75), allora viene mostrato un allarme a schermo. 
* Premendo il tasto 3, premendo invio, il programma permette l'aggiunta di una nuova settimana singola, senza dover considerare altre settimane. Alla fine dell'inserimento dei dati, essi vengono analizzati come spiegato precedentemente. 

Il programma permette di aggiungere settimane. L'aggiunta della settimana consiste nel richiedere all'utente i seguenti dati:
* L'anno in cui si trova la settimana inserita
* Il numero della settimana nell'anno (potrà essere minimo 1, massimo 53)
* I dati, giorno per giorno, delle polveri sottili rilevate in quel particolare giorno.

