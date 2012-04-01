package Model;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Model {
    public static final Color DARK = new Color(222, 184, 135);
    public static final Color LIGHT = new Color(139, 69, 19);
    public static final int CHECKERS_CELL_SIZE = 60;
    private Client client;
    private Commands commands = new Commands();
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private Player opponent = null;
    private Checkers checkers = new Checkers(this);

    public Client getClient() {
        return client;
    }
    public void setClient(String serverName) {
        try {
            client = new Client(serverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public Checkers getCheckers() {
        return checkers;
    }
}