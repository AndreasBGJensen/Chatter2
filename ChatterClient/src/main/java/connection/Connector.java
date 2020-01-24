package connection;

import java.io.IOException;
import java.net.Socket;

public class Connector {

    private static final int PORT = 2020;
    private static final String IP_DEFAULT = "127.0.0.1";

    private Socket socket;
    private String ip = IP_DEFAULT;

    public void setIP(String ip){
        this.ip = ip;
    }

    public void connect() throws IOException {
        System.out.println("Connecting to server");
        socket = new Socket(ip, PORT);
        System.out.println("Connected to server");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting program");
        Connector connector = new Connector();
        connector.connect();
    }

}
