class NewThread implements Runnable {  
  String name; // name of thread  
  Thread t;  
  
  NewThread(String threadname) {  
    name = threadname;  
    t = new Thread(this, name);  
    System.out.println("New thread: " + t);  
    t.start(); // Start the thread  
  }  
  
  // This is the entry point for thread.  
  public void run() {  
    try {  
      for(int i = 1; i < 8; i++) {  
        System.out.println(name + ": " + i);  
        Thread.sleep(1000);  
      }  
    } catch (InterruptedException e) {  
      System.out.println(name + "Interrupted");  
    }  
    System.out.println(name + " exiting.");  
  }  
}  
  
class MultiThreadDemo {  
  public static void main(String args[]) {  
    new NewThread("SecretaryA"); // start threads  
    new NewThread("SecretaryB");  
    new NewThread("SecretaryC");  
  
    try {  
      // wait for other threads to end  
      Thread.sleep(5000);  
    } catch (InterruptedException e) {  
      System.out.println("Main thread Interrupted");  
    }  
  
    System.out.println("Main thread exiting.");  
  }  
}  
