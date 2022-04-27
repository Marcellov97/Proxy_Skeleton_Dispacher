package Interface;

public interface Dispacher {
	
	//Metodo per inviare un comando al dispacher
	public void sendCmd(int command);
	
	//Metodo per prelevare un comando dal Dispacher
	public int getCmd();

}
