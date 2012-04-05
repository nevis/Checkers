package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectListener implements ActionListener {
    private WinView view = null;
    private Model model = null;
    private ClientCommand clientCommand;
    
    ConnectListener(WinView view, Model model, ClientCommand clientCommand) {
        this.view = view;
        this.model = model;
        this.clientCommand = clientCommand;
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
