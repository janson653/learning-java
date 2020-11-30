package com.janson653.designpattern.dp.state.humanlife;

public class Human {
    public static final HumanState CHILD_STATE = new ChildState();
    public static final HumanState ADULT_STATE = new AdultState();
    public static final HumanState OLD_STATE = new OldState();

    private HumanState currentState;

    public void setCurrentState(HumanState state) {
        this.currentState = state;
        //must set this
        this.currentState.setHuman(this);
    }

    public void work() {
        this.currentState.work();
    }
}
