package com.sample.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoBoilerplateAnnotationsTest {

    @Mock
    private CollaboratorMockito collaborator;

    @InjectMocks
    private MockitoBoilerplate sut = new MockitoBoilerplate();

    @Test
    void shouldReturnABC() {
        when(collaborator.doSth()).thenReturn("abc");
        assertThat(sut.useCollab()).isEqualTo("abc");
    }

}
