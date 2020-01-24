package main.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {

    private ChatRoom room = new ChatRoom();
    private ServerSocket serverSocket;
    private List<Client> connections = new LinkedList<>();


    public void start() throws IOException {
        serverSocket = new ServerSocket(ConnectionSettings.PORT);
        System.out.println("Server started");


        while(true){
            System.out.println("Waiting for new client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Found possible client: "+clientSocket);
            Client client =  new Client(clientSocket);
            System.out.println("Client accepted: " + client);
            connections.add(client);
            room.addClient(client);
            client.setRoom(room);
            client.start();
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Main running");
        Server server = new Server();
        server.start();
    }

}
