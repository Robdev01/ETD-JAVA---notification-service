package com.skillbase.notification_service.config;

import com.rabbitmq.client.ConnectionFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @PostConstruct
    public void init() {
        System.out.println("QUEUE CONFIG CARREGADA");
    }

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

    @Bean
    public RabbitTemplate rabbitTemplate(
            org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory
    ) {

        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(
                messageConverter()
        );

        return rabbitTemplate;
    }

    @Bean
    public AmqpAdmin amqpAdmin(
            org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory
    ) {

        return new RabbitAdmin(connectionFactory);
    }

}