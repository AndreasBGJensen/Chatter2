import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Client {

    private Socket socket;
    private Thread thread;
    private BufferedReader inputReader;
    private PrintWriter writer;

    public ChatRoom getRoom() {
        return room;
    }

    public void setRoom(ChatRoom room) {
        this.room = room;
    }

    private ChatRoom room = null;

    public Client(Socket socket ){
        this.socket = socket;

    }

    public void start(){
        System.out.println("Starting new client thread");
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread = new Thread(this::listen);
        thread.start();
        System.out.println("Started client thread");
    }


    public void listen(){
        try{
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                System.out.println("Waiting for input from client...");
                String input = inputReader.readLine();
                room.messageRecieved( this, input );
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

    public void sendMessage(String message){
        writer.println(message);
    }

    @Override
    public String toString(){
        return String.format("Client{ %s:%d }", socket.getLocalAddress(), socket.getLocalPort());
    }




}
