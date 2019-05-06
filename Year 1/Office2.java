// Comp104 - First Assignment: Letters
// March 2013
// By: Fumiko Saito

public class Office {
	
	static public final int MAXIMUM = 5;	
	static public final int MINIMUM = 0;
	static public int numberFinished = 0;		// number of secretaries finished
	
	static public Buffer tray = new Buffer();	// creating the tray for the letters
	
	public static void main(String[] args){
			
	Secretary SecretaryA = new Secretary(1000, "Secretary A");	// creating the threads
	Secretary SecretaryB = new Secretary(2000, "Secretary B");	// sleep time for each thread
	Secretary SecretaryC = new Secretary(4000, "Secretary C");
	Manager TheManager = new Manager();
	
	SecretaryA.start();	// starting the threads
	SecretaryB.start();
	SecretaryC.start();
	TheManager.start();
	
	}
}

class Secretary extends Thread {	// class representing the secretaries
		
	int sleepTime = 0;
	String name = "i";
	public Secretary(int time, String _name){sleepTime = time;
	name = _name;}
	
	public void run() {		// run method to be used for threads
	try {
		for (int i = 1; i < 8; i++){	// each thread goes through this method 7 times
			sleep(sleepTime);	// makes the thread sleep for the specified time
			
	System.out.println(name + " has typed up letter # " + i);		
	Office.tray.insert();		

		}
	} catch (Exception e){}  	// try catch for the sleep method
	Office.numberFinished++;	// secretary threads are finished here
}}

class Buffer {				// setting up the tray class
	private int NumberIn = 0;			// attributes
	private boolean full = (NumberIn == 5); 
	private boolean empty = (NumberIn == 0);
	
	public synchronized void insert() { while (full) {	// while the tray's full wait till space is available
		try { wait();	
		}
		catch (InterruptedException e) {} }	
		NumberIn++; 				// add a letter to the tray
		full = (NumberIn == 5); 	
		empty = false;
		notify();
		System.out.println("tray contains " + NumberIn);
	}

	public synchronized void remove(){		// while the tray's empty wait until a letter is added
		while (empty) {
			try { wait();
			}
		catch (InterruptedException e) {}
	}
	NumberIn--; 					// remove a letter from the tray
	empty = (NumberIn == 0);
	full = false;
	notify();
	System.out.println("tray contains " + NumberIn);
	}

	public synchronized boolean isempty(){		// returns if the tray is empty
	return empty;
	}
}

class Manager extends Thread {				// for the manager thread
	
	public void run() {	
		while(Office.numberFinished < 3) {	// manager can only sign a letter if there are letters in the box
		while(!Office.tray.isempty()){
			Office.tray.remove();
			try {
				sleep(2000);		// takes the manager 2 seconds to sign a letter
			} catch (Exception e){}
			System.out.println("The manager has signed a letter");
		}
	}
}
}
	
