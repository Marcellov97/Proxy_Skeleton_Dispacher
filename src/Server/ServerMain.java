package Server;

import Skeleton.*;

public class ServerMain {

	public static void main(String[] args) {
		
		System.out.println("Sto avviando il Server...");
		DispacherSkeleton disp = new DispacherSkeleton();
		
		disp.runSkeleton();
		
	}

}
