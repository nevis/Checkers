package Model;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Model {
    public static final Color DARK = new Color(222, 184, 135);
    public static final Color LIGHT = new Color(139, 69, 19);
    private Client client = null;
    private Commands commands = new Commands();
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private Player opponent = null;

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
    public void setOpponent(int opponentIndex) {
        if (opponentIndex > -1) opponent = playerList.get(opponentIndex);
    }
    public Player getOpponent() {
        return opponent;
    }
}