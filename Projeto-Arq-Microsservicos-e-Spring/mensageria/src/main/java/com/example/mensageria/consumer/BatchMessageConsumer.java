package com.example.mensageria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchMessageConsumer {

    @RabbitListener(queues = "notificationQueue")
    public void receiveMessages(List<String> messages) {
        System.out.println("Processando lote de mensagens: " + messages);
    }
}