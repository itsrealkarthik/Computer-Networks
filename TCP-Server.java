import java.io.*; 
import java.net.*; 
import java.time.*;
class TCPServer { 
  public static void main(String argv[]) throws Exception {  
      try (ServerSocket welcomeSocket = new ServerSocket(6789)) {
        while(true) { 
          String clientSentence;
          Socket connectionSocket = welcomeSocket.accept(); 
          BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
          DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
          clientSentence = inFromClient.readLine();
          LocalDateTime currenttime=LocalDateTime.now(); 
          String s = clientSentence.toUpperCase() + " " + currenttime.toString() + "\n"; 
          outToClient.writeBytes(s); 
        }
    }
    }
}