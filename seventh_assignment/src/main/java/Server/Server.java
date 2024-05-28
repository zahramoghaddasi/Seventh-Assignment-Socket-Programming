package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 3000;
    private static List<clientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(PORT);
            System.out.println("[SERVER] started. Waiting for client connections...");

            while (true) {
                Socket client = listener.accept();

                DataInputStream in = new DataInputStream(client.getInputStream());
                String username = in.readUTF();
                //System.out.println(username);
                System.out.println("[" + username + "]" + " connected to server.");

                clientHandler clientThread = new clientHandler(client, clients,username);
                clients.add(clientThread);

                pool.execute(clientThread);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (listener != null) {
                try {
                    listener.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            pool.shutdown();
        }
    }
}