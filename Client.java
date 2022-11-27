import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String arg[]) throws IOException {
        Scanner scan = new Scanner(System.in);

        try {
            Socket s=new Socket("127.0.0.1", 3000);

            System.out.println("Connected");

            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            System.out.println("Enter a number: ");
            int inputNumber = scan.nextInt();

            output.writeInt(inputNumber);
            String reply = (String) input.readUTF();
            System.out.println("\nNumber " +inputNumber + "... Is this a prime number? " + reply);

            output.flush();
            output.close();
            s.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
