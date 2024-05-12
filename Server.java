import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Listening on port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // TODO: Code for handling client requests and file transfer

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}