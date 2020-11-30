package com.janson653.basicexecise.basic;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class UsefulDateTest {
    public static void main(String[] args) {
        // Date, Calander, LocalDateTime

        //获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime :" + localDateTime);
        //格式化输出时间，线程安全的格式化类
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月d日 hh:mm:ss");
        System.out.println("format :" + dateTimeFormatter.format(localDateTime));
        //  获取当前年份
        Year year = Year.of(2019);
        System.out.println("year :" + year);
        //   从Year获取LocalDate
        LocalDate localDate = year.atDay(41);
        System.out.println("localDate :" + localDate);
        //  把LocalTime关联到一个LocalDate得到一个LocalDateTime
        LocalTime localTime = LocalTime.of(12,0);
        LocalDateTime localDateTime1 = localTime.atDate(localDate);
        System.out.println("localDateTime1 :" + dateTimeFormatter.format(localDateTime1));
        //  判断是否是闰年
        System.out.println("isLeapYear :" + localDate.isLeapYear());


        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println("dayOfWeek :" + dayOfWeek);
        //计算两个日期之间时间，还可以按其他时间单位计算两个时间点之间的间隔。
        long between = ChronoUnit.HOURS.between(LocalDateTime.of(2019,2,10,22,0),
                LocalDateTime.of(2019,2,9,22,0));
        System.out.println("between :" + between);
        //  解析字符串形式的日期时间
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy MM d");
        TemporalAccessor temporalAccessor = dateTimeFormatter2.parse("2019 01 31");
        System.out.println("temporalAccessor :" + LocalDate.from(temporalAccessor));
        //计算某月的第一天的日期
        LocalDate with =  localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("with :" + with);
        // 计算某月的第一个星期一的日期
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate with1 = localDate.with(temporalAdjuster);
        System.out.println("with1 :" + with1);
        // 计算localDate的下一个星期一的日期
        LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("with2 :" + with2);
    }
}
