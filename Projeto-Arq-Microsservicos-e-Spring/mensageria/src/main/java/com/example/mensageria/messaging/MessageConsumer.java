package com.example.mensageria.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "notificationQueue")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
        
    }
}