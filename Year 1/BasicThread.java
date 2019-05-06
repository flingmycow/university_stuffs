import java.lang.*; 
import java.io.*; 
/* 
** Starts two threads which print messages asynchronously. 
*/ 
public class BasicThread 
{ 
   public static void main( String args[] ) throws IOException,InterruptedException 
   { 
      CountThread countThread1 = new CountThread( "Thread 1" ); 
      CountThread countThread2 = new CountThread( "Thread 2" ); 

      System.out.println( "Starting Threads" ); 
      countThread1.start();   // Starts thread and calls run method 
      countThread2.start();   // Starts thread and calls run method 
      System.out.println( "Threads Started" ); 

      countThread1.join();    // Wait for thread to end. 
      countThread2.join();    // Wait for thread to end. 
      System.out.println( "Threads Stopped" ); 

      System.out.println( "Press <enter> to quit." ); 
      System.in.read();       // Wait for user to press enter       
   } 
} 

