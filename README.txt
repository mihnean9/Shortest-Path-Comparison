Nicolau Mihnea-Andrei, 321CD, Tema AA etapa 2 - problema 5.1

Pentru rezolvarea problemei am implementat 5 algoritmi:
- algo1 = dijkstra implementat cu lista oarecare (in loc de coada de prioritati);
- algo2 = dijkstra implementat cu coada de prioritati;
- algo3 = bellman-ford folosind N-1 iteratii prin intregul set de muchii si 
		  verificare pentru existenta ciclurilor de cost negativ (caz in care
		  intoarce un Array null si in output se va afisa existenta ciclului);
- algo4 = bellman-ford implementat cu o coada in care se afla nodurile de
		  interes (se va itera muchiile care pornesc din aceste noduri spre 
		  deosebire de intregul set de muchii ca in algo3);
- algo5 = gasirea drumului minim folosind sortare topologica (merge doar pe dag);

Toti cei 5 algoritmi folosesc acelasi antet sugerat in enunt:
List<Integer> shortestPath(List<List<Edge>> graph, int source);

Pentru a ajunge de la input la o List<List<Edge>> si pentru generarea unor
output-uri (retinute in folderul other_outputs) am adaugat o clasa Main cu metodele
"interpretInput" si "printOutputToFile".

Testele au fost generate cu TestGenerator.java, inclus si el in arhiva.
Am ales sa testez in functie de anumiti parametri, astfel:
test0: 100 noduri, 200 muchii - graf nu foarte mare, cu putine muchii;
test1: 100 noduri, 8000 muchii - graf nu foarte mari, destul de dens;
test2: 10000 noduri, 50000 muchii - graf mare;
test3: 1000 noduri, 8000 muchii, sursa nodul 5 (toate celelalte teste au ca 
	   sursa nodul 0);
(in testele 0-3 si 6-7 nu exista muchii de cost negativ) 
test4: 1000 noduri, 2000 muchii, cost negativ - ilustreaza impracticalitatea
	   lui dijkstra pe grafuri cu muchii de cost negativ;
test5: 10 noduri, 20 muchii, ciclu de cost negativ (pentru verficarea din algo3);
test6: 1000 noduri, 999 muchii => lant (merge aplicat si algo5);
test7: 1000 noduri, 2000 muchii, graf aciclic (voi folosi acest test pentru 
	   demonstrarea eficientei lui algo5 pe grafuri aciclice)
	   
In folderul out se afla raspunsurile corecte pentru fiecare test (pentru test5
output-ul difera de celelalte, deoarece nu poate exista un raspuns bun pentru
cicluri de cost negativ).

Makefile are optiunile: build, run si clean (curata si other_outputs).

Am adaugat un folder other_outputs in care am pus output-urile algoritmilor pe 
care vreau sa ii compar (in etapa 3) pe acel test:
test0, test1, test3 - outputul tuturor celor 5 algo (algo5 va da raspuns gresit,
					  deoarece grafurile nu sunt aciclice);
test2 - outputul lui dijkstra cu PQ si bellman-ford cu coada;
test4 - outputul tuturor celor 5 algo pt. un graf aciclic, dar cu muchii negative;
test5 - outputul gresit furnizat de dijkstra si outputul verificarii din bellman;
test6, test 7 - outputul tuturor celor 5 algo pe graf aciclic;