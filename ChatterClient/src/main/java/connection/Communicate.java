package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communicate {

//    private Socket socket;
//
//    private PrintWriter out;
//    private BufferedReader in;
//
//    public Communicate(Socket socket){
//        this.socket = socket;
//    }
/*

    private PrintWriter out;
    private BufferedReader in;

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
                out.println(output);
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
            outThread.start();
            inThread.start();
            System.out.println("You may now begin.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 */
}


