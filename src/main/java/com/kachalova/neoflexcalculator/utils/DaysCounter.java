package com.kachalova.neoflexcalculator.utils;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DaysCounter {
    private final static int CURRENT_YEAR = LocalDate.now().getYear();
    private static final Set<LocalDate> HOLIDAYS = new HashSet<>();

    static {
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 1));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 2));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 3));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 4));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 5));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 6));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 7));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 1, 8));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 2, 23));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 3, 8));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 5, 1));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 5, 9));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 6, 12));
        HOLIDAYS.add(LocalDate.of(CURRENT_YEAR, 11, 4));
    }

    public static int countPaidDays(LocalDate startVacationDate, LocalDate endVacationDate) {

        int workingDays = 0;

        for (LocalDate date = startVacationDate; !date.isAfter(endVacationDate); date = date.plusDays(1)) {
            if (isWorkingDay(date)) workingDays++;
        }
        return workingDays;
    }

    private static boolean isWorkingDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY ||
                HOLIDAYS.contains(date));
    }
}
