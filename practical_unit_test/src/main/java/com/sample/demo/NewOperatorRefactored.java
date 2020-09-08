package com.sample.demo;

public class NewOperatorRefactored {

    void print() {
        CollaboratorRefactored collaborator = createCollaborator();
        collaborator.print();
    }

    Boolean checkStatus() {
        CollaboratorRefactored collaborator = createCollaborator();
        return collaborator.hasPrinted();
    }

    // method extracted to facilitate testing
    CollaboratorRefactored createCollaborator() {
        return new CollaboratorRefactored();
    }
}

class CollaboratorRefactored {
    public void print() {
        System.out.println("I am a collaborator");
    }

    public Boolean hasPrinted() {
        return true;
    }
}
