package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthorizationPanel extends JPanel {
    private JLabel label = new JLabel("Login name", JLabel.CENTER);
    private JTextField clientName = new JTextField(12);
    private JButton connect = new JButton("Connect");
    private JButton exit = new JButton("Exit");

    AuthorizationPanel() {
        setLayout(new GridLayout(4, 1, 20, 15));
        add(label);
        add(clientName);
        add(connect);
        add(exit);
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
