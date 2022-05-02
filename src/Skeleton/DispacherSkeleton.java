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
