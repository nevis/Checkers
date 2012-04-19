package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.io.IOException;

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
        try {
            model.setClient(view.getAuthorizationPanel().getServerName(), view.getAuthorizationPanel().getClientName());
            model.getClient().sendMessage("@connect;" + model.getClient().getName() + ";");
            new ClientThread(clientCommand, model);
        } catch (IOException ex) {
            clientCommand.run("@error;" + "Connection error!");
        }
    }
}
