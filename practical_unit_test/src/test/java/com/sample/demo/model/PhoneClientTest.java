package com.sample.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneClientTest {

    private final static String ANY_NUMBER = "999-888-777";
    private final static Phone MOBILE_PHONE = new Phone(ANY_NUMBER, true);
    private final static Phone STATIONARY_PHONE = new Phone(ANY_NUMBER, false);

    private PhoneClient phoneClient = new PhoneClient();

    @Test
    void shouldReturnTrueIfClientHasMobile() {
        phoneClient.addPhone(MOBILE_PHONE);
        phoneClient.addPhone(STATIONARY_PHONE);

        assertThat(phoneClient.hasMobile()).isTrue();
    }

    @Test
    void shouldReturnFalseIfClientHasNoMobile() {
        phoneClient.addPhone(STATIONARY_PHONE);

        assertThat(phoneClient.hasMobile()).isFalse();
    }
}
