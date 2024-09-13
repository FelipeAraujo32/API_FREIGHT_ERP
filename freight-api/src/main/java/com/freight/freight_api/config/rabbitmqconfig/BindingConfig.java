package com.freight.freight_api.config.rabbitmqconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BindingConfig {
    
    @Bean
    public Binding bindingFreightCalculatedQueue(@Qualifier("freightCalculatedQueue") Queue freightCalculatedQueue, TopicExchange freightExchange) {
        return BindingBuilder.bind(freightCalculatedQueue).to(freightExchange).with("freight.calculated.event");
    }
}
