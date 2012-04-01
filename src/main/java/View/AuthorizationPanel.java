package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorizationPanel extends JPanel {
    private JLabel serverLabel = new JLabel("Server ip", JLabel.CENTER);
    private JTextField serverName = new JTextField(12);
    private JLabel loginLabel = new JLabel("Login name", JLabel.CENTER);
    private JTextField clientName = new JTextField(12);
    private JButton connect = new JButton("Connect");
    private JButton exit = new JButton("Exit");

    AuthorizationPanel() {
        setLayout(new GridLayout(6, 1, 20, 15));
        add(serverLabel);
        add(serverName);
        add(loginLabel);
        add(clientName);
        add(connect);
        add(exit);
    }
    public String getServerName() {
        return serverName.getText();
    }
    public String getClientName() {
        return clientName.getText();
    }
    public void addConnectListener(ActionListener al) {
        connect.addActionListener(al);
    }
    public void addExitListener(ActionListener al) {
        exit.addActionListener(al);
    }
}
