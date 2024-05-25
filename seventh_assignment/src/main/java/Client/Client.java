package Client;// Client Class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
   private BufferedReader input;
   private PrintWriter output;
   private static String clientId;

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

                System.out.println("[" + clientId + "] :" + message);
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
                message = userInput.readLine();
                output.println(message); // Send the message to the server
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void start(){
       System.out.println("Client [" + clientId + "] Started.");

       Thread inputThread = new Thread(this::handleInput);
       inputThread.start();

       Thread outputThread = new Thread(this::handleOutput);
       outputThread.start();
   }


   public static String getClientId(){
       return clientId;
   }

    public static void main(String[] args) {
        // TODO: Implement the main method to start the client
        Client client = new Client("127.0.0.1",3000 , "zahra");
        client.start();
    }
}