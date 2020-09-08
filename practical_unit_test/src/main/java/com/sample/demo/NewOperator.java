package com.sample.demo;

public class NewOperator {

    public void myMethod() {
        Collaborator collaborator = new Collaborator();
        collaborator.print();
    }
}

class Collaborator {
    public void print() {
        System.out.println("I am a collaborator");
    }
}
