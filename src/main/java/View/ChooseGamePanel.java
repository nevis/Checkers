package View;

import Controller.ChooseGameListener;
import Model.Model;

import javax.swing.*;
import java.awt.*;

public class ChooseGamePanel extends JPanel {
    private JPanel panel = new JPanel();
    private Model model;
    private WinView view;
    private String [] gameList;
    public ChooseGamePanel(String [] str, Model model, WinView view) {
        this.model = model;
        gameList = str;
        this.view = view;
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));
        panel = new JPanel();
        panel.setLayout(new GridLayout(str.length, 1, 0, 20));
        panel.add(new JLabel("Choose game", JLabel.CENTER));
        addChooseButton(str);
        add(panel);
    }
    private void addChooseButton(String [] str) {
        for (int i = 1; i < str.length; i++) {
            JButton chooseGame = new JButton(str[i]);
            chooseGame.setName(str[i]);
            chooseGame.addActionListener(new ChooseGameListener(model, view));
            panel.add(chooseGame);
        }
    }
    public String [] getGameList() {
        return gameList;
    }
}
