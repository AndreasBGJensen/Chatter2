import java.net.Socket;

public class ClientConnection {

    private Socket socket;
    private String name;
    private Thread thread;


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
        /*try{
            System.out.println("Client interruted");


        }catch(InterruptedException interrupted){

        }*/

    }

    public void stop(){
        thread.interrupt();
    }





}
