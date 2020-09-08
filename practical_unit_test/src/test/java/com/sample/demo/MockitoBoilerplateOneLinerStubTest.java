package com.sample.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoBoilerplateOneLinerStubTest {

    private CollaboratorMockito collaborator =
            when(mock(CollaboratorMockito.class).doSth())
                    .thenReturn("abc").getMock();
    private MockitoBoilerplate sut;

    @BeforeEach
    void setUp() {
        sut = new MockitoBoilerplate();
        sut.setCollaborator(collaborator);
    }

    @Test
    void shouldReturnABC() {
        assertThat(sut.useCollab()).isEqualTo("abc");
    }
}
