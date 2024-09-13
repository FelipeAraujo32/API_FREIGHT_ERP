package com.freight.freight_api.config.rabbitmqconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    
    @Bean
    public Queue freightCalculatedQueue() {
        return new Queue("freight.calculated.queue", true);
    }

    @Bean
    public TopicExchange freightExchange() {
        return new TopicExchange("freight.exchange");
    }
}
