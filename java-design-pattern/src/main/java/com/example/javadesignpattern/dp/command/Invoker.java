package com.example.javadesignpattern.dp.command;

public class Invoker {
    Command command;
    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
