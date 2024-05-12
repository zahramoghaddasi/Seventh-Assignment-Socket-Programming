import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 8080);

            // TODO: Code for file upload or download

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}