package com.skillbase.notification_service.dto;

import lombok.Builder;


@Builder
public record EmailResponseDTO(
        String mensagem,
        String protocolo

    ) {

}
