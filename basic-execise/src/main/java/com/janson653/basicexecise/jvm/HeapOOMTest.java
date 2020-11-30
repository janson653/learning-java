package com.janson653.basicexecise.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOMTest {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        while (true) {
            //Thread.sleep(100);
            //list.add(new Object());
        }
    }
}
