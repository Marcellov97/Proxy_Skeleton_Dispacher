package Skeleton;

import Interface.Dispacher;

public class DispacherImpl implements Dispacher {
	
	//Variabili della coda circolare
	private int[] coda_circolare;
	private int lunghezza;
	private int testa;	//dove si estrae (POP)
	private int coda;	//dove si inserisce (PUSH)
	private int n_elem;
	
	//Variabili di sincronizzazione
	private boolean full;
	private boolean empty;
	
	public DispacherImpl() {
		coda_circolare = new int[5];
		lunghezza = 5;
		testa = 0;
		coda = 0;
		n_elem = 0;
		full = false;
		empty = true;
		
	}
	
	synchronized private boolean push(int a) {	//inserisce valore nella coda circolare
		if(full) {
			return false;
		}
		else {
			coda_circolare[coda] = a;
			n_elem ++;
			if(n_elem == lunghezza) {
				full = true;
			}else {
				full = false;
			}
			empty = false;
			if(coda == lunghezza-1) {
				coda = 0;
			}
			else {
				coda ++;
			}
			return true;
		}
	}
	
	synchronized private int pop() {	//estrae e cancella elemento dalla coda circolare
		if(empty) {
			return -1;
		}
		else {
			int ris = coda_circolare[testa];
			n_elem--;
			full = false;
			if(n_elem == 0) {
				empty = true;
			}else {
				empty = false;
			}
			if(testa == lunghezza-1) {
				testa = 0;
			}else {
				testa ++;
			}
			return ris;
		}
	}

	@Override
	public void sendCmd(int command) {
		this.push(command);

	}

	@Override
	public int getCmd() {
		int res = this.pop();
		return res;
	}

}
