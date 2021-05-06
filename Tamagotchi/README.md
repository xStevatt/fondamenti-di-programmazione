# Tamagotchi
Questa applicazione vuole simulare il famoso gioco "Tamagochi", il quale permette di gestire un animale, accudendolo, dandogli cibo e cura. Versione completa.
#### Funzionamento 
Avviata l'esecuzione del programma, vengono richieste in input una serie di informazioni base riguardanti il Tamagotchi:
* il nome del Tamagotchi [type: String]
* il grado di **soddisfazione affettiva iniziale** [type: int]
* il grado di **sazietà iniziale** [type: int]

Verrano forniti due tipi di dati riguardanti il tamagotchi: se è felice o infelice, e il suo grado di benessere generale. Il grado generale di benessere è dato dalla media pesata del grado di *soddisfazione affettiva* e il grado di *sazietà iniziale*. 

Una volta richieste queste informaizioni di base, il cui inserimento è necessariamente richiesto, è possibile scegliere se si vuole cambiare il peso della soddisfazione affettiva e del grado di sazietà. 
1. L'utente sceglie di non modificare i dati: i due pesi vengono impostati a uno di default. 
2. L'utente sceglie di modificare i dati, e quindi vengono richiesti i due pesi in input

Una volta terminata questa parte introduttiva di input, vengono mostrate le statistiche del tamagotchi in base ai valori di default che sono stati inseriti. 

Infine, si mostra all'utente il menù che mostra le azioni che si possono svolgere: 
1. Dare dei biscotti (numero generato randomicamente tra 0 - 20) [tasto: 1]
2. Dare delle carezze (numero generato randomicamente tra 0 - 20) [tasto: 2]
3. Uscire dal programma [tasto "sentinella": 0]

Nel caso in cui si inseriscano più biscotti di seguito (lo stesso vale se vengono date tante carezze in continuazione), allora esse avranno un effetto minore (ne viene contata solo una/uno). 

I valori di riferimento affinché il tamagotchi sia felice o infelice sono quelli presenti nelle richieste della consegna. 