package edu.miu.nomin.jpa.util;

import java.time.LocalDate;
import java.time.Month;

public class QuarterUtil {
    public static LocalDate getNextQuarterStart() {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int year = now.getYear();

        if (currentMonth <= 3) return LocalDate.of(year, 4, 1);
        if (currentMonth <= 6) return LocalDate.of(year, 7, 1);
        if (currentMonth <= 9) return LocalDate.of(year, 10, 1);
        return LocalDate.of(year + 1, 1, 1);
    }

    public static LocalDate getNextQuarterEnd() {
        LocalDate start = getNextQuarterStart();
        return start.plusMonths(3).minusDays(1);
    }
}
