package Controller;

import Model.Model;
import View.WinView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseGameListener implements ActionListener {
    private WinView view;
    private Model model;
    public ChooseGameListener(Model model, WinView view) {
        this.model = model;
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String name = button.getName();
        String [] list = view.getChooseGamePanel().getGameList();
        for (int i = 1; i < list.length; i++) {
            if (list[i].equals(name)) {
                model.getClient().sendMessage("@game;" + i);
                view.removeChooseGamePanel();
                view.addPlayerListPanel();
            }
        }
    }
}
