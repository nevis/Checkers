package Controller;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InviteListener implements ActionListener {
    private  Model model = null;
    private StringBuilder command = new StringBuilder();
    public InviteListener(Model model) {
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.getOpponent() != null) {
            command.append("@invite;" + model.getOpponent().getName() + ";"
                + model.getOpponent().getHashCode() + ";");
            model.getClient().sendMessage(command.toString());
        }
    }
}
