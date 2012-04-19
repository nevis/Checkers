package Model;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private int port = 5869;
    private PrintWriter output;
    private BufferedReader input;
    private Socket socket;
    private boolean connected = false;
    private String name = null;
    
    public Client(String serverName, String name) throws IOException {
        InetAddress ia = InetAddress.getByName(serverName);
        this.name = name;
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
    public String getName() {
        return name;
    }
}
