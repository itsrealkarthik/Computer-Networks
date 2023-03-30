import java.io.*;
import java.math.BigInteger;
import java.net.*;

class crcserver {
    public static void main(String argv[]) throws Exception {
        try (ServerSocket welcomeSocket = new ServerSocket(6789)) {
            while (true) {
                String data, remainder;
                BigInteger data_num, remainder_num, new_remain;
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(
                        new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                data = inFromClient.readLine();
                remainder = inFromClient.readLine();
                data_num = new BigInteger(data);
                remainder_num = new BigInteger(remainder);
                new_remain = data_num.remainder(remainder_num);
                System.out.println("Input = "+ data);
                System.out.println("Remainder = "+ new_remain);
                int comparison = new_remain.compareTo(BigInteger.ZERO);
                if (comparison==0) {
                    System.out.println("Accepeted");
                } else {
                    System.out.println("Error");
                }
            }
        }
    }
}