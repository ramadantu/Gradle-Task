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

        String firstOperand = data.substring(
                data.indexOf(data.charAt(0)), data.indexOf(data.charAt(1)));
        String operator = data.substring(
                data.indexOf(data.charAt(2)), data.indexOf(data.charAt(4)));
        String secondOperand = data.substring(
                data.indexOf(data.charAt(4)));

        char typeOperand = 'i';
        byte[] firstOperandInBytes = firstOperand.getBytes(StandardCharsets.UTF_8);

        out.writeChar(typeOperand);
        out.writeInt(firstOperandInBytes.length);
        out.write(firstOperandInBytes);

        char typeOperator = 'c';
        byte[] operatorInBytes = operator.getBytes(StandardCharsets.UTF_8);

        out.writeChar(typeOperator);
        out.writeInt(operatorInBytes.length);
        out.write(operatorInBytes);

        byte[] secondOperandInBytes = secondOperand.getBytes(StandardCharsets.UTF_8);

        out.writeChar(typeOperand);
        out.writeInt(secondOperandInBytes.length);
        out.write(secondOperandInBytes);

        return in.readLine();
    }
}
