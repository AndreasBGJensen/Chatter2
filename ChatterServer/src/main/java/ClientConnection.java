import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ClientConnection {

    private Socket socket;
    private Thread thread;
    private BufferedReader inputReader;


    public ClientConnection( Socket socket ){
        this.socket = socket;
    }

    public void start(){
        System.out.println("Starting new client thread");
        thread = new Thread(this::listen);
        thread.run();
        System.out.println("Started client thread");
    }


    public void listen(){
        try{
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                System.out.println("Waiting for input from client...");
                String input = inputReader.readLine();
                System.out.println("Input from client: "+input);
            }

        } catch (SocketException e){
            System.out.println("Lost client");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        thread.interrupt();
    }


    @Override
    public String toString(){
        return String.format("Client{ %s:%d }", socket.getLocalAddress(), socket.getLocalPort());
    }
}
