package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConnectListener implements ActionListener {
    private WinView view = null;
    private Model model = null;
    private ClientCommand clientCommand;
    
    ConnectListener(WinView view, Model model) {
        this.view = view;
        this.model = model;
        clientCommand = new ClientCommand(this.view, this.model);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        model.setClient(view.getAuthorizationPanel().getServerName());
        model.getClient().setName(view.getAuthorizationPanel().getClientName());
        tryConnect();
    }
    public void tryConnect() {
        model.getClient().sendMessage("@connect;" + model.getClient().getName() + ";");
        new ClientThread(clientCommand, model);
    }
}
