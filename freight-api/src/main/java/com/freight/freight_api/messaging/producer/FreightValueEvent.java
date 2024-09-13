package com.freight.freight_api.messaging.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.freight.freight_api.dtos.FreightModelDto;

@Component
public class FreightValueEvent {
    
    private final RabbitTemplate rabbitTemplate;

    public FreightValueEvent(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void freightValue(FreightModelDto freightModelDto){
        rabbitTemplate.convertAndSend(
            "freight.exchange",
            "freight.calculated.event",
            freightModelDto
        );
    }
}
