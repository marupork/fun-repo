package com.sample.demo.service;

import java.util.HashSet;
import java.util.Set;

public class RaceResultService {

    private Set<RaceClient> clients = new HashSet<>();

    public void addSubscriber(RaceClient client) {
        clients.add(client);
    }

    public void send(Message message) {
        clients.forEach(client -> client.receive(message));
    }

    public void removeSubscriber(RaceClient client) {
        clients.remove(client);
    }
}

interface RaceClient {
    void receive(Message message);
}

interface Message {

}