package com.sample.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RaceResultServiceTest {

    private RaceResultService raceResultService;

    private RaceClient clientA;
    private RaceClient clientB;

    private Message message;

    @BeforeEach
    void setup() {
        raceResultService = new RaceResultService();

        clientA = mock(RaceClient.class, "clientA");
        clientB = mock(RaceClient.class, "clientB");

        message = mock(Message.class);
    }

    // zero subscribers
    @Test
    void notSubscribedClientShouldNotReceiveMessage() {
        raceResultService.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    // one subscribers
    @Test
    void subscribedClientShouldReceiveMessage() {
        raceResultService.addSubscriber(clientA);

        raceResultService.send(message);

        verify(clientA).receive(message);
    }

    // two subscribers
    @Test
    void allSubscribedClientsShouldReceiveMessages() {
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientB);

        raceResultService.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientA);

        raceResultService.send(message);

        verify(clientA).receive(message);
    }

    @Test
    void unsubscribedClientShouldNotReceiveMessages() {
        raceResultService.addSubscriber(clientA);

        raceResultService.removeSubscriber(clientA);
        raceResultService.send(message);

        verify(clientA, never()).receive(message);
    }
}
