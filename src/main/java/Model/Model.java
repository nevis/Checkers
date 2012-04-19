package Model;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Model {
    public static final Image white1 = Toolkit.getDefaultToolkit().getImage("source/white1.jpg");
    public static final Image white2 = Toolkit.getDefaultToolkit().getImage("source/white2.jpg");
    public static final Image whiteCell = Toolkit.getDefaultToolkit().getImage("source/whitecell.jpg");
    public static final Image black1 = Toolkit.getDefaultToolkit().getImage("source/black1.jpg");
    public static final Image black2 = Toolkit.getDefaultToolkit().getImage("source/black2.jpg");
    public static final Image blackCell   = Toolkit.getDefaultToolkit().getImage("source/blackcell.jpg");
    public static final int CHECKERS_CELL_SIZE = 63;
    private Client client;
    private Commands commands = new Commands();
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private Player opponent;
    private Checkers checkers = new Checkers(this);

    public Client getClient() {
        return client;
    }
    public void setClient(String serverName, String name) throws IOException {
         client = new Client(serverName, name);
    }
    public Commands getCommands() {
        return commands;
    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public void removeFromPlayerListByHashCode(int hashCode) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getHashCode() == hashCode) playerList.remove(i);
        }
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