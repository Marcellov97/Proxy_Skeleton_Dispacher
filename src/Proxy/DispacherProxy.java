package Proxy;

import Interface.Dispacher;
import java.net.*;
import java.io.*;

public class DispacherProxy implements Dispacher {
	
	//Socket del proxy
	private DatagramSocket socket;
	
	
	//Costruttore
	public DispacherProxy() {
		try {
			socket = new DatagramSocket();
			
		}
		catch(SocketException ex) {
			ex.getStackTrace();
			
		}
	}

	@Override
	public void sendCmd(int command) {
		//Creo il messaggio da inviare al Server
		String mex = new String("sendCmd#" + command + "#");
		
		//Creo il collegamento con la socket
		try {
			//pacchetto UDP
			DatagramPacket request = new DatagramPacket(mex.getBytes(), mex.getBytes().length, InetAddress.getLocalHost(), 9000);
			
			//invio il pacchetto
			socket.send(request);
			System.out.println("PROXY - inviato messaggio");
			//attendo la risposta
			
			byte[] buffer = new byte[100]; //TODO ridurre la dimensione del vettore di byte di risposta
			DatagramPacket risposta = new DatagramPacket(buffer, buffer.length);
			
			socket.receive(risposta);
			System.out.println("PROXY - ricevuto risposta");
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}

	}

	@Override
	public int getCmd() {
		//creo il messaggio da inviare al Server
		String mex = new String("getCmd#");
		
		//creo variabile per il ritorno
		int temp = 0;
		
		//Creo il collegamento con la socket
		try {
			//pacchetto UDP da inviare
			DatagramPacket request = new DatagramPacket(mex.getBytes(), mex.getBytes().length, InetAddress.getLocalHost(), 9000);
			
			//invio il pacchetto
			socket.send(request);
			
			//attendo la risposta
			byte[] buffer = new byte[100];
			DatagramPacket risposta = new DatagramPacket(buffer, buffer.length);
			socket.receive(risposta);
			
			//TODO controllare un modo pi� semplice per far questo passaggio
			temp = Integer.valueOf(new String(risposta.getData(), 0, risposta.getData().length)).intValue();
			
			
		}
		catch(IOException ex) {
			ex.getStackTrace();
			
		}
		return temp;
	}

}
