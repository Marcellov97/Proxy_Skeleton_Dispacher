package Main;
import java.util.*;
import Proxy.DispacherProxy;

public class ThreadClient extends Thread {
	
	private DispacherProxy proxy;
	
	public ThreadClient(DispacherProxy proxy) {
		this.proxy = proxy;
	}
	
	public void run() {
		
		for(int i=0; i<3; i++) {
			Random rand = new Random();
			int value = 2 + rand.nextInt(3);
			value = value * 100;
			int command = rand.nextInt(4);
			long mills = (long)  value;
			
			try {
				sleep(mills);
				System.out.println("[INVIO n." + i + "] Invio il comando n." + command);
				proxy.sendCmd(command);
				System.out.println("Ho inviato il comando.");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
