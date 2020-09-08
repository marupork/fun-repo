package com.sample.demo.service;

public class Messenger {

    private TemplateEngine templateEngine;
    private MailServer mailServer;

    public Messenger(TemplateEngine templateEngine, MailServer mailServer) {
        this.templateEngine = templateEngine;
        this.mailServer = mailServer;
    }

    public void sendMessage(Client client, Template template) {
        String msgContent = templateEngine.prepareMessage(template, client);
        mailServer.send(client.getEmail(), msgContent);
    }
}

// direct input
class Client {
    private String email;
    public String getEmail() {
        return email;
    }
}

// direct input
class Template {
}

// collaborators
interface TemplateEngine {
    String prepareMessage(Template template, Client client);
}

// collaborators
interface MailServer {
    void send(String email, String msgContent);
}
