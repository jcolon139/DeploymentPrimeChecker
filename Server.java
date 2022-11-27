import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {
    public static String primeChecker(int n) {
        if(n < 2) {
            return "No";
        }

        int i = 2;
        while(i < n) {
            if(n % i == 0) {
                return "No";
            }
            i++;
        }
        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("Connected");

            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            int number = (int) input.readInt();

            output.writeUTF(primeChecker(number));
            output.flush();

            output.close();
            s.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}