package com.skillbase.notification_service.producer;

import com.skillbase.notification_service.config.RabbitMQConstants;
import com.skillbase.notification_service.dto.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class EmailProducer {

    private final RabbitTemplate rabbitTemplate;

    public void enviarEmail(
            EmailRequestDTO emailRequestDTO
    ) {

        System.out.println(
                "PUBLICANDO MENSAGEM NA FILA"
        );

        rabbitTemplate.convertAndSend(
                RabbitMQConstants.EXCHANGE_EMAIL,
                RabbitMQConstants.ROUTING_KEY_EMAIL,
                emailRequestDTO
        );

        System.out.println(
                "MENSAGEM PUBLICADA COM SUCESSO"
        );
    }

}
