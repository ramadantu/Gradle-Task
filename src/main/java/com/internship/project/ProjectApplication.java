package com.internship.project;

import com.internship.project.networking.GreetClient;

import java.io.IOException;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendData("3 + 2");
        System.out.println(response);
    }
}