package com.sample.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhoneClientDoubleTest {

    private final static Phone MOBILE_PHONE = mock(Phone.class);
    private final static Phone STATIONARY_PHONE = mock(Phone.class);

    private PhoneClient phoneClient = new PhoneClient();

    @Test
    void shouldReturnTrueIfClientHasMobile() {
        when(MOBILE_PHONE.isMobile()).thenReturn(true);

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
