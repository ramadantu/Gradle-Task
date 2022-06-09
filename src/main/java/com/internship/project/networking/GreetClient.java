package com.internship.project.networking;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class GreetClient {
    private Socket clientSocket;
    private DataOutputStream out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new DataOutputStream(clientSocket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendData(String data) throws IOException {
        char type = 's';
        byte[] dataInBytes = data.getBytes(StandardCharsets.UTF_8);

        out.writeChar(type);
        out.writeInt(dataInBytes.length);
        out.write(dataInBytes);

        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
