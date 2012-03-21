package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Model {
    private Client client = null;
    private Commands commands = new Commands();
    private ArrayList<Player> playerList = new ArrayList<Player>();

    public Client getClient() {
        if (client == null) {
            try {
                client = new Client();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return client;
    }
    public Commands getCommands() {
        return commands;
    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}