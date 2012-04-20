package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorizationPanel extends JPanel {
    private JLabel serverLabel = new JLabel("Server name", JLabel.CENTER);
    private JTextField serverName = new JTextField(12);
    private JLabel loginLabel = new JLabel("Login name", JLabel.CENTER);
    private JTextField clientName = new JTextField(12);
    private JButton connect = new JButton("Connect");
    private JButton exit = new JButton("Exit");

    AuthorizationPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 0, 15));
        panel.add(serverLabel);
        panel.add(serverName);
        panel.add(loginLabel);
        panel.add(clientName);
        panel.add(connect);
        panel.add(exit);
        add(panel);
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
