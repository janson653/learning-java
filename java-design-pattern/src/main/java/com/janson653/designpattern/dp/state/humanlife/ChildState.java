package com.janson653.designpattern.dp.state.humanlife;

public class ChildState extends HumanState {
    @Override
    public void work() {
        System.out.println("Child play");
        super.human.setCurrentState(Human.ADULT_STATE);

        // 触发下一状态
        this.human.work();
    }
}
