package com.sample.demo;

public class MockitoBoilerplate {

    private CollaboratorMockito collaborator;

    public void setCollaborator(CollaboratorMockito collaborator) {
        this.collaborator = collaborator;
    }

    public String useCollab() {
        return collaborator.doSth();
    }
}

class CollaboratorMockito {
    public String doSth() {
        return "xyz";
    }
}