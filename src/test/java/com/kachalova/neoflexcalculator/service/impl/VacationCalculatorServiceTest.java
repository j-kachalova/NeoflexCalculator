package com.kachalova.neoflexcalculator.service.impl;

import com.kachalova.neoflexcalculator.dto.VacationPayRequest;
import com.kachalova.neoflexcalculator.service.VacationCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class VacationCalculatorServiceTest {
    @Autowired
    private VacationCalculatorService service;


    @Test
    void testCalculateByVacationDays() {
        VacationPayRequest request = VacationPayRequest.builder().averageSalary(BigDecimal.valueOf(50000)).vacationDays(8).build();

        BigDecimal result = service.calculate(request);
        assertEquals(BigDecimal.valueOf(13651.84), result);
    }

    @Test
    void testCalculateByDatesWithoutHolidays() {
        VacationPayRequest request = new VacationPayRequest();
        request.setAverageSalary(BigDecimal.valueOf(50000));
        request.setStartDate(LocalDate.of(2025, 4, 1));
        request.setEndDate(LocalDate.of(2025, 4, 10));

        BigDecimal result = service.calculate(request);
        // Зависит от количества рабочих дней в интервале
        assertEquals(BigDecimal.valueOf(13651.84), result);
    }
}
