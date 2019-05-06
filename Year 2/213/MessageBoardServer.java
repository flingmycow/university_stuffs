// COMP213 - ASSIGNMENT #2 JAVA SERVER BOARD
// By: Fumiko Saito Username: U2FS
// Student ID: 200784765
// NOTE: This java code is incomplete. 

import java.io.*;
import java.net.*;

public class MessageBoardServer
{
   // port number for the server
   private static final int PORT_NUM = 12086;

   // the server socket:
   private static ServerSocket ss;

   // set when shutDown() is called to stop the server:
   private static boolean shutDownCalled = false;

   // shut the server down by closing the server socket
   public static void shutDown()
   {
      // flag that the server socket has been closed
      shutDownCalled = true;

      try 
      {
         ss.close();
      }
      catch (Exception e)
      {
         // something went wrong; give data:
         System.err.println("problem shutting down:");
         System.err.println(e.getMessage());
         // and trust the JVM to clean up:
         System.exit(1);
      }
   }

   public static void main(String[] args ) 
   {
      // for client connections
      Socket incoming;

      // session-handling thread
      Thread thread;

      try 
      {
         // set up server socket
         ss = new ServerSocket(12086);

         while (true)
         {
            incoming = ss.accept();

            // start session-handler in new thread
            thread = new Thread(new ClientServer(incoming));
            thread.start();
         }
      }
      catch (SocketException se)
      {

         if (! shutDownCalled)
         {
            System.err.println("socket problem:");
            System.err.println(se.getMessage());
            // trust the JVM to clean up
            System.exit(1);
         }
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error:");
         System.err.println(ioe.getMessage());
         System.exit(1);
      }
      finally
      {
         if (ss != null)
         {
            try 
            {
               ss.close();
            }
            catch (Exception e)
            {
               System.err.println("closing: " + e.getMessage());
            }
         }
      }
      
      // Tests for the MessageBoard Server
      // 
      // Test for getTopic (IE. Post all messages in topic that corresponds to ID)
      Socket clientSocket = new Socket("localhost", 12086);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      
      // use out.println as it uses the PrintWriter
      
      out.println("3");
      out.println("Wallpaper");
      out.println("Oskar Wild");
      out.println("1Hello, Message Board!\n1Either that wallpaper goes\nor I do.");
      out.println(".");
      out.flush();
      clientSocket.close();
      
      clientSocket = new Socket("localhost", 12086);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      out.println("1\\n0"); // request all msgs in topic with ID 0
      
      String line;
      while ((line = in.readLine()) != null) 
      {
      	      System.out.println(line);
      }
      
      clientSocket.close();
      
      // Test for getTopicIDS (IE. get a list of all the topics when the user sends 0)
      clientSocket = new Socket("localhost", 12086);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      
      out.println("4");
      out.println("Weather");
      out.println("2");
      out.println("Testing");
      out.println("1");
      out.println("Where is everyone?");
      out.println("5");
      out.println("Wallpaper");
      out.println("3");
      out.println("Weather in Java");
      out.flush();
      clientSocket.close();
      
      clientSocket = new Socket("localhost", 12086);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      out.println("0\\n")
      
      String line2;
      while ((line2 = in.readLine()) != null)
      {
      	      System.out.println(line2);
      }
      clientSocket.close();
      	      
      // Test for addNewTopic
      clientSocket = new Socket("localhost", 12086);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      
      // 2\n27\nBegbie\n1I thought the art of conversation was dead\n1\n1\n1and I was right!\n.\n"
      
      out.println("27");
      out.println("Begbie");
      out.println("I thought the art of conversation was dead");
      out.println("\n");
      out.println("\n");
      out.println("and I was right!");
      out.println(".");
      out.flush();
      clientSocket.close();
      
      clientSocket = new Socket("localhost", 12086);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
      out.println("2\\n");
      
      String line3;
      while ((line3 = in.readLine()) != null)
      {
      	      System.out.println(line3);
      }
      clientSocket.close();
      
   }
}


/*
 *  Session-handler class to handle one remote client
 *  in a separate thread.
 */	
