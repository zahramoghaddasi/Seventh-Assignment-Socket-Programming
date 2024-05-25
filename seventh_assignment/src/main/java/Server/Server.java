package Server;

import Client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// Server Class
public class Server{

    private ServerSocket serverSocket;
    private static List<PrintWriter> clientOutputs = new ArrayList<>();

    public Server(int port){
        try {
          serverSocket = new ServerSocket(port);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleClient(Socket clientsocket){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientsocket.getOutputStream(), true);
            clientOutputs.add(output);
            String clientId = Client.getClientId();

            System.out.println("Client [" + clientId + "] connected.");
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("[" + clientId + "] : " + message);
                for (PrintWriter clientOutput : clientOutputs) {
                    clientOutput.println(message);
                }

            }

            System.out.println("Client [" + clientId + "] disconnected.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("Server started. Listening for incoming connections...");

            try {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    Thread clientThread = new Thread(() -> handleClient(clientSocket));
                    clientThread.start();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        // TODO: Implement the main method to start the server
        Server server = new Server(3000);
        server.start();
    }
}