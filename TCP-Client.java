import java.io.*;
import java.net.*;
import java.time.*;
class Client{
    public static void main(String argv[]) throws Exception{
        String timeread, sentence;
        Socket clientSocket=new Socket("localhost",6789);
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
        sentence = inFromUser.readLine(); 
        outToServer.writeBytes(sentence + '\n'); 
        timeread = inFromServer.readLine(); 
        System.out.println("FROM SERVER: " + timeread); 
        clientSocket.close();
    }
}