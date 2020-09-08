package com.sample.demo;

import static org.mockito.Mockito.mock;

public class NewOperatorTest {

    public void testMyMethod() {
        NewOperator sut = new NewOperator();

        Collaborator collaborator = mock(Collaborator.class);

        // make sut use collaborator
        // set expectations regarding collaborator's behaviour
        // execute sut's method(s)
        // verify results and/or collaborator's behaviour
    }
}
