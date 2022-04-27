Il programma è costituito da questi tre elementi:

- Dispatcher, che offre due servizi: sendCmd e getCmd.
Il servizio void sendCmd(int command) consente l’invio al Dispatcher del comando che sarà
eseguito sul device; command identifica una specifica operazione sul device richiesta da Client.
Il Dispatcher inserisce il comando ricevuto in una coda circolare di dimensione pari a 5 nell’attesa
che venga successivamente prelevato da Actuator tramite l’invocazione di int getCmd().
L’accesso alla coda rispetta i vincoli del produttore-consumatore.

- Client: genera 5 thread, ciascuno dei quali, allo scadere di un tempo di t secondi (con t scelto a caso
tra 2 e 4) invoca sendCmd, con command scelto a caso tra 0-leggi, 1-scrivi, 2-configura, 3-reset.
Ciascun thread effettua 3 richieste.

- Actuator: Invoca getCmd()ogni secondo; getCmd estrae il comando dalla testa della coda e lo
restituisce ad Actuator. Se la coda è vuota, la richiesta getCmd è messa in attesa. Il comando
restituito da getCmd è stampato a video ed accodato al file cmdlog.txt.