package View;

import Controller.WinController;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WinView extends JFrame implements WindowListener {
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                WinView view = new WinView(model);
                new WinController(view, model);
            }
        });
    }

    private AuthorizationPanel authorizationPanel;
    private ChooseGamePanel chooseGamePanel;
    private PlayerListPanel playerListPanel;
    private CheckersPanel checkersPanel;
    private InfoPanel infoPanel;
    private Model model;

    public WinView(Model model) {
        this.model = model;
        authorizationPanel = new AuthorizationPanel();
        playerListPanel = new PlayerListPanel();
        checkersPanel = new CheckersPanel(this.model);
        infoPanel = new InfoPanel();
        setTitle("Authorization");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);
        addAuthorizationPanel();
        setResizable(false);
        setVisible(true);
    }
    public void addAuthorizationPanel() {
        add(authorizationPanel, BorderLayout.CENTER);
        pack();
        frameDisplayCenter();
    }
    public void removeAuthorizationPanel() {
        remove(authorizationPanel);
    }
    public AuthorizationPanel getAuthorizationPanel() {
        return authorizationPanel;
    }
    public void createChooseGamePanel(String [] str) {
        chooseGamePanel = new ChooseGamePanel(str, model, this);
    }
    public void addChooseGamePanel() {
        add(chooseGamePanel, BorderLayout.CENTER);
        pack();
        frameDisplayCenter();
    }
    public void removeChooseGamePanel() {
        remove(chooseGamePanel);
    }
    public ChooseGamePanel getChooseGamePanel() {
        return chooseGamePanel;
    }
    public void addPlayerListPanel() {
        add(playerListPanel, BorderLayout.CENTER);
        pack();
        frameDisplayCenter();
    }
    public void removePlayerListPanel() {
        remove(playerListPanel);
    }
    public PlayerListPanel getPlayerListPanel() {
        return playerListPanel;
    }
    public void addCheckersPanel() {
        add(checkersPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.NORTH);
        pack();
        frameDisplayCenter();
    }
    public void removeCheckersPanel() {
        remove(checkersPanel);
        remove(infoPanel);
    }
    public CheckersPanel getCheckersPanel() {
        return checkersPanel;
    }
    public InfoPanel getInfoPanel() {
        return infoPanel;
    }
    private void frameDisplayCenter() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - getWidth()) / 2;
        int locationY = (screenSize.height - getHeight()) / 2;
        setLocation(locationX, locationY);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if ((model.getClient() != null) && model.getClient().isConnected()) {
            model.getClient().sendMessage("@exit;");
        }
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    @Override
    public void windowOpened(WindowEvent e) {}
}
