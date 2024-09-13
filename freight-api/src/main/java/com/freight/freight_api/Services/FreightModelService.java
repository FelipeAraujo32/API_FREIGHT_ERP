package com.freight.freight_api.Services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.freight.freight_api.Services.freghtcalculator.FreightCalculatorSelector;
import com.freight.freight_api.converter.FreightConvert;
import com.freight.freight_api.dtos.DistanceCalculatedDto;
import com.freight.freight_api.dtos.FreightModelDto;
import com.freight.freight_api.messaging.producer.FreightValueEvent;
import com.freight.freight_api.models.FreightModel;
import com.freight.freight_api.repository.FreightModelRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class FreightModelService {

    private final FreightCalculatorSelector freightCalculatorSelector;
    private final FreightModelRepository freightModelRepository;
    private final FreightValueEvent freightValueEvent;
    private final FreightConvert freightConvert;

    public FreightModelService(FreightCalculatorSelector freightCalculatorSelector,
            FreightModelRepository freightModelRepository, FreightValueEvent freightValueEvent,
            FreightConvert freightConvert) {
        this.freightCalculatorSelector = freightCalculatorSelector;
        this.freightModelRepository = freightModelRepository;
        this.freightValueEvent = freightValueEvent;
        this.freightConvert = freightConvert;
    }

    public void calculateFreight(@Valid DistanceCalculatedDto distanceCalculatedDto) {
        double calculated = calculationBasedOnDistance(distanceCalculatedDto.getDistance());
        FreightModel freightModel = saveOrUpdateFreight(distanceCalculatedDto.getOrderId(), calculated);
        sendFreightValueEvent(freightModel);
    }

    private double calculationBasedOnDistance(double distanceKm) {
        return freightCalculatorSelector.calculateFreight(distanceKm);
    }

    private FreightModel saveOrUpdateFreight(UUID orderId, double freightValue) {
        return findByOrderId(orderId)
                .map(existingFreight -> updateFreight(existingFreight, freightValue))
                .orElseGet(() -> saveFreightCalculation(orderId, freightValue));
    }

    @Transactional
    private FreightModel updateFreight(FreightModel existingFreight, double freightValue){
        existingFreight.setFreightValue(freightValue);
        return freightModelRepository.save(existingFreight);
    }

    @Transactional
    private FreightModel saveFreightCalculation(UUID orderId, double freightValue) {
        FreightModel freightModel = new FreightModel(orderId, freightValue);
        return freightModelRepository.save(freightModel);
    }

    private Optional<FreightModel> findByOrderId(UUID orderId) {
        return freightModelRepository.findByOrderId(orderId);
    }

    private void sendFreightValueEvent(FreightModel freightModel) {
        FreightModelDto freightModelDto = freightConvert.toFreightModel(freightModel);
        freightValueEvent.freightValue(freightModelDto);
    }
}
