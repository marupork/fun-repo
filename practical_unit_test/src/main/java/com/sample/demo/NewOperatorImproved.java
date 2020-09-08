package com.sample.demo;

public class NewOperatorImproved {

    private final CollaboratorImproved collaborator;

    public NewOperatorImproved(CollaboratorImproved collaborator) {
        this.collaborator = collaborator;
    }

    public void myMethod() {
        collaborator.print();;
    }
}

class CollaboratorImproved {
    public void print() {
        System.out.println("I am a collaborator");
    }
}
