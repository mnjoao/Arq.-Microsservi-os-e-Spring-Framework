package com.example.produtos.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @RabbitListener(queues = "productQueue")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida do RabbitMQ: " + message);

    }
}