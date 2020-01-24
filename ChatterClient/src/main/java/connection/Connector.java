package connection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class Connector {

    private static final int PORT = 2020;
    private static final String IP_DEFAULT = "127.0.0.1";

    private Socket socket;
    private String ip = IP_DEFAULT;

    private PrintWriter out;
    private BufferedReader in;

    public void setIP(String ip) {
        this.ip = ip;
    }

    public void connect() throws IOException {
        try {
            System.out.println("Connecting to server");
            socket = new Socket(ip, PORT);
            System.out.println("Connected to server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listen() {

        String input;

        try {
            while ((input = in.readLine()) != null) {
                System.out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {

        String output;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((output = reader.readLine()) != null) {
                out.write(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void communicate() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread inThread = new Thread(this::listen);
            Thread outThread = new Thread(this::write);
            inThread.run();
            outThread.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting program");
        Connector connector = new Connector();
        connector.connect();
        connector.communicate();

    }

}
