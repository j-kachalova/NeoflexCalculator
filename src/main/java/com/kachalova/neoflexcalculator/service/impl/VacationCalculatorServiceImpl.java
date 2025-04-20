package com.kachalova.neoflexcalculator.service.impl;

import com.kachalova.neoflexcalculator.dto.VacationPayRequest;
import com.kachalova.neoflexcalculator.service.VacationCalculatorService;
import com.kachalova.neoflexcalculator.utils.DaysCounter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Service
public class VacationCalculatorServiceImpl implements VacationCalculatorService {
    private static final double AVERAGE_DAYS_IN_MOUNT = 29.3;

    @Override
    public BigDecimal calculate(VacationPayRequest vacationPayRequest) {
        log.info("VacationCalculatorServiceImpl: vacationPayRequest:{}", vacationPayRequest);
        int amountPaidDays;
        if (vacationPayRequest.getStartDate() != null && vacationPayRequest.getEndDate() != null) {
            amountPaidDays = DaysCounter.countPaidDays(vacationPayRequest.getStartDate(), vacationPayRequest.getEndDate());
        } else if (vacationPayRequest.getDays() != null) {
            amountPaidDays = vacationPayRequest.getDays();
        } else {
            log.error("DECLINED: Vacation days or start/end dates must be provided");
            throw new IllegalArgumentException("Vacation days or start/end dates must be provided.");
        }
        BigDecimal averageSalaryPerDay = vacationPayRequest.getSalary()
                .divide(BigDecimal.valueOf(AVERAGE_DAYS_IN_MOUNT), 2, RoundingMode.HALF_UP);
        BigDecimal vacationPayResponse = averageSalaryPerDay.multiply(BigDecimal.valueOf(amountPaidDays));
        log.info("VacationCalculatorServiceImpl: vacationPayResponse:{}", vacationPayResponse);
        return vacationPayResponse;
    }
}
