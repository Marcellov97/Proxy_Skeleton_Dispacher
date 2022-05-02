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
		// TODO metodo runSkeleton
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
			// TODO continuare metodo
		}
		catch(Exception ex) {
			ex.getStackTrace();
		}
	}
	

	@Override
	public void sendCmd(int command) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCmd() {
		// TODO Auto-generated method stub
		return 0;
	}

}
