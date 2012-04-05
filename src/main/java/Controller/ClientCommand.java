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
            case Error: {
                JOptionPane.showMessageDialog(null, "Connection error!");
                break;
            }
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
            case Turn: {
                turn(str);
                break;
            }
            case Kill: {
                kill(str);
                break;
            }
            case Lose: {
                JOptionPane.showMessageDialog(null, "You lose!");
                showPlayerListPanel();
                break;
            }
            case Win: {
                JOptionPane.showMessageDialog(null, "You win!");
                showPlayerListPanel();
                break;
            }
            case EnemyOff: {
                JOptionPane.showMessageDialog(null, "Enemy left game!");
                showPlayerListPanel();
            }
        }
    }
    private void kill(String [] str) {
        model.getCheckers().setCheckersBoardValue(reverse(Integer.parseInt(str[1])),
                reverse(Integer.parseInt(str[2])), 0);
        model.getCheckers().setCheckersBoardValue(reverse(Integer.parseInt(str[3])),
                reverse(Integer.parseInt(str[4])),  Integer.parseInt(str[8]));
        model.getCheckers().setCheckersBoardValue(reverse(Integer.parseInt(str[1]) + Integer.parseInt(str[5])),
                reverse(Integer.parseInt(str[2]) + Integer.parseInt(str[6])), 0);
        view.getCheckersPanel().repaint();
        if (str[7].equals("end")) model.getCheckers().setTurn(true);
    }
    private void turn(String [] str) {
        model.getCheckers().setCheckersBoardValue(reverse(Integer.parseInt(str[1])),
                reverse(Integer.parseInt(str[2])), 0);
        model.getCheckers().setCheckersBoardValue(reverse(Integer.parseInt(str[3])),
                reverse(Integer.parseInt(str[4])), Integer.parseInt(str[5]));
        view.getCheckersPanel().repaint();
        model.getCheckers().setTurn(true);
    }
    private int reverse(int number) {
        switch (number) {
            case 0: return 7;
            case 1: return 6;
            case 2: return 5;
            case 3: return 4;
            case 4: return 3;
            case 5: return 2;
            case 6: return 1;
            case 7: return 0;
            default: return -1;
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
        model.getPlayerList().removeAll(model.getPlayerList());
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
        model.removeFromPlayerListByHashCode(Integer.parseInt(str[2]));
        view.getPlayerListPanel().getListModel().removeElement(str[1]);
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
        view.getPlayerListPanel().getInvite().setEnabled(true);
    }
    private void reject(String [] str) {
        JOptionPane.showMessageDialog(null,"Player [" + str[1] + "] reject you invite!");
        view.getPlayerListPanel().getInvite().setEnabled(true);
    }
    private void acceptGame(String [] str) {
        view.getPlayerListPanel().getInvite().setEnabled(true);
        view.removePlayerListPanel();
        view.addCheckersPanel();
        model.getCheckers().setChip(Integer.parseInt(str[1]));
        model.getCheckers().refreshCheckersBoard();
        if (model.getCheckers().getChip() == 1) {
            view.setTitle(view.getTitle() + ": WHITE");
            model.getCheckers().setTurn(true);
        }
        else {
            view.setTitle(view.getTitle() + ": BLACK");
            model.getCheckers().setTurn(false);
        }
    }
    private void showPlayerListPanel() {
        view.removeCheckersPanel();
        view.setTitle(model.getClient().getName());
        view.addPlayerListPanel();
    }
}
