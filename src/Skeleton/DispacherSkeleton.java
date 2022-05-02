package Skeleton;

import java.net.*;
import Interface.Dispacher;

public class DispacherSkeleton implements Dispacher {
	
	private DatagramSocket socket;
	private Dispacher implementazione;
	
	public DispacherSkeleton() {
		try {
			socket = new DatagramSocket(9000);
		}
		catch(SocketException ex) {
			ex.getStackTrace();
		}
	}
	
	public void runSkeleton() {
		implementazione = new DispacherImpl();
		
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
			if(info[0] == "sendCmd") {
				int command = Integer.parseInt(info[1]);
				this.sendCmd(command);
			}
			else {
				if(info[0] == "getCmd") {
					this.getCmd();
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
		implementazione.getCmd();
		return 0;
	}

}
