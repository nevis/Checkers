package Model;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private int port = 5869;
    private String serverName = "localhost";
    private PrintWriter output;
    private BufferedReader input;
    private Socket socket;
    private boolean connected = false;
    private String name = null;
    
    public Client() throws IOException {
        InetAddress ia = InetAddress.getByName(serverName);
        socket = new Socket(ia, port);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMessage(String message) {
        output.println(message);
    }
    public BufferedReader getInput() {
        return input;
    }
    public boolean isConnected() {
        return connected;
    }
    public void setConnected(boolean conn) {
        connected = conn;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
