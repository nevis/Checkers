package Controller;

import Model.Model;
import View.WinView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InviteListener implements ActionListener {
    private  Model model = null;
    private WinView view;
    public InviteListener(Model model, WinView view) {
        this.model = model;
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.getOpponent() != null) {
            view.getPlayerListPanel().getInvite().setEnabled(false);
            model.getClient().sendMessage("@invite;" + model.getOpponent().getName() + ";"
                    + model.getOpponent().getHashCode() + ";");
        }
    }
}
