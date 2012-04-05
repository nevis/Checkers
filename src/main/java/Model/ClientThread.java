package Model;


import Controller.ClientCommand;

import java.io.IOException;

public class ClientThread extends Thread {
    private String serverAnswer = null;
    private ClientCommand clientCommand;
    private Model model;
    
    public ClientThread(ClientCommand clientCommand, Model model) {
        this.clientCommand = clientCommand;
        this.model = model;
        start();
    }
    @Override
    public void run() {
        try {
            while (true) {
                if ((serverAnswer = model.getClient().getInput().readLine()) != null) {
                    System.out.println(serverAnswer);
                    clientCommand.run(serverAnswer);
                }
            }
        } catch (IOException e) {
            clientCommand.run("@error;" + "Connection error!");
        }
    }
}
