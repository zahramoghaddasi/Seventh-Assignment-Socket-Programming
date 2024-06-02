package Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class fileHandler implements Runnable{
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    public fileHandler(Socket client) throws IOException {
        this.client = client;
        this.in = new DataInputStream(client.getInputStream());
        this.out = new DataOutputStream(client.getOutputStream());
    }
    @Override
    public void run() {
        try {

            File fIle = new File("C:\\Users\\Click\\Desktop\\seventh\\Seventh-Assignment-Socket-Programming\\seventh_assignment\\src\\main\\java\\Server\\data");
            File[] filesList = fIle.listFiles();
            String list = "";
            if(filesList != null){
                int i = 1;
                for (File file : filesList) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        list = list + i + ". " + file.getName() + "\n";
                        i++;
                    }
                }
            }
            out.writeUTF(list);
            String request =in.readUTF();
            int req = Integer.parseInt(request) - 1;
            assert filesList != null;
            File chosenFile = filesList[req];
            File targetFile = new File("C:\\Users\\Click\\Desktop\\seventh\\Seventh-Assignment-Socket-Programming\\seventh_assignment\\src\\main\\java\\Client" + chosenFile.getName());
            String data = "";
            Scanner reader = new Scanner(chosenFile);
            while (reader.hasNextLine()){
                data  = data + reader.nextLine();
            }
            FileWriter writer = new FileWriter(targetFile);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
