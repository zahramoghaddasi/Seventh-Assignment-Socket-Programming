# Socket Programming Assignment - Group Chat + File Transfer 

## Introduction
Welcome to your 7th assignment! This assignment focuses on creating a command-line interface (CLI) application using **socket programming** concepts in Java. The objective is to create a robust and efficient mechanism for sending text messages between multiple clients and transferring text files from the server side to the client side.

## Objectives

- Reviewing the concepts of socket programming
- Creating a local server with the ability to handle incoming requests from clients
- Enabling clients to send massages in the group chat or download text files from the server

## Assignment Overview
The assignment comprises two main tasks as following:

### Task 1: Group Chat (Sending Text Messages)
In this task, the server will handle requests from clients to send text messages in a group chat. Each client shall be able to read the name of the sender of the massage with the message content in their own terminal. (Make sure that you are using sockets to transfer these massages between the clients and the server)

This task is something like the **massage broadcasting** example you had in you TA's session, so to make it a bit different you are urged to implement a **chat history** feature as well.

So this means that if a new client is connected to the server, he must be able to see **all the previous** chats in the group as well as the new massages being sent after his connection being stablished with the server. (**BONUS TASK: How to implement this feature in a way that a new member of the group chat can only see a limited number of the previous chats? That is, only $n$ previous massages where n is an arbitrary fix number!**)

#### Task 1 in Summery
- designing server and client side of the application in a way that users can comminate with each other through a group chat with the feature that newly joined members can see either a portion or all of the previous chats (massages sent before them joining the group chat)


### Task 2: File Transfer - Downloading Text Files
In this task, you will extend the functionality of the application you designed to allow clients to download text files from the server.

Thus the client should be able to view a list of the available files on the server and select one for download. Once the file is downloaded, it should be **copied** (**NOT cut**) to a directory related specifically to the client who sent the request to download the file. (In other words, the file must be transferred though a socket from the server side to the client side can be saved somewhere on the client side)

## Project Breakdown
Here is a suggested structure for your code:

#### 1. `Server` Class
 This class will handle the server-side operations. It will be responsible for accepting incoming client connections, managing file downloads, facilitating group chat functionality and giving a report (or server log).
    - `Server.java`
     This class will create a ServerSocket and **listen** for incoming client connections. It will spawn a new thread for each connected client to handle their requests concurrently.

#### 2. `ServerLogHandler` Class
 This class will handle logging operations on the server side. It will be responsible for creating, writing, and managing the server log file.

    - `ServerLogHandler.java`
     This class will provide methods to log server events, such as client connections, file downloads, and chat messages.

#### 3. `Client` Class
 This class will handle the client-side operations. It will connect to the server, interact with the user for file downloads or group chat, and send/receive messages to/from the server.
    - `Client.java`
     This class will represent a client and handle the interaction with the server. It will establish a socket connection with the server and send/receive messages.

#### 4. `FileHandler` Class
 This class will handle file-related operations, such as downloading files from the server to the client.
    - `FileHandler.java`
     This class will provide methods to download files from the server and save them on the client's machine.

#### 5. `ChatHandler` Class
 This class will handle the group chat functionality. It will receive messages from clients and broadcast them to all connected clients.
    - `ChatHandler.java`
    This class will manage the group chat functionality, including sending/receiving messages between clients and broadcasting messages to connected clients.

#### 6. Application's `Client-Server API`
To enable effective communication between the client and server sides of the application, a well-defined and predetermined interaction mechanism is implemented. This is achieved through a series of Request-Response interactions, where the client sends requests to the server, conveying specific instructions or queries. The server processes these requests and generates appropriate responses, providing the requested information or indicating the outcome of the actions. By employing this structured request-response approach, the client and server can seamlessly exchange data and instructions, ensuring synchronized communication and facilitating efficient coordination between the two components.

The designing of the API can be broken down into 2 main parts:

##### - 6.1 Request

A request must have these features:

- A request is sent from the client to the Server over the network
- You should create different types of requests for different actions
- A client can either request to see the list of available files, to download a file or to enter the group chat
- It is up to you to design the request's format. A request can be a JSON string which is easy to send on a socket, a string or any other data that can be sent through a server socket.


##### - 6.2 Response

A response must have these features:

- A response is sent from the server to the client over the network
- You should create different response types corresponding to the received Request
- Attach appropriate data to the response based on the request. A response might contain the data a user has requested, or it might just be a boolean indicating the result of a previously sent request
- Again, it is up to you to design the response's format. Similar to a request, a response can also be a JSON string, a string or whatever you think suits best

## Notes
- Each request received from the client must be answered with a response from the server
- When a client connects to the server, the server can utilize the request-response system to prompt the client to choose between file download or group chat options. The client sends a request specifying their choice, and the server, acting as the responder, processes the request using the appropriate handler, such as the FileHandler or ChatHandler, through the request-response mechanism.
- For file downloads, the server employs the FileHandler to provide the client with a list of available files. Upon receiving the client's selection request, the server initiates a request-response interaction, where the FileHandler retrieves and sends the requested file to the client, ensuring a seamless and controlled file transfer process.
- In the case of group chat, the server utilizes the ChatHandler to facilitate communication among connected clients. When a client sends a chat message, it triggers a request-response flow, where the ChatHandler receives the message request from the client, processes it, and then broadcasts the message to all connected clients. This allows for an efficient and coordinated group chat experience.
- By incorporating a request-response system, the server and clients establish a structured and organized communication flow. The clients make requests, specifying their choices or actions, and the server responds accordingly, ensuring proper handling and coordination of file downloads and group chat functionality.
- The structure mentioned in the `Project Breakdown` section is only a suggestion and you can implement any other structure you prefer.


## Getting Started
To begin working on the assignment, follow these steps:

1. Fork this repository. (**DO NOT clone it! Fork it first**)

2. Clone the forked repository from your own GitHub account to your local machine.

3. Make your own branch

4. The repository contains a README file and several text files (reachable through the path: `seventh_assignment/src/main/Server/data`), each storing the lyrics of a song.

5. Implement the client-side and server-side code as per the assignment requirements. Refer to the provided code comments and any additional guidelines mentioned in the code.

## Bonus Features
Consider implementing the following bonus features to enhance your application:

- User Interface: Add a graphical user interface (GUI) using Java's Swing or JavaFX libraries to improve the user experience.

- Progress Tracking: Provide a way for clients to monitor the progress of file transfers, allowing them to track the download progress. If you are familiar with JavaFX, consider implementing this with JavaFX.

- Although writing a documentation for this assignment is not mandatory (and won't earn extra points), it will help mentors understand your project's progress. Additionally, it will make your code more comprehensible for others if you decide to keep this assignment on your GitHub account.

**Of course implementing any other features are welcomed! The limit is your imagination!**

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
- [An IBM documentation on the **request-response design pattern**](https://developer.ibm.com/articles/awb-request-response-messaging-pattern-introduction/)
- [A medium article on **request-response design pattern**](https://ritikchourasiya.medium.com/request-response-a-deep-dive-into-backend-communication-design-pattern-47d641d9eb90)


Best regards<br>
Shayan 😎