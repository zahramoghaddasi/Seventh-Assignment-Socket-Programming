package Client;// Client Class

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private static String clientId;
    private boolean inChatGroup = false;
    private List<String> chatHistory = new ArrayList<>();
    private boolean firstTime = true;


    public Client(String Ip , int port , String clientId){

        this.clientId = clientId;

        try {
            socket = new Socket( Ip , port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream() , true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleInput(){
        try {
            String message;
            while (true){
                message = input.readLine();
                if(message == null){
                    break;
                }
                //if (inChatGroup) {
//                    chatHistory.add(message);
//                    System.out.println(message);
//                //}
                if (!inChatGroup && firstTime) {
                    chatHistory.add(message);
                    //System.out.println(message);
                } else if (inChatGroup) {
                    chatHistory.add(message);
                    System.out.println(message);
                    firstTime = false;
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleOutput() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            String message;
            while (true) {
                if (!inChatGroup) {
                    System.out.println("1. Enter chat group");
                    System.out.println("2. Download file");
                    System.out.print("Enter your choice: ");
                    String choice = userInput.readLine();
                    if ("1".equals(choice)) {
                        inChatGroup = true;
                        System.out.println("You are now in the chat group. Type /menu to exit.");
                        for (String sentMessage : chatHistory) {
                            System.out.println(sentMessage);
                        }
                    } else if ("2".equals(choice)) {
                        // Implement file download logic



                    }
                } else {
                    message = userInput.readLine();
                    if (message != null) {
                        if ("/menu".equals(message)) {
                            inChatGroup = false;
                            System.out.println("Exited chat group.");
                        } else {
                            output.println("[" + clientId + "] : " + message);
                           // chatHistory.add("[" + clientId + "] : " + message);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void downloadFile(int fileIndex) {
        try {
            output.println(String.valueOf(fileIndex));
            String fileName = input.readLine();
            File receivedFile = new File("C:\\Users\\Click\\Desktop\\seventh\\Seventh-Assignment-Socket-Programming\\seventh_assignment\\src\\main\\java\\Client" + fileName);
            PrintWriter fileWriter = new PrintWriter(new FileWriter(receivedFile));

            String data;
            while ((data = input.readLine()) != null) {
                fileWriter.println(data);
                if (data.equals("END_OF_FILE")) {
                    break;
                }
            }

            fileWriter.close();
            System.out.println("File downloaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start(){
        System.out.println("Client [" + clientId + "] Started.");
        output.println(clientId);

        Thread inputThread = new Thread(this::handleInput);
        inputThread.start();

        Thread outputThread = new Thread(this::handleOutput);
        outputThread.start();
    }
//   public static String getClientId(){
//       return clientId;
//   }

    public static void main(String[] args) {
        // TODO: Implement the main method to start the client
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Client client = new Client("127.0.0.1",3000 , name);
        client.start();
    }
}