package com.internship.project.networking;

import com.internship.project.calculating.ArithmeticOperations;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private DataInputStream in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

        char dataType = in.readChar();
        int length = in.readInt();

        StringBuilder operator = new StringBuilder();

        if (dataType == 'c') {
            byte[] operatorByte = new byte[length];
            boolean end = false;
            operator = new StringBuilder(length);
            int totalBytesRead = 0;
            while (!end) {
                int currentBytesRead = in.read(operatorByte);
                totalBytesRead = currentBytesRead + totalBytesRead;
                if (totalBytesRead <= length) {
                    operator
                            .append(new String(operatorByte, 0, currentBytesRead, StandardCharsets.UTF_8));
                } else {
                    operator
                            .append(new String(operatorByte, 0, length - totalBytesRead + currentBytesRead, StandardCharsets.UTF_8));
                }
                if (operator.length() >= length) {
                    end = true;
                }
            }
        }

        List<String> operandArray = new ArrayList<>();

        if (dataType == 'i') {
            byte[] operandByte = new byte[length];
            boolean end = false;
            StringBuilder operand = new StringBuilder(length);
            int totalBytesRead = 0;
            while (!end) {
                int currentBytesRead = in.read(operandByte);
                totalBytesRead = currentBytesRead + totalBytesRead;
                if (totalBytesRead <= length) {
                    operand
                            .append(new String(operandByte, 0, currentBytesRead, StandardCharsets.UTF_8));
                } else {
                    operand
                            .append(new String(operandByte, 0, length - totalBytesRead + currentBytesRead, StandardCharsets.UTF_8));
                }
                if (operand.length() >= length) {
                    operandArray.add(String.valueOf(operand));
                    end = true;
                }
            }
        }

        out.println(operator);

        ArithmeticOperations calculator = new ArithmeticOperations();
        out.println(operandArray.get(0) + operator + operandArray.get(1) +
                " = " + calculator.apply(
                operandArray.get(0) + operator + operandArray.get(1)));
    }

    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer();
        server.start(6666);
    }
}
