package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class serverHandler implements Runnable {
    private DataInputStream in;
    private String name;
    public serverHandler(Socket client , ArrayList<String> msg) throws IOException{
        this.in = new DataInputStream(client.getInputStream());
        this.name = name;
    }
    @Override
    public void run() {
        try{
            while (true){
                System.out.println(this.in.readUTF());
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}