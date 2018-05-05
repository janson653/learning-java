package com.example.javadesignpattern.dp.state.humanlife;

public class Client {
    public static void main(String[] args) {
        Human human = new Human();
        human.setCurrentState(Human.CHILD_STATE);
        human.work();
        //human.work();
        //human.work();
    }
}
