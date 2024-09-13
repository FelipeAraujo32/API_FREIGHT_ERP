package com.freight.freight_api.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.freight.freight_api.Services.FreightModelService;
import com.freight.freight_api.dtos.DistanceCalculatedDto;

@Component
public class DistanceCalculatedEvent {

    private final FreightModelService freightModelService;

    public DistanceCalculatedEvent(FreightModelService freightModelService) {
        this.freightModelService = freightModelService;
    }

    @RabbitListener(queues = "distance.calculated.queue")
    public void handleDistanceCalculated(DistanceCalculatedDto distanceCalculatedDto){
        freightModelService.calculateFreight(distanceCalculatedDto);
    }
}
