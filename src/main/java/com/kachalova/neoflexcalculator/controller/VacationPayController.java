package com.kachalova.neoflexcalculator.controller;

import com.kachalova.neoflexcalculator.dto.VacationPayRequest;
import com.kachalova.neoflexcalculator.service.VacationCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VacationPayController {

    private final VacationCalculatorService calculatorService;

    @GetMapping("/calculate")
    public BigDecimal calculate(@Valid VacationPayRequest vacationPayRequest) {
        log.info("/calculate request:{}", vacationPayRequest);
        BigDecimal vacationPayResponse = calculatorService.calculate(vacationPayRequest);
        log.info("/calculate response:{}", vacationPayResponse);
        return vacationPayResponse;
    }


}
