package Server;

import Client.Client;

import java.io.*;
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
           // sendFileList(output);


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
    public void sendFileList(PrintWriter output) {
        File folder = new File("C:\\Users\\Click\\Desktop\\seventh\\Seventh-Assignment-Socket-Programming\\seventh_assignment\\src\\main\\java\\Server\\data");
        File[] filesList = folder.listFiles();
        StringBuilder fileList = new StringBuilder();
        if (filesList != null) {
            int i = 1;
            for (File file : filesList) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    fileList.append("(").append(i).append(") ").append(file.getName()).append("\n");
                    i++;
                }
            }
        }
        output.println(fileList.toString());
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