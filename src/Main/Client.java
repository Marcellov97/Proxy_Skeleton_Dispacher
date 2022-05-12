package Main;
import Proxy.*;

public class Client {

	public static void main(String[] args) {
		
		Thread[] threads = new Thread[5];
		DispacherProxy proxy = new DispacherProxy();
		
		for(int i=0; i<5; i++) {
			threads[i] = new ThreadClient(proxy);
			threads[i].start();
		}
		
		for(int i=0; i<5; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

}
