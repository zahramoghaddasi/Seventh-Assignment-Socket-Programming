# Seventh-Assignment-Socket-Programming

## Introduction
Welcome to your 7th assignment! This assignment focuses on building a CLI **client-server** structured application using **socket programming** in Java. The goal is to create a reliable and efficient mechanism for sending text messages between multiple clients and transferring text files from the server side to the client side.

## Assignment Overview
The server will be able to handle **2 main tasks**.

### Task 1: Sending Text Messages in a Group Chat
In this task, the server will handle requests from multiple clients to send text messages in a group chat. Each client will be able to read the body of the message and the name of the sender in their own terminal.

Additionally, it is recommended to implement mechanisms to handle errors and ensure reliable message delivery.

#### Client Code Sample
```java
public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            // Input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Task 1: Sending Text Messages in a Group Chat
            // Implement the logic to send and receive text messages here

            // Task 2: Downloading Text Files from the Server
            // Implement the logic to download text files here

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Task 2: Downloading Text Files from the Server
In this task, you will extend the functionality of the application to allow clients to download text files from the server.

Ensure that the client is able to first see the list of available files and then select one to download.

Once the file is downloaded, the name and contents of the file will be displayed on the client side.

#### Server Code Sample
```java
public class Server {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                // Input and output streams
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Task 1: Sending Text Messages in a Group Chat
                // Implement the logic to handle text messages from clients here

                // Task 2: Downloading Text Files from the Server
                // Implement the logic to send text files to clients here

                // Close the socket
                socket.close();
                System.out.println("Client disconnected: " + socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Getting Started
To begin working on the assignment, follow these steps:

0. Fork this repository. (**DO NOT clone it! Fork it first**)

1. Clone the forked repo from your own GitHub account to your local machine.

2. The forked repo contains the readme file and several text files, each storing the lyrics of a song.

3. Implement the client-side and server-side code as per the assignment requirements. Refer to the provided comments and any additional guidelines mentioned in the code.

## Some Bonus Features You Might Want to Work On!

- User Interface: You may choose to add a graphical user interface (GUI) to enhance the user experience. Java's Swing or JavaFX libraries can be used for this purpose.

- Progress Tracking: Provide a way to track the progress of file transfers, allowing clients to monitor the download progress. (Considering the fact that you know how to use JavaFX, implementing this part with JavaFX is welcomed!)

- Server Log: Implement a server log feature to record important events and actions on the server-side for debugging and monitoring purposes.

- Although writing documentation for this assignment is not necessary (and won't earn extra points), writing one will help the mentors understand how you have worked throughout the project. Additionally, it will make your code more comprehensible for others if you plan to keep this assignment on your GitHub account.

## Submission
When you have completed the assignment, please prepare your submission as follows:

1. Include all the relevant Java source code files for the client and server components, in addition to the text files.

2. (Optional) Provide any additional documentation or notes that explain your implementation details, design choices, and testing approach.

3. (Optional) If you implemented a GUI, include any necessary resources or instructions for running the GUI successfully.

4. Push your final code to the forked repo and send a PR (Pull Request) to your mentor. The deadline for submission is **May 22nd (Khordad 2nd)**.

## Troubleshooting
If you encounter any issues or have questions regarding the assignment, please reach out to your mentors for assistance.

Best regards :)