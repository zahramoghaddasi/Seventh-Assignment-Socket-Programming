package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class serverHandler implements Runnable {
    private DataInputStream in;
    private String name;
    private List<String> messageHistory = new ArrayList<>();
    public serverHandler(Socket client , String name) throws IOException {
        this.in = new DataInputStream(client.getInputStream());
        this.name = name;
    }
    @Override
    public void run() {
        try{
            while (true) {
                String message = in.readUTF();
                messageHistory.add(message);
                System.out.println( message);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void printMessageHistory() {
        //System.out.println("Message History for " + name + ":");
        for (String message : messageHistory) {
            System.out.println(message);
        }
    }

}