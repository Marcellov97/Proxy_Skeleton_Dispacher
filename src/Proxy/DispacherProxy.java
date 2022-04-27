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
			
			//attendo la risposta
			
			byte[] buffer = new byte[100];
			DatagramPacket risposta = new DatagramPacket(buffer, buffer.length);
			
			socket.receive(risposta);
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}

	}

	@Override
	public int getCmd() {
		// TODO Auto-generated method stub
		return 0;
	}

}
