package com.example.javadesignpattern.dp.command;

public class ConcreteCommand2 extends Command {
    Receiver receiver;
    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
