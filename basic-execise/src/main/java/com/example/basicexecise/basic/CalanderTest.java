package com.example.basicexecise.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalanderTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        System.out.println(calendar.getTime());
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.forEach(System.err::println);
    }
}
