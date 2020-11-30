package com.janson653.designpattern.dp.decorator;

public class BeautifyAppearance extends Decorator {
    public BeautifyAppearance(Swan swan) {
        super(swan);
    }

    @Override
    public void desAppaearance() {
        System.out.println("颜色变白,好看了");
    }
}
