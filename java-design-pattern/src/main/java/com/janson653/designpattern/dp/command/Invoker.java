package com.janson653.designpattern.dp.command;

public class Invoker {
    Command command;
    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
