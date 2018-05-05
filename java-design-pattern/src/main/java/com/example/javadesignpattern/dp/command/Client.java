package com.example.javadesignpattern.dp.command;

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new ConcreteReceiver1();

        Command command = new ConcreteCommand2(receiver);

        Invoker invoker = new Invoker();

        invoker.setCommand(command);

        invoker.action();
    }
}
