package Skeleton;

import java.net.*;
import Interface.Dispacher;

public class DispacherSkeleton implements Dispacher {
	
	private DatagramSocket socket;
	private Dispacher implementazione;
	
	public DispacherSkeleton() {
		implementazione = new DispacherImpl();
		try {
			socket = new DatagramSocket(9000);
		}
		catch(SocketException ex) {
			ex.getStackTrace();
		}
	}
	
	public void runSkeleton() {
		
		try {
			byte[] buffer = new byte[100];
			DatagramPacket pacchetto = new DatagramPacket(buffer, buffer.length);
			
			socket.receive(pacchetto);
			//estraggo informazioni dal pacchetto
			InetAddress addr = pacchetto.getAddress();
			int port = pacchetto.getPort();
			int lenght = pacchetto.getLength();
			byte[] data = pacchetto.getData();
			// trasformo il messaggio in stringa ed estraggo le info
			String messaggio = new String(data);
			String[] info = messaggio.split("#");
			
			
			//controllo quale metodo richiamare
			if(info[0] == "sendCmd") {	//send command
				int command = Integer.parseInt(info[1]);
				this.sendCmd(command);
				
				//creo il messaggio di risposta
				String mex = new String(String.valueOf(0));
				
				//pacchetto UDP
				DatagramPacket risposta = new DatagramPacket(mex.getBytes(), 0, lenght, addr, port);
				
				//invio pacchetto
				socket.send(risposta);
			}
			else {
				if(info[0] == "getCmd") {	//get command
					int result = this.getCmd();
					
					//creo il messaggio di risposta
					String mex = new String(String.valueOf(result));
					
					//pacchetto UDP
					DatagramPacket risposta = new DatagramPacket(mex.getBytes(), 0, mex.getBytes().length, addr, port);
					
					//invio pacchetto
					socket.send(risposta);
				}
			}
		}
		catch(Exception ex) {
			ex.getStackTrace();
		}
	}
	

	@Override
	public void sendCmd(int command) {
		implementazione.sendCmd(command);

	}

	@Override
	public int getCmd() {
		int a = implementazione.getCmd();
		return a;
	}

}
