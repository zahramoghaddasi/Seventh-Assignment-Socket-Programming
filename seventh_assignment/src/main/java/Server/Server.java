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
    //private Server server;
    private static List<PrintWriter> clientOutputs = new ArrayList<>();
    private static List<String> chatHistory = new ArrayList<>();

    // private boolean sendmessagetoClient = true;
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
            String clientId = input.readLine();
            System.out.println("Client [" + clientId + "] connected.");

            for (String message : chatHistory) {
                output.println(message);
            }

            String joinMessage = "Client [" + clientId + "] joined the chat.";
            chatHistory.add(joinMessage);
//            for(PrintWriter clientOutput : clientOutputs){
//                clientOutput.println(joinMessage);
//            }

            String message;
            while ((message = input.readLine()) != null) {
                chatHistory.add(message);
                for(PrintWriter clientOutput : clientOutputs){
                    if (clientOutput != output){
                        clientOutput.println(message);
                    }
                }
                output.println(message);
            }

            System.out.println("Client [" + clientId + "] disconnected.");
            clientOutputs.remove(output);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void broadcastMessage(String message){
//        for (PrintWriter clientOutput : clientOutputs) {
//            clientOutput.println(message);
//        }
//    }
//    public void sendServerMessage(String message) {
//        //System.out.println("Server sending message: " + message);
//        broadcastMessage("SERVER: " + message); // Sending a message from the server to all clients
//    }

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
    public

    public static void main(String[] args) {
        // TODO: Implement the main method to start the server
        Server server = new Server(3000);
        server.start();


    }
}