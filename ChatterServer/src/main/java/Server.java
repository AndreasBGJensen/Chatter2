import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 2020;
    private ServerSocket serverSocket;
    private Socket client;


    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started");

        System.out.println("Waiting for client...");
        client = serverSocket.accept();
        System.out.println("Client accepted: "+client);
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Main running");
        Server server = new Server();
        server.start();
    }

}
