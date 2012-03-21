package Controller;

import Model.Model;
import View.WinView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InviteListener implements ActionListener {
    private WinView view = null;
    private  Model model = null;
    public InviteListener(WinView view, Model model) {
        this.view = view;
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("invite");
    }
}
