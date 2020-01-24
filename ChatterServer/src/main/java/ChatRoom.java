import java.util.LinkedList;
import java.util.List;

public class ChatRoom {

    private String client;
    private List<Client> clients = new LinkedList<>();

    public void addClient(Client client){
        clients.add(client);
    }

    public void messageRecieved(Client sendingClient, String message){
        for( Client client : clients ){
            client.sendMessage(message);
        }
    }

}
