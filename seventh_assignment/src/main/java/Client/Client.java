package Client;

import Server.clientHandler;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 3000;
    private static List<clientHandler> clients;

    public static void main(String[] args) {
        try {
            Socket client = new Socket(SERVER_IP, SERVER_PORT);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String username = reader.readLine();
            out.writeUTF(username);
            System.out.println("Client  [" + username + "]" + " Started .");

            serverHandler handleServerResponse = new serverHandler(client, username);
            new Thread(handleServerResponse).start();
            // clientHandler clientHandler = new clientHandler(client, clients,username );

            Scanner scanner = new Scanner(System.in);
            String userInput;
            boolean inChat = false;

            while (true) {
                if (!inChat) {
                    System.out.println("Select an option:");
                    System.out.println("1. Enter the chat group");
                    System.out.println("2. Download a file from the server");
                    System.out.print("Enter your choice: ");
                    userInput = scanner.nextLine();
                    // out.writeUTF(userInput);

                    if (userInput.equals("1")) {
                        System.out.println("Now you join the chat group.if you want back to menu enter /menu.");
                        inChat = true;
                        handleServerResponse.printMessageHistory();
                        //clientHandler.printMessageHistory();

                    }
                    else if (userInput.equals("/menu")) {
                        System.out.println("Returning to main menu...");
                        inChat = false;
                    }
                }
                else {
                    userInput = reader.readLine();
                    if (userInput.equals("/menu")) {
                        // out.writeUTF(userInput);
                        inChat = false;
                        System.out.println("Returning to main menu...");
                    } else {
                        out.writeUTF(userInput);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}