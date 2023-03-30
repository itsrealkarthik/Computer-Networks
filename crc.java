import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;

class CRC {
    public static void main(String argv[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        BigInteger input_num, remainder_num, divisor_num, s_num;
        String input, polynomial, output,remainder="",s="";
        Socket clientSocket = new Socket("localhost", 6789);
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        input = inFromUser.readLine();
        polynomial = scan.nextLine();
        String divisor = "";
        String extra="";
        int nums = polynomial.charAt(0);
        int first= nums-48;
        for (int i = first; i >= 0; i--) {
            String num = String.valueOf(i);
            if (polynomial.contains(num)) {
                divisor = divisor + "1";
            } else {
                divisor = divisor + "0";
            }
        }
        for(int i=0;i<first;i++){
            extra=extra+"0";
        }
        input=input+extra;
        input_num= new BigInteger(input);
        divisor_num=new BigInteger(divisor);
        remainder_num=input_num.remainder(divisor_num);
        remainder=String.valueOf(remainder_num);
        for (int i = 0; i < remainder.length(); i++) {
            s=s+(remainder.charAt(i)^divisor.charAt(i));
        }
        s_num= new BigInteger(s);
        remainder_num=s_num;
        input_num=input_num.add(s_num);
        input=String.valueOf(input_num);
        outToServer.writeBytes(input + '\n');
        outToServer.writeBytes(divisor + '\n');
        clientSocket.close();
    }
}