package com.skillbase.notification_service.config;

public class RabbitMQConstants {
    private RabbitMQConstants() {}

    public static final String FILA_EMAIL = "fila.email";

    public static final String EXCHANGE_EMAIL = "exchange.email";

    public static final String ROUTING_KEY_EMAIL = "routing.email";

    // DLQ
    public static final String FILA_EMAIL_DLQ = "fila.email.dlq";

    public static final String EXCHANGE_EMAIL_DLQ = "exchange.email.dlq";

    public static final String ROUTING_KEY_EMAIL_DLQ = "routing.email.dlq";

}

