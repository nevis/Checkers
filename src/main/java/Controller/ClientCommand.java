package Controller;

import Model.Model;
import Model.Player;
import View.WinView;

import javax.swing.*;

public class ClientCommand {
    private  Model model = null;
    private WinView view = null;
    public ClientCommand(WinView view, Model model) {
        this.model = model;
        this.view = view;
    }
    public void run(String in) {
        String [] str = in.split("\\;");
        String command = str[0];
        switch (model.getCommands().getClientCommand(command)) {
            case Connected: {
                connected();
                break;
            }
            case PlayerList: {
                playerList(str);
                break;
            }
            case AddPlayer: {
                addPlayer(str);
                break;
            }
            case RemovePlayer: {
                removePlayer(str);
                break;
            }
            case Invite: {
                invite(str);
                break;
            }
            case NoFindPlayer: {
                noFind(str);
                break;
            }
            case AcceptGame: {
                acceptGame(str);
                break;
            }
            case RejectInvite: {
                reject(str);
                break;
            }
        }
    }
    private void connected() {
        model.getClient().setConnected(true);
        view.removeAuthorizationPanel();
        view.setTitle(model.getClient().getName());
        view.addPlayerListPanel();
    }
    private void playerList(String [] str) {
        view.getPlayerListPanel().getListModel().removeAllElements();
        for (int i = 1; i < str.length; ) {
            model.getPlayerList().add(new Player(str[i], Integer.parseInt(str[i + 1])));
            i += 2;
        }
        for (Player p : model.getPlayerList()) {
            view.getPlayerListPanel().getListModel().addElement(p.getName());
        }
    }
    private void addPlayer(String [] str) {
        Player p = new Player(str[1], Integer.parseInt(str[2]));
        model.getPlayerList().add(p);
        view.getPlayerListPanel().getListModel().addElement(p.getName());
    }
    private void removePlayer(String [] str) {
        Player p = new Player(str[1], Integer.parseInt(str[2]));
        model.getPlayerList().remove(p);
        view.getPlayerListPanel().getListModel().removeElement(p.getName());
    }
    private void invite(String [] str) {
        int answer = JOptionPane.showConfirmDialog(null, "Player [" + str[1] +
                "] invite you to game!", "Invite", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            model.getClient().sendMessage("@acceptinvite;" + str[1] + ";" + str[2] + ";");
        } else if (answer == JOptionPane.NO_OPTION) {
            model.getClient().sendMessage("@rejectinvite;" + str[1] + ";" + str[2] + ";");
        }
    }
    private void noFind(String [] str) {
        JOptionPane.showMessageDialog(null,"Player [" + str[1] + "] no find!");
    }
    private void reject(String [] str) {
        JOptionPane.showMessageDialog(null,"Player [" + str[1] + "] reject you invite!");
    }
    private void acceptGame(String [] str) {
        view.removePlayerListPanel();
        view.addCheckersPanel();
        /*data.getMenuPanel().setVisible(false);
        data.getCheckersFrame("").pack();
        int chip = Integer.parseInt(str[1]);
        if (chip == 1) {
            data.setChip(chip);
            data.setTurn(true);
        } else if (chip == 2) {
            data.setChip(chip);
        }
        data.startBoard();
        */
        //System.out.println("start game");
    }
}
