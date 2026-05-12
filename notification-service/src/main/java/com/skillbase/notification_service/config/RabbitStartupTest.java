package com.skillbase.notification_service.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitStartupTest implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public RabbitStartupTest(
            RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {

        System.out.println("TESTANDO CONEXAO RABBITMQ");

        rabbitTemplate.convertAndSend(
                RabbitMQConstants.EXCHANGE_EMAIL,
                RabbitMQConstants.ROUTING_KEY_EMAIL,
                "TESTE"
        );

        System.out.println("MENSAGEM ENVIADA");
    }
}
