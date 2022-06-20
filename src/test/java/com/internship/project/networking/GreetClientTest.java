package com.internship.project.networking;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GreetClientTest {

    @Test
    public void givenGreetingClient_whenServerRespondWhenStarted_thenCorrect() throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendData("3 + 2");
        assertEquals("3 + 2 = 5.0", response);
    }

}