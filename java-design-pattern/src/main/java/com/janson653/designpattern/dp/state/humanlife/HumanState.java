package com.janson653.designpattern.dp.state.humanlife;

public abstract class HumanState {
    protected Human human;
    public void setHuman(Human human) {
        this.human = human;
    }
    public abstract void work();
}
