package com.sample.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class NewOperatorRefactoredTest {

    private CollaboratorRefactored collaborator;

    class NewOperatorRefactoredSubclassed extends NewOperatorRefactored {
        @Override
        CollaboratorRefactored createCollaborator() {
            return collaborator;
        }
    }

    @Test
    void testPrint() {
        NewOperatorRefactored sut = new NewOperatorRefactoredSubclassed();
        collaborator = mock(CollaboratorRefactored.class);

        sut.print();

        verify(collaborator).print();
    }

    @Test
    void testStatus() {
        NewOperatorRefactored sut = new NewOperatorRefactoredSubclassed();
        collaborator = mock(CollaboratorRefactored.class);

        when(collaborator.hasPrinted()).thenReturn(true);

        boolean result = sut.checkStatus();
        assertThat(result).isTrue();
    }

    @Test
    void testPrintPartialMocking() {
        NewOperatorRefactored sut = spy(new NewOperatorRefactored());

        CollaboratorRefactored collaborator = mock(CollaboratorRefactored.class);
        doReturn(collaborator).when(sut).createCollaborator();

        sut.print();

        verify(collaborator).print();
    }

    @Test
    void testStatusPartialMocking() {
        NewOperatorRefactored sut = spy(new NewOperatorRefactored());

        CollaboratorRefactored collaborator = mock(CollaboratorRefactored.class);
        doReturn(collaborator).when(sut).createCollaborator();

        when(collaborator.hasPrinted()).thenReturn(true);

        Boolean result = sut.checkStatus();
        assertThat(result).isTrue();
    }
}
