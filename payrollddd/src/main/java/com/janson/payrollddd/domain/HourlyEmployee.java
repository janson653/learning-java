package com.janson.payrollddd.domain;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HourlyEmployee extends Employee {
    private final static int OVER_TIME_HOURS = 8;
    private final List<TimeCard> timeCards = new LinkedList<>();
    private final double hourlySalary;

    public HourlyEmployee(EmployeeId employId, String name, Integer sex, LocalDate onboardDate, double hourlySalary) {
        super(employId, name, sex, onboardDate);
        this.hourlySalary = hourlySalary;
    }

    public void submitTimeCard(TimeCard card) {
        if (card == null) {
            throw new RuntimeException();
        }
        this.timeCards.add(card);
    }

    @Override
    public PayRoll calPayRoll(SettlementPeriod settlementPeriod) {
        // no work, salary is 0
        if (timeCards.isEmpty()) {
            return new PayRoll(this.getEmployId(), settlementPeriod.getBeginDate(),
                    settlementPeriod.getEndDate(), 0.0);
        }
        List<TimeCard> needCalCards = filterNeedCalCards(settlementPeriod);

        double money = calSalary(needCalCards);
        return new PayRoll(getEmployId(), settlementPeriod.getBeginDate(), settlementPeriod.getEndDate(), money);
    }

    private double calSalary(List<TimeCard> needCalCards) {
        double money = 0;
        for (TimeCard card : needCalCards) {
            if (card.isOverTime(OVER_TIME_HOURS)) {
                money = money + (OVER_TIME_HOURS * hourlySalary) + (card.calOverHours(OVER_TIME_HOURS) * hourlySalary * 1.5);
            } else {
                money = money + card.getWorkHours() * hourlySalary;
            }
        }
        return money;
    }

    private List<TimeCard> filterNeedCalCards(SettlementPeriod settlementPeriod) {
        return timeCards.stream().filter(card -> settlementPeriod.contains(card.getWorkDay()))
                .collect(Collectors.toList());
    }


    public static class TimeCard {
        private final LocalDate workDay;
        private final int workHours;

        public TimeCard(LocalDate workDay, int workHours) {
            this.workDay = workDay;
            this.workHours = workHours;
        }

        public LocalDate getWorkDay() {
            return workDay;
        }

        public int getWorkHours() {
            return workHours;
        }

        public boolean isOverTime(int overTimeHours) {
            return workHours > overTimeHours;
        }

        public int calOverHours(int overTimeHours) {
            return workHours - overTimeHours;
        }
    }
}
