package com.freight.freight_api.Services.freghtcalculator;

public interface FreightCalculator {
    
    boolean appliesTo(double distance);
    double calculate(double distance);
}
