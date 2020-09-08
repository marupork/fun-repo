package com.sample.demo.service;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.mockito.Mockito.*;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

public class UserServiceTest {

    private final UserDAO userDAO = mock(UserDAO.class);
    private final SecurityService securityService = mock(SecurityService.class);
    private final User user = mock(User.class);

    private UserService userService = new UserService(userDAO, securityService);

    @Test
    void shouldSetPasswordAndUpdateUser() {
        final String PASSWORD = "changeme";
        final String MD5_PASSWORD = "changem3";

        when(user.getPassword()).thenReturn(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(MD5_PASSWORD);

        userService.assignPassword(user);

        verify(user).setPassword(MD5_PASSWORD);
        verify(userDAO).updateUser(user);
    }

    @Test
    void hasEntryTest() {
        User user_2 = new User();

        when(userDAO.getUserByProperties((Map<String, String>) argThat(hasEntry("id", "2"))))
                .thenReturn(user_2);

        assertThat(userDAO.getUserByProperties(Collections.emptyMap())).isNull();
        assertThat(userDAO.getUserByProperties(Collections.singletonMap("id", "2"))).isEqualTo(user_2);
    }
}
