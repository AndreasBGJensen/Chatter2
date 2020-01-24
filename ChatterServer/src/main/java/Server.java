import com.sun.security.ntlm.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {

    private static final int PORT = 2020;
    private ServerSocket serverSocket;
    private List<ClientConnection> connections = new LinkedList<>();


    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started");

        while(true){
            System.out.println("Waiting for new client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Found possible client: "+clientSocket);
            ClientConnection clientConnection =  new ClientConnection(clientSocket);
            System.out.println("Client accepted: " + clientConnection);
            connections.add(clientConnection);
            clientConnection.start();
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Main running");
        Server server = new Server();
        server.start();
    }

}
