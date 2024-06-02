package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class clientHandler implements Runnable {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ArrayList<Socket> clients;
    private Socket client;
    //private String username;
    private static List<String> messageHistory = new ArrayList<>();


    public clientHandler(Socket socket, ArrayList<Socket> clients ) throws IOException {
        this.socket = socket;
        this.clients = clients;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        // this.username = username;
    }

    @Override
    public void run() {
        try{
            String message;
            synchronized (messageHistory){
                for (String pastMessage : messageHistory) {
                    out.writeUTF(pastMessage);
                }
            }
            while (true) {
                message = this.in.readUTF();
                messageHistory.add(message);
                sendAll(message);
            }
        }catch (IOException ignored){
        }finally {
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public DataOutputStream getOut() {
        return out;
    }
    private void sendAll(String message) throws IOException {
        for(Socket client : clients){
            if(this.client != client) {
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(message);
            }
        }
    }
//    public static void printMessageHistory() {
//        //System.out.println("Message History for " + name + ":");
//        for (String message : messageHistory) {
//            System.out.println(message);
//        }
//    }
}