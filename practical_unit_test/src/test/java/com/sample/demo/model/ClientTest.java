package com.sample.demo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {

    private Client client;
    private Address address = new Address("Ohio");
    private Address secondAddress = new Address("New York");

    @BeforeEach
    void setup() {
        client = new Client();
    }

    @Test
    void afterCreationShouldHaveNoAddress() {
        assertThat(client.getAddressList()).isNullOrEmpty();
    }

    @Test
    void shouldAllowToAddAddress() {
        client.addAddress(address);

        assertThat(client.getAddressList()).hasSize(1);
        assertThat(client.getAddressList()).contains(address);
    }

    @Test
    void shouldAllowToAddManyAddresses() {
        client.addAddress(address);
        client.addAddress(secondAddress);

        assertThat(client.getAddressList()).hasSize(2);
        assertThat(client.getAddressList()).contains(address);
        assertThat(client.getAddressList()).contains(secondAddress);
    }
}
