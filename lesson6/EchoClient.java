package geekbrains.jmaxim1906.Java2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 8089;

        try (Socket clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {

            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            while (true) {
                String read = scanner.nextLine();
                dataOutputStream.writeUTF(read);
                String fromServer = dataInputStream.readUTF();
                System.out.println(fromServer);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
