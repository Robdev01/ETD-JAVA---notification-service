package com.skillbase.notification_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public Queue filaEmail() {

        return QueueBuilder
                .durable(RabbitMQConstants.FILA_EMAIL)
                .build();
    }

    @Bean
    public DirectExchange exchangeEmail() {

        return new DirectExchange(
                RabbitMQConstants.EXCHANGE_EMAIL
        );
    }

    @Bean
    public Binding bindingEmail() {

        return BindingBuilder
                .bind(filaEmail())
                .to(exchangeEmail())
                .with(RabbitMQConstants.ROUTING_KEY_EMAIL);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

}
