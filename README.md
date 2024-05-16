# Socket Programming Assignment - Group Chat and File Transfer

## Introduction
Welcome to your 7th assignment! This assignment focuses on building a command-line interface (CLI) **client-server** application using **socket programming** in Java. The objective is to create a robust and efficient mechanism for sending text messages between multiple clients and transferring text files from the server side to the client side.

## Assignment Overview
The assignment comprises two main tasks that the server needs to handle.

### Task 1: Group Chat - Sending Text Messages
In this task, the server will handle requests from multiple clients to send text messages in a group chat. Each client will be able to read the message content and the name of the sender in their own terminal. (Make sure that you are using sockets to transfer these massages between the clients and the server)

### Task 2: File Transfer - Downloading Text Files
In this task, you will extend the functionality of the application to allow clients to download text files from the server.

Thus the client should be able to view a list of the available files on the server and select one for download. Once the file is downloaded, it shall be **copied** (**NOT cut**) to a directory related specifically to the client who sent the request to download the file. (In other words, the file shall be saved somewhere on the client side)

It's worth mentioning that this procedure must take place using a socket connection between the server and the client. Therefore, it would be beneficial to delve into the topic and explore how you can accomplish this.

## Project Breakdown
Here is a suggested structure for your code:

1. `Server` Class: This class will handle the server-side operations. It will be responsible for accepting incoming client connections, managing file downloads, and facilitating group chat functionality.
    - `Server.java`: This class will create a ServerSocket and listen for incoming client connections. It will spawn a new thread for each connected client to handle their requests concurrently.

2. `ServerLogHandler` Class: This class will handle logging operations on the server side. It will be responsible for creating, writing, and managing the server log file.

    - `ServerLogHandler.java`: This class will provide methods to log server events, such as client connections, file downloads, and chat messages.

3. `Client` Class: This class will handle the client-side operations. It will connect to the server, interact with the user for file downloads or group chat, and send/receive messages to/from the server.
    - `Client.java`: This class will represent a client and handle the interaction with the server. It will establish a socket connection with the server and send/receive messages.

4. `FileHandler` Class: This class will handle file-related operations, such as downloading files from the server to the client.
    - `FileHandler.java`: This class will provide methods to download files from the server and save them on the client's machine.

5. `ChatHandler` Class: This class will handle the group chat functionality. It will receive messages from clients and broadcast them to all connected clients.
    - `ChatHandler.java`: This class will manage the group chat functionality, including sending/receiving messages between clients and broadcasting messages to connected clients.

To implement this structure, you can use Java's Socket and ServerSocket classes for establishing connections between the server and clients. You can also use InputStream and OutputStream to send/receive data between the server and clients.

When a client connects to the server, the server can prompt the client to choose between file download or group chat options. Based on the client's choice, the server will delegate the request to the appropriate handler (i.e., FileHandler or ChatHandler).

For file downloads, the server can provide a list of available files, and once the client selects a file, the server will use the FileHandler to send the file to the client.

For group chat, the server will use the ChatHandler to facilitate communication between connected clients. The ChatHandler will receive messages from clients and broadcast them to all connected clients.

**Note that the structure above is only a suggestion and you can implement any other structure you prefer. But make sure that the connection between the server and the clients are made possible through using sockets and a server log feature is implemented as well.**


## Getting Started
To begin working on the assignment, follow these steps:

1. Fork this repository. (**DO NOT clone it! Fork it first**)

2. Clone the forked repository from your own GitHub account to your local machine.

3. The repository contains a README file and several text files (in the `data` directory), each storing the lyrics of a song.

4. Implement the client-side and server-side code as per the assignment requirements. Refer to the provided code comments and any additional guidelines mentioned in the code.

## Bonus Features
Consider implementing the following bonus features to enhance your application:

- User Interface: Add a graphical user interface (GUI) using Java's Swing or JavaFX libraries to improve the user experience.

- Progress Tracking: Provide a way for clients to monitor the progress of file transfers, allowing them to track the download progress. If you are familiar with JavaFX, consider implementing this with JavaFX.

- Although writing a documentation for this assignment is not mandatory (and won't earn extra points), it will help mentors understand your project's progress. Additionally, it will make your code more comprehensible for others if you decide to keep this assignment on your GitHub account.

**Of course implementing any other features are welcomed! The limit is your imagination.**

## Submission
When you have completed the assignment, please prepare your submission as follows:

1. Include all relevant Java source code files for the client and server components, along with the text files.

2. (Optional) Provide any additional documentation or notes explaining your implementation details, design choices, and testing approach.

3. (Optional) If you implemented a GUI, include any necessary resources or instructions for successfully running the GUI.

4. Push your final code to the forked repository and send a PR (Pull Request) to your mentor. The submission deadline is **May 22nd (Khordad 2nd)**.

## Troubleshooting
If you encounter any issues or have questions regarding the assignment, please reach out to your mentors for assistance.

## Some Resources for Further Studying
Consider watching the following videos to grasp a better understanding of how socket programming in Java works:
- [Java Socket Programming Client Server Messenger by WittCode](https://youtu.be/gchR3DpY-8Q?si=dSyRSnFmB6fLIpej)
- [Java Socket Programming - Multiple Clients Chat by WittCode](https://www.youtube.com/watch?v=gLfuZrrfKes&t=739s)


Best regards,
Shayan :)