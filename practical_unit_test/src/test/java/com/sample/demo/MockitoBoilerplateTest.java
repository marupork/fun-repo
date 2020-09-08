package com.sample.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

public class MockitoBoilerplateTest {

    private CollaboratorMockito collaborator;
    private MockitoBoilerplate sut;

    @BeforeEach
    void setUp() {
        collaborator = Mockito.mock(CollaboratorMockito.class);

        sut = new MockitoBoilerplate();
        sut.setCollaborator(collaborator);
    }

    @Test
    void shouldReturnABC() {
        when(collaborator.doSth()).thenReturn("abc");
        assertThat(sut.useCollab()).isEqualTo("abc");
    }
}
