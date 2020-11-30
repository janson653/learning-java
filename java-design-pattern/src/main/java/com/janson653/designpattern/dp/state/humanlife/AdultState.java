package com.janson653.designpattern.dp.state.humanlife;

public class AdultState extends HumanState{

    @Override
    public void work() {
        System.out.println("adult make moneny");
        super.human.setCurrentState(Human.OLD_STATE);

        // 触发下一状态
        this.human.work();
    }
}
