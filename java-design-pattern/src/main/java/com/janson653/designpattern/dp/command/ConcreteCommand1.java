package com.janson653.designpattern.dp.command;

public class ConcreteCommand1 extends Command {
    Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
       this.receiver.doSomething();
    }
}
