package com.kachalova.neoflexcalculator.service;

import com.kachalova.neoflexcalculator.dto.VacationPayRequest;

import java.math.BigDecimal;


public interface VacationCalculatorService {
    public BigDecimal calculate(VacationPayRequest vacationPayRequest);
}
