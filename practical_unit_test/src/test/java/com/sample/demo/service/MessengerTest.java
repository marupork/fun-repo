package com.sample.demo.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MessengerTest {

    private static final String CLIENT_EMAIL = "em@il.com";
    private static final String MSG_CONTENT = "Important message";

    @Test
    public void mockitoCreatesInstancesOfRequestedTypes() {
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);

        assertThat(mailServer).isInstanceOf(MailServer.class);
        assertThat(templateEngine).isInstanceOf(TemplateEngine.class);
    }

    @Test
    public void shouldSendEmail() {

        // Mocking. Creation of all test doubles.
        Template template = mock(Template.class);
        Client client = mock(Client.class);
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);

        // Creation of our SUT and injection of required collaborators
        Messenger sut = new Messenger(templateEngine, mailServer);

        // Stubbing. This is how we expect our client and templateEngine stubs to behave.
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

        // Execution of the sendMessage() method of the SUT. We are not interested in its outputs, as it has none (this method’s return type is void).
        sut.sendMessage(client, template);

        // Verification of the behaviour of the SUT
        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}
