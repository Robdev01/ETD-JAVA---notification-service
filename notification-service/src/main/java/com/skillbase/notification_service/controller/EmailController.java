package com.skillbase.notification_service.controller;

import com.skillbase.notification_service.dto.EmailRequestDTO;
import com.skillbase.notification_service.dto.EmailResponseDTO;
import com.skillbase.notification_service.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<EmailResponseDTO> enviarEmail(

            @RequestBody
            @Valid
            EmailRequestDTO dto
    ) {

        emailService.processarEnvioEmail(
                dto
        );

        EmailResponseDTO response =
                EmailResponseDTO.builder()
                        .mensagem(
                                "E-mail enviado para processamento"
                        )
                        .protocolo(
                                UUID.randomUUID().toString()
                        )
                        .build();



        return ResponseEntity.ok(
                response
        );
    }

}
