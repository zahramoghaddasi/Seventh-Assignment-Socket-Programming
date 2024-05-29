package Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 3000;

    public static void main(String[] args) {
        try {
//            Socket client = new Socket(SERVER_IP, SERVER_PORT);
//            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String username = reader.readLine();
            System.out.println("Client [" + username + "] Started.");
//            out.writeUTF(username);

            boolean inChat = false;
            while (true){
                // if(!inChat){
                System.out.println("Select an option:");
                System.out.println("1. Enter the chat group");
                System.out.println("2. Download a file from the server");
                System.out.print("Enter your choice: ");

                String choice = reader.readLine();


                if (choice.equals("1")) {
                    System.out.println("You have joined the chat group. To return to the menu, enter /menu.");
                    inChat = true;
                    chat(username,reader);
                    continue;

                }
                else if (choice.equals("2")) {
                    downloadFile(username,reader);
                }
                else {
                    System.out.println("Invalid Choice");
                    continue;
                }
                // }
//                else {
//                    String userInput = reader.readLine();
//                    if (userInput.equals("/menu")) {
//                        inChat = false;
//                        System.out.println("Returning to main menu...");
//                        break;
//                    }
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadFile(String user,BufferedReader reader) throws IOException {
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket(SERVER_IP, SERVER_PORT);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeUTF("2");
        out.writeUTF("[" + user + "] Connected to Downlod server ");


        serverHandler serverHandle = new serverHandler(client, new ArrayList<>());
        new Thread(serverHandle).start();

        String userInput = reader.readLine();
        out.writeUTF(userInput);
        while (true) {
            userInput = reader.readLine();
            if (userInput.equals("/menu")) {
                System.out.println("Returning to main menu...");
                break;
            }
        }

    }

    public static void chat(String name , BufferedReader reader) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Socket client = new Socket(SERVER_IP , SERVER_PORT);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeUTF("1");

        out.writeUTF( "[" + name + "] Connected to Chat server ");
        //  System.out.println("[" + name + "] Join chat");

        serverHandler serverHandle = new serverHandler(client, new ArrayList<>());
        new Thread(serverHandle).start();
        String userInput;

        while (true) {
            userInput = reader.readLine();
            if (userInput.equals("/menu")) {
                System.out.println("Returning to main menu...");
                break;
            }
            out.writeUTF("[" + name + "]: " + userInput);
        }
    }
}