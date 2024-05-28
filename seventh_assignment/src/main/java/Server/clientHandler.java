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
    private List<clientHandler> clients;
    private String username;
    //private static List<String> messageHistory = new ArrayList<>();


    public clientHandler(Socket socket, List<clientHandler> clients , String username) throws IOException {
        this.socket = socket;
        this.clients = clients;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.username = username;
    }

    @Override
    public void run() {
        try {
            String message;
            while (true) {
                message = in.readUTF();
                //messageHistory.add(message);
                sendAll("[" + username + "] :" + message);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataOutputStream getOut() {
        return out;
    }
    private void sendAll(String message) throws IOException {
        for (clientHandler client : clients) {
            DataOutputStream clientOut = client.getOut();
            clientOut.writeUTF(message);
        }
    }
//    public static void printMessageHistory() {
//        //System.out.println("Message History for " + name + ":");
//        for (String message : messageHistory) {
//            System.out.println(message);
//        }
//    }
}