class ClientServer implements Runnable
{
	
   // the connection to the remote client
   private Socket clientSocket;

   ClientServer(Socket s)
   {
      clientSocket = s;
   }

   /*
    *  Handle session for one remote client:
    *  set up I/O, then repeat all input till
    *  client sends "BYE"
    */
   public void run()
   {
      // for I/O
      BufferedReader in = null;
      PrintWriter out = null;

      try 
      {
         // set up I/O
         in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

         // prompt client
         out.println("Please enter a command");
         out.flush();

         // for client input
        int topicID;
	int numOfTopics;
	String posterName;
	String msgText;
	String topicTitle;
	String clientInput;
        boolean done = false;
        
         while (!done)
         {
            clientInput = in.readLine();
 
            if ((clientInput == null)
                || (clientInput.trim().equals("That is not valid")))
            {
               // quit
               done = true;
            }
            
            // the client wants a list of topics
            else if (clientInput.trim().equals("0\\n"))
            {
            	    for (int i = numOfTopics; i < numOfTopics + 1; i++)
            	    {
            	    	    out.println(topicID + "\\n" + topicTitle + "\\n");
            	    }
            }
            
            // the client wants all the messages associated with a topic ID
            else if (clientInput.trim().equals("1"))
            {
            	    out.println("Enter the topic ID");
            	    clientInput = in.readLine();
            	    
            	    int integer = Integer.parseInt(clientInput); // need to convert string to int
            	    
            	    if (clientInput == topicID){
            	    for (int index = 0; index < msgText.length; index++)
            	    out.println(posterName + "\n1" + msgText + ".\n.");
            	    }
            	    
            	    else {               
            	    	     clientSocket.close(); // shut down server as there's no topic that matches ID
            	    	    return;
            	    }
            }
            
            // the client wants to add message(s) to a specific topic
            else if (clientInput.trim().equals("2"))
            {
            	    clientInput = in.readLine();
            	    	    
            	    	    if (clientInput.contains("\\n"))
            	    	    {
            	    	    	    String delimiter = "\\n";
            	    	    	    String[] array;
            	    	    	    array = clientInput(delimiter);
            	    	    	    
            	    	    	    for (int i = 0; i < array.length; i++)
            	    	    	    System.out.println(array[i]);
            	    	    
            	    	    	    out.println("2\\n");
            	    	    	    clientSocket.close(); // close connection 
            	    	    	    return;    
            	    	    }
            	    	    
            	    	    else if (clientInput.contains(a-zA-Z))
            	    	    {
            	    	    	    out.println("6\\n");
            	    	    	    clientSocket.close(); // close connection as client sent incorrectly formatted information
            	    	    	    return;
            	    	    }
            	    	    
            	    	    else 
            	    	    {
            	    	    	    out.println("5\\n");
            	    	    	    clientSocket.close(); // close connection as client sent an ID that doesn't match any topics
            	    	    	    return;
            	    	    }          	             	    
            }
            
            // the client wants to create a new topic
            else if (clientInput.trim().equals("3"))
            {
            	    clientInput = in.readLine();
            	    String[] parts = string.split("\\n");
            	    
            	    
            	    if
            	    {
            	    	    
            	    }
            	    
            	    else
            	    {
            	    	    out.println("6\\n");
            	    	    clientSocket.close(); // close connection as client sent incorrectly formatted information
            	    	    return;    
            	    }
            	    
            }
            
            else
            {
            	    out.println("That is incorrect, goodbye.");
            	    clientSocket.close(); // close connection as client sent incorrect command
            	    return; 
            }
         }
      }
      
      catch (IOException e)
      {
         // error for this session
         System.err.println(e.getMessage());
      }
      finally
      {  // close connections
         try 
         {
            in.close();
         }
         catch(IOException e)
         {
         }
         if (out != null)
         {
            out.close();
         }
         if (clientSocket != null)
         {
            try 
            {
               clientSocket.close();
            }
            catch (IOException e)
            {
            }
         }
      }
   }

}	


	
	
