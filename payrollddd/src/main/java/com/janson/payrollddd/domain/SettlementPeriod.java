package com.janson.payrollddd.domain;

import java.time.LocalDate;

public class SettlementPeriod {
    private final LocalDate beginDate;
    private final LocalDate endDate;

    public SettlementPeriod(LocalDate beginDate, LocalDate endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public static SettlementPeriod calSettlementPeriod(LocalDate localDate) {
        // todo
        return null;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean contains(LocalDate calDate) {
        if (calDate.isEqual(beginDate) || calDate.isEqual(endDate)) {
            return true;
        }
        return calDate.isAfter(beginDate) && calDate.isBefore(endDate);
    }
}
