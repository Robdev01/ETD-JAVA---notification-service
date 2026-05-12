package com.skillbase.notification_service.consumer;

import com.skillbase.notification_service.config.RabbitMQConstants;
import com.skillbase.notification_service.dto.EmailRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class EmailConsumer {

    @RabbitListener(
            queues = RabbitMQConstants.FILA_EMAIL
    )
    public void consumirMensagem(
            EmailRequestDTO emailRequestDTO
    ) {

        log.info(
                "MENSAGEM RECEBIDA DA FILA"
        );

        log.info(
                "NOME: {}",
                emailRequestDTO.nome()
        );

        log.info(
                "EMAIL: {}",
                emailRequestDTO.email()
        );

        log.info(
                "ASSUNTO: {}",
                emailRequestDTO.assunto()
        );

        log.info(
                "MENSAGEM: {}",
                emailRequestDTO.mensagem()
        );

        log.info(
                "PROCESSAMENTO FINALIZADO"
        );

        if (emailRequestDTO.email().contains("erro")) {

            throw new RuntimeException(
                    "ERRO SIMULADO"
            );
        }
    }

}
