package com.skillbase.notification_service.service;


import com.skillbase.notification_service.dto.EmailRequestDTO;
import com.skillbase.notification_service.producer.EmailProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailProducer emailProducer;

    public void processarEnvioEmail(
            EmailRequestDTO emailRequestDTO
    ) {

        System.out.println(
                "PROCESSANDO ENVIO DE EMAIL"
        );

        emailProducer.enviarEmail(
                emailRequestDTO
        );
    }

}
