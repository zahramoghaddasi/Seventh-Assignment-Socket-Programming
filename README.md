# Seventh-Assignment-Socket-Programming

## Introduction
Welcome to your 7th assignment! This assignment focuses on building a **client-server** file transfer system using **socket programming** in Java. The goal is to create a reliable and efficient mechanism for sending text messages and transferring text files between clients.

## Assignment Overview
In this assignment, you will implement a file transfer application with the following two phases:

### Phase 1: Sending Text Messages
In this phase, you will create a client-server application where clients can send text messages to each other. The key features of this phase include:

1. Client-Server Architecture: The application follows a client-server model, where the server manages incoming client connections and handles message routing.

2. Sending Messages: Clients can select the recipient client and send text messages to them.

3. Error Handling and Reliability: Implement mechanisms to handle errors and ensure reliable message delivery.

### Phase 2: Transferring Text Files
In this phase, you will extend the functionality of the application to allow clients to transfer text files between each other. The key features of this phase include:

1. File Upload: Clients can provide the address of a text file and send it to another client.

2. File Download: Clients can receive text files from other clients based on the provided address.

3. Address Formats:
   - For Linux/Mac: Use the absolute path of the file, e.g., `/home/user/Documents/file.txt`.
   - For Windows: Use the absolute path of the file, e.g., `C:\Users\User\Documents\file.txt`.

4. Error Handling and Reliability: Implement mechanisms to handle errors and ensure reliable file transfer.

5. Progress Tracking: Provide a way to track the progress of file transfers, allowing clients to monitor the upload/download progress. (Considering the fact that you know how to use JavaFX, implementing this part with JavaFX is welcomed!)

6. (Optional) User Interface: You may choose to add a graphical user interface (GUI) to enhance the user experience. Java's Swing or JavaFX libraries can be used for this purpose.

## Getting Started
To begin working on the assignment, follow these steps:

0. Fork this repository. (**DO NOT clone it! Fork first**)

1. Clone the forked repo from your own GitHub account to your local machine.

2. Familiarize yourself with the code structure and existing classes. You will find placeholders and comments that guide you in implementing the required functionality.

3. Implement the client-side and server-side code as per the assignment requirements. Refer to the provided comments and any additional guidelines mentioned in the code.

4. Test your implementation thoroughly to ensure correctness and robustness. Consider edge cases, error scenarios, and concurrent operations.

6. (Optional) If you choose to implement a GUI, design an intuitive interface that allows users to interact with the application easily. The limit is your imagination.

7. Though writing documentation for this assignment is not necessary (and won't be given any extra points), writing one will first help the mentors understand how you have worked throughout the project and second, make your code more comprehensible for others (if you plan to keep this assignment on your GitHub account).

## Submission
When you have completed the assignment, please prepare your submission as follows:

1. Include all the relevant Java source code files for the client and server components.

2. (Optional) Provide any additional documentation or notes that explain your implementation details, design choices, and testing approach.

3. (Optional) If you implemented a GUI, include any necessary resources or instructions for running the GUI successfully.

4. Push your final code to the repo you have forked and send a PR (Pull Request) to your mentor. The deadline for submission is May 22nd (Khordad 2nd).

## Troubleshooting
If you encounter any issues or have questions regarding the assignment, please reach out to your mentors for assistance.

Best regards,
Shayan :)