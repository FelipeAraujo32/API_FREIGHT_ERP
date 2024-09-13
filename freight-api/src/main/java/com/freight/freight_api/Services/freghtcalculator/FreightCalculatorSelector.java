package com.freight.freight_api.Services.freghtcalculator;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FreightCalculatorSelector {

    private final List<FreightCalculator> freightCalculators;

    public FreightCalculatorSelector(List<FreightCalculator> freightCalculators) {
        this.freightCalculators = freightCalculators;
    }

    public double calculateFreight(double distance) {
        return freightCalculators.stream()
                .filter(freightCalculators -> freightCalculators.appliesTo(distance))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No strategy found for this distance"))
                .calculate(distance);
    }
}
