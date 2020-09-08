package com.sample.demo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NewOperatorImprovedTest {

    @Test
    void testMyMethod() {
        CollaboratorImproved collaborator = mock(CollaboratorImproved.class);
        NewOperatorImproved sut = new NewOperatorImproved(collaborator);

        sut.myMethod();

        verify(collaborator).print();
    }
}
