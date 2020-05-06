# StarWarsInfo
Training app

L’app in questione dovrà visualizzare alcune informazioni sul mondo di Star Wars, tra cui personaggi, pianeti e astronavi; tutti i dati dovranno essere recuperati tramite chiamate alle API esposte dai servizi di https://swapi.co/.
 
#Requisiti app
L’app deve essere costituita da una pagina principale in cui sono presenti tre pulsanti:
“People”
“Planets”
“Starships”
Al tap di uno di questi, verrà mostrata la lista relativa recuperata tramite chiamata alle API. Ciascun elemento delle liste deve essere tappabile e deve poter permettere la visualizzazione dei dettagli dell’elemento selezionato.
 
#Requisiti tecnici
L’architettura dell’app deve rispettare i dettami del pattern MVP (utilizzerei come base di partenza il link del sample di googlehttps://github.com/googlesamples/android-architecture/tree/todo-mvp).
Le liste devono essere implementate tramite l’utilizzo di RecyclerView.
Le chiamate alle API di https://swapi.co/ dovranno essere effettuate tramite la libreria Retrofit.
Per la serializzazione/deserializzazione di oggetti da JSON deve essere effettuata tramite libreria Jackson.
