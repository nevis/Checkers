package View;

import Controller.WinController;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WinView extends JFrame implements WindowListener {
    private AuthorizationPanel authorizationPanel = new AuthorizationPanel();
    private PlayerListPanel playerListPanel = new PlayerListPanel();
    private Model model = null;
    public WinView(Model model) {
        this.model = model;
        setTitle("Authorization");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);
        addAuthorizationPanel();
        setResizable(false);
        setVisible(true);
    }
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                WinView view = new WinView(model);
                WinController controller = new WinController(view, model);
            }
        });
    }
    public void addAuthorizationPanel() {
        add(authorizationPanel);
        pack();
        frameDisplayCenter();
    }
    public void removeAuthorizationPanel() {
        remove(authorizationPanel);
    }
    public AuthorizationPanel getAuthorizationPanel() {
        return authorizationPanel;
    }
    public void addPlayerListPanel() {
        add(playerListPanel);
        pack();
        frameDisplayCenter();
    }
    public void removePlayerListPanel() {
        remove(playerListPanel);
    }
    public PlayerListPanel getPlayerListPanel() {
        return playerListPanel;
    }
    private void frameDisplayCenter() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - getWidth()) / 2;
        int locationY = (screenSize.height - getHeight()) / 2;
        setLocation(locationX, locationY);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (model.getClient().isConnected()) {
            model.getClient().sendMessage("@exit;");
        }
        System.out.println("close window");
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